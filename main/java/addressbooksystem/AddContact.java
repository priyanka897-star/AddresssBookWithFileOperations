package addressbooksystem;

import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AddContact extends PersonDetails {

	private static AddContact HashMap;

	ArrayList<AddContact> addContactDetails;
	InputScanner inputScanner = new InputScanner();
	ContactMain contact = new ContactMain();

	public void setContactDetails() {
		System.out.println("enter the First Name");
		setFirstName(inputScanner.inputString());
		System.out.println("enter the Last Name");
		setLastName(inputScanner.inputString());
		System.out.println("enter the Address Name");
		setAddress(inputScanner.inputString());
		System.out.println("enter the City Name");
		setCity(inputScanner.inputString());
		System.out.println("enter the State Name");
		setState(inputScanner.inputString());
		System.out.println("enter the Phone Number");
		setPhoneNumber(inputScanner.inputString());
		System.out.println("enter the Zip/postal Code");
		setZip(inputScanner.inputString());
		System.out.println("enter the Email");
		setEmail(inputScanner.inputString());
	}

	public ArrayList<AddContact> getContactDetails() {
		getFirstName();
		getLastName();
		getAddress();
		getCity();
		getState();
		getPhoneNumber();
		getZip();
		getEmail();
		return addContactDetails;
	}

	public void editDetails(ArrayList<AddContact> contatctDetails) {
		String name = inputScanner.inputString();
		System.out.println(contatctDetails.size());
		for (int i = 0; i < contatctDetails.size(); i++) {
			if (contatctDetails.get(i).getFirstName().equals(name)) {
				System.out.printf(
						"enter the number to update contact details 1 First Name 2 to update Last Name 3 to phone number 4 to pincode 5 to address 6 to email 7 to state 8 to city");
				int updateChoice = inputScanner.inputInteger();
				inputScanner.inputInteger();

				switch (updateChoice) {
				case 1:
					System.out.println("enter the name to update");
					String fName = inputScanner.inputString();
					contatctDetails.get(i).setFirstName(fName);
					break;
				case 2:
					System.out.println("enter the Last name to update");
					String lName = inputScanner.inputString();
					contatctDetails.get(i).setLastName(lName);
					break;
				case 3:
					System.out.println("enter the Phone Number to Update");
					String phNumber = inputScanner.inputString();
					contatctDetails.get(i).setPhoneNumber(phNumber);
					break;
				case 4:
					System.out.println("enter the Pincode/Postalcode to Update");
					String pinCode = inputScanner.inputString();
					contatctDetails.get(i).setZip(pinCode);
					break;
				case 5:
					System.out.println("enter the Address to Update");
					String address = inputScanner.inputString();
					contatctDetails.get(i).setAddress(address);
					break;
				case 6:
					System.out.println("enter the Email to Update");
					String email = inputScanner.inputString();
					contatctDetails.get(i).setEmail(email);
					break;
				case 7:
					System.out.println("enter the State to Update");
					String state = inputScanner.inputString();
					contatctDetails.get(i).setState(state);
					break;
				case 8:
					System.out.println("enter the City to Update");
					String city = inputScanner.inputString();
					contatctDetails.get(i).setState(city);
					break;

				default:
					System.out.println("you have not update any details");
					break;
				}

			} else
				System.out.println("not match any details");
		}
	}

	public void deleteDetails(ArrayList<AddContact> contatctDetails) {
		System.out.println("enter the name");
		String name = inputScanner.inputString();
		for (int i = 0; i < contatctDetails.size(); i++) {
			if (contatctDetails.get(i).getFirstName().equals(name)) {
				contatctDetails.remove(i);

			} else
				System.out.println("not match any details");
		}
	}

	public boolean checkDuplicate(ArrayList<AddContact> addContactDetails2, AddContact addPersonDetails) {

		boolean check = false;
		for (AddContact contact : addContactDetails2) {
			if (addPersonDetails.getFirstName().equals(contact.getFirstName()))
				check = true;
		}
		return check;
	}

	public static void sort(HashMap<Integer,ArrayList<AddContact>> hashMap,SortOptions sortOptions){
        for (int i = 1; i <= hashMap.size(); i++){
        	hashMap.get(i).stream().sorted(sortOptions.comparator).forEach(System.out::println);
        }
    }

	 public static void writeToFile(HashMap<Integer,ArrayList<AddContact>> hashMap) {
	        try{
	            FileWriter fileWriter = new FileWriter("addressbook.txt");
	            String stream = String.valueOf(hashMap);
	            fileWriter.write(stream);
	            fileWriter.close();
	        } catch (Exception e){
	            e.printStackTrace();
	        }
	    }

    public static  void writeToFileInOpenCsv(ArrayList<AddContact> contactDetails){
        try{
            FileWriter fileWriter = new FileWriter("addressbook.csv");
            CSVWriter csvWriter = new CSVWriter(fileWriter);
            String[] array = new String[contactDetails.size()];
            for (int i = 0; i < array.length; i++){
                array[i] = String.valueOf(contactDetails.get(i));
            }
            csvWriter.writeNext(array);
            csvWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

	public static void readFromFile(){
	        try{
	            FileReader fileReader = new FileReader("addressbook.txt");
	            int i;
	            while ((i = fileReader.read()) != -1){
	                System.out.print((char)i);}
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	    }
    public static void readFromFileInOpenCsv(){
		try{
			FileReader fileReader = new FileReader("AddressBook.csv");
			CSVReader csvReader = new CSVReader(fileReader);
			String[] strings;
			while ((strings = csvReader.readNext()) != null){
				for (String token : strings)
					System.out.print(token);
			}
			csvReader.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	public static void writeToFileInJson(ArrayList<AddContact> addContactDetails){
		try {
			Gson gson = new Gson();
			String stream = gson.toJson(addContactDetails);
			FileWriter fileWriter = new FileWriter("AddressBook.json");
			fileWriter.write(stream);
			fileWriter.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	public static void readFromFileInJson(){
		try {
			Gson gson = new Gson();
			BufferedReader br = new BufferedReader(new FileReader("AddressBook.json"));
			ArrayList<AddContact> arrayList = gson.fromJson(br, ArrayList.class);
			System.out.println(arrayList);
		}catch (Exception e){
			e.printStackTrace();
		}
	}


	public static void search(HashMap<Integer, ArrayList<AddContact>> hashMap) {
		InputScanner inputScanner = new InputScanner();
		long count ;
		long totalCount  = 0;
		System.out.println("enter the city or state name");
		String cityOrState = inputScanner.inputString();
		for (int i = 1; i <= ContactMain.hashMap.size(); i++) {
			List<AddContact> list = ContactMain.hashMap.get(i).stream().filter(c -> c.getCity().equalsIgnoreCase(cityOrState)||c.getState().equalsIgnoreCase(cityOrState)).collect(Collectors.toList());
			Predicate <AddContact> predicate = c -> c.getCity().contains(cityOrState)||c.getState().contains(cityOrState);
			count = list.stream().filter(predicate).count();
			System.out.println("List for city or state   " + list);
			totalCount = totalCount + count;
		}
		System.out.println("Total count : "+totalCount);
	}
}
