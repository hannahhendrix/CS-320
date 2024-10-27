package ContactServiceTest;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ContactServiceJava.Contact;

class ContactTest {
	
	@Test
	void testContact() {
		Contact contact = new Contact("12345", "Hannah", "Hendrix", "0123456789", "123 SNHU Drive");
		assertTrue(contact.getContactId().equals("12345"));
		assertTrue(contact.getFirstName().equals("Hannah"));
		assertTrue(contact.getLastName().equals("Hendrix"));
		assertTrue(contact.getNumber().equals("0123456789"));
		assertTrue(contact.getAddress().equals("123 SNHU Drive"));
	}

	@Test
	void testInvalidContactId() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Hannah", "Hendrix", "0123456789", "123 SNHU Drive");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("00123456789", "Hannah", "Hendrix", "0123456789", "123 SNHU Drive");
		});
	}
	
	@Test
	void testInvalidFirstName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", null, "Hendrix", "0123456789", "123 SNHU Drive");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Hannnnnnnah", "Hendrix", "0123456789", "123 SNHU Drive");
		});
	}
	
	@Test
	void testInvalidLastName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Hannah", null, "0123456789", "123 SNHU Drive");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Hannah", "Hendrixxxxx", "0123456789", "123 SNHU Drive");
		});
	}
	
	@Test
	void testInvalidPhone() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Hannah", "Hendrix", null, "123 SNHU Drive");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Hannah", "Hendrix", "012345678", "123 SNHU Drive");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Hannah", "Hendrix", "01234567890", "123 SNHU Drive");
		});
	}
	
	@Test
	void testInvalidAddress() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Hannah", "Hendrix", "0123456789", null);
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Hannah", "Hendrix", "0123456789", "012345678901234567890123456789");
		});
	}

}
