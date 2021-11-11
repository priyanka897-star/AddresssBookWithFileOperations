package addressbooksystem;

import java.util.ArrayList;
import java.util.HashMap;

public class ContactMain {

	static HashMap<Integer, ArrayList<AddContact>> hashMap = new HashMap<Integer, ArrayList<AddContact>>();
	static InputScanner inputScanner = new InputScanner();
	static AddContact addContact = new AddContact();

	public static void main(String[] args) {

		System.out.println("enter the address book limit");
		int addressBookLimit = inputScanner.inputInteger();
		for (int i = 1; i <= addressBookLimit; i++) {
			System.out.println("enter name of addressbook");
			String addressBookName = inputScanner.inputString();
			System.out.println("Addres book name is :" + addressBookName);
			ArrayList<AddContact> addContactDetails = new ArrayList<>();
			while (true) {
				AddContact addPersonDetails = new AddContact();
				System.out.printf(
						"Input  01 to add Details, 02 to Edit details, 03 to delete details . \n Enter any  single Digit Number   to Ignore");
				int options = inputScanner.inputInteger();
				if (options == 01 || options == 02 || options == 03 ) {
					switch (options) {
					case 01:
						addPersonDetails.setContactDetails();
						boolean checkDuplicate = addPersonDetails.checkDuplicate(addContactDetails, addPersonDetails);
						if (!checkDuplicate)
							addContactDetails.add(addPersonDetails);
						else
							System.out.println("Dont enter duplicate entry");
						break;

					case 02:
						System.out.println("Enter the name to edit");
						addPersonDetails.editDetails(addContactDetails);
						break;
					case 03:
						addPersonDetails.deleteDetails(addContactDetails);
						break;

					default:
						System.out.println("you have not perform any operation");
						break;
					}

				} else {
					System.out.println("Details are uptodate");
					break;
				}
			}
			hashMap.put(i, addContactDetails);
			AddContact.writeToFile(hashMap);
			AddContact.writeToFileInOpenCsv(addContactDetails);
			AddContact.writeToFileInJson(addContactDetails);
		}
		for (int i = 1; i <= hashMap.size(); i++) {
			System.out.println("address book " + i);
			System.out.println(hashMap.get(i));
		}
               AddContact.search(hashMap);
	       System.out.println("Reading AddressBook from File");
               AddContact.readFromFile();
	       System.out.println();
	       System.out.println("Reading AddressBook from CSV");
	       AddContact.readFromFileInOpenCsv();
       	       System.out.println();
	       System.out.println("Reading AddressBook using JSON");
               AddContact.readFromFileInJson();
	       System.out.println();
               System.out.println("AddressBooks Sorted based on First Name :");
               AddContact.sort(hashMap,SortOptions.NAME);
               System.out.println("AddressBooks Sorted based on city :");
               AddContact.sort(hashMap,SortOptions.CITY);
               System.out.println("AddressBooks Sorted based on state :");
               AddContact.sort(hashMap,SortOptions.STATE);
               System.out.println("AddressBooks Sorted based on Zip :");
               AddContact.sort(hashMap,SortOptions.ZIP);
	}
}
