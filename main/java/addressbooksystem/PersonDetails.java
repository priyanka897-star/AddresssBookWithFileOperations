package addressbooksystem;

import java.util.Objects;
import java.io.Serializable;
public class PersonDetails {

	@Override
	public int hashCode() {
		return Objects.hash( firstName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonDetails other = (PersonDetails) obj;
		return  Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName);
	}




	private String  firstName, lastName, address, city, state, email, zip, phoneNumber;
	
	
	public  String getFirstName() {
		return firstName;
	}

	public void setFirstName(String contactFirstName) {
		this.firstName = contactFirstName;
	}
	

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String contactLastName) {
		this.lastName = contactLastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String contactAddress) {
		this.address = contactAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String contactCity) {
		this.city = contactCity;
	}

	public String getState() {
		return state;
	}

	public void setState(String contactState) {
		this.state = contactState;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String contactEmail) {
		this.email = contactEmail;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String contactZip) {
		this.zip = contactZip;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String contactPhoneNumber) {
		this.phoneNumber = contactPhoneNumber;
		
	}
	
	
	@Override
	public String toString() {
		return "AddressBook [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city="
				+ city + ", state=" + state + ", email=" + email + ", zip=" + zip + ", phoneNumber=" + phoneNumber
				+ "]";
	}

}

