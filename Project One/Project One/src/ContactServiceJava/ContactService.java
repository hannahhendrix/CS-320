package ContactServiceJava;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    // Using a HashMap to store contacts, keyed by their unique id
    public Map<String, Contact> contactMap = new HashMap<>();

    // Add a contact to the service
    public boolean addContact(Contact contact) {
        if(contactMap.containsKey(contact.getContactId())) {
            // Ensure contact IDs are unique
            throw new IllegalArgumentException("Contact ID already exists");
        }
        contactMap.put(contact.getContactId(), contact);
        return true;
    }

    // Delete a contact by ID
    public boolean deleteContact(String contactId) {
        if(contactMap.remove(contactId) != null) {
            return true;
        } else {
            throw new IllegalArgumentException("Contact ID not found");
        }
    }

    // Update a contact's first name
    public boolean updateFirstName(String contactId, String newFirstName) {
        Contact contact = contactMap.get(contactId);
        if(contact != null) {
            if (newFirstName == null || newFirstName.length() > 10) {
                throw new IllegalArgumentException("Invalid First Name");
            }
            contactMap.get(contactId).firstName = newFirstName;
            return true;
        } else {
            throw new IllegalArgumentException("Contact ID not found");
        }
    }

    // Update a contact's last name
    public boolean updateLastName(String contactId, String newLastName) {
        Contact contact = contactMap.get(contactId);
        if(contact != null) {
            if (newLastName == null || newLastName.length() > 10) {
                throw new IllegalArgumentException("Invalid Last Name");
            }
            contactMap.get(contactId).lastName = newLastName;
            return true;
        } else {
            throw new IllegalArgumentException("Contact ID not found");
        }
    }

    // Update a contact's phone number
    public boolean updateNumber(String contactId, String newNumber) {
        Contact contact = contactMap.get(contactId);
        if(contact != null) {
            if (newNumber == null || newNumber.length() != 10) {
                throw new IllegalArgumentException("Invalid Phone Number");
            }
            contactMap.get(contactId).number = newNumber;
            return true;
        } else {
            throw new IllegalArgumentException("Contact ID not found");
        }
    }

    // Update a contact's address
    public boolean updateAddress(String contactId, String newAddress) {
        Contact contact = contactMap.get(contactId);
        if(contact != null) {
            if (newAddress == null || newAddress.length() > 30) {
                throw new IllegalArgumentException("Invalid Address");
            }
            contactMap.get(contactId).address = newAddress;
            return true;
        } else {
            throw new IllegalArgumentException("Contact ID not found");
        }
    }
}