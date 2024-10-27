package ContactServiceJava;

public class Contact {
	
	public String contactId;
	public String firstName; 
	public String lastName;
	public String number;
	public String address;
	
	public Contact(String contactId, String firstName, String lastName, String number, String address) {
		if(contactId == null || contactId.length() > 10) {
			//Verifies that id is not null, less than 10 characters, and cannot be updated
			throw new IllegalArgumentException("Invalid ID"); 
		}
		
		if(firstName == null || firstName.length() > 10) {
			//Verifies that firstName is not null and less than 10 characters
			throw new IllegalArgumentException("Invalid First Name");
		}
		
		if(lastName == null || lastName.length() > 10) {
			//Verifies that lastName is not null and less than 10 characters
			throw new IllegalArgumentException("Invalid Last Name");
		}
		
		if(number == null || number.length() != 10) {
			//Verifies that number is not null and is exactly 10 characters
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		
		if(address == null || address.length() > 30) {
			//Verifies that address is not null and is less than 30 characters
			throw new IllegalArgumentException("Invalid Address");
		}
		
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
		this.address = address;
	}
	
	public String getContactId() {
		return contactId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getNumber() {
		return number;
	}
	
	public String getAddress() {
		return address;
	}
}
