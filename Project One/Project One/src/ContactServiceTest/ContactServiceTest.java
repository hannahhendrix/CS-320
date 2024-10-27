package ContactServiceTest;

import ContactServiceJava.ContactService;
import ContactServiceJava.Contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class ContactServiceTest {

    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("12345", "Hannah", "Hendrix", "0123456789", "123 SNHU Drive");
        assertTrue(contactService.addContact(contact));
    }

    @Test
    public void testAddDuplicateContact() {
        Contact contact = new Contact("12345", "Hannah", "Hendrix", "0123456789", "123 SNHU Drive");
        contactService.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(contact);
        });
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("12345", "Hannah", "Hendrix", "0123456789", "123 SNHU Drive");
        contactService.addContact(contact);
        assertTrue(contactService.deleteContact("12345"));
    }

    @Test
    public void testDeleteNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("22345");
        });
    }

    @Test
    public void testUpdateFirstName() {
        Contact contact = new Contact("12345", "Hannah", "Hendrix", "0123456789", "123 SNHU Drive");
        contactService.addContact(contact);
        assertTrue(contactService.updateFirstName("12345", "Jane"));
        assertEquals("Jane", contactService.contactMap.get("12345").getFirstName());
    }
    
    @Test
    public void testUpdateLastName() {
        Contact contact = new Contact("12345", "Hannah", "Hendrix", "0123456789", "123 SNHU Drive");
        contactService.addContact(contact);
        assertTrue(contactService.updateLastName("12345", "Doe"));
        assertEquals("Doe", contactService.contactMap.get("12345").getLastName());
    }
    
    @Test
    public void testUpdateNumber() {
        Contact contact = new Contact("12345", "Hannah", "Hendrix", "0123456789", "123 SNHU Drive");
        contactService.addContact(contact);
        assertTrue(contactService.updateNumber("12345", "0123456789"));
        assertEquals("4171234567", contactService.contactMap.get("12345").getNumber());
    }
    
    @Test
    public void testUpdateAddress() {
        Contact contact = new Contact("12345", "Hannah", "Hendrix", "0123456789", "123 SNHU Drive");
        contactService.addContact(contact);
        assertTrue(contactService.updateAddress("12345", "456 SNHU Drive"));
        assertEquals("456 SNHU Drive", contactService.contactMap.get("12345").getAddress());
    }
}
