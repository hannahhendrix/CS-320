package AppointmentServiceTest;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.text.SimpleDateFormat;

import AppointmentServiceJava.Appointment;


class AppointmentTest {
	
	//Create a specific date for testing
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	Date date = new Date(); //Current date for testing 

	@Test
	void testAppointment() {
		Appointment appointment = new Appointment("12345", date, "Description");
		assertTrue(appointment.getAppointmentId().equals("12345"));
		assertTrue(appointment.getDate().equals(date));
		assertTrue(appointment.getDescription().equals("Description"));
	}
	
	@Test
	void testInvalidAppointmentId() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, date, "Description");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("01234567890", date, "Description");
		});
	}
	
	@Test
	void testInvalidAppointmentDate() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345", null, "Description");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			//Set past date 
			Date pastDate = sdf.parse("1/01/2020");
			new Appointment("12345", pastDate, "Description");
		});
	}
	
	@Test
	void testInvalidTaskDescription() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345", date, null);
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345", date, "012345678901234567890123456789012345678901234567890");
		});
	}
}