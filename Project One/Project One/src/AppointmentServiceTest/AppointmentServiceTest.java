package AppointmentServiceTest;

import AppointmentServiceJava.Appointment;
import AppointmentServiceJava.AppointmentService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class AppointmentServiceTest {

	private AppointmentService appointmentService;
	// Define a valid date for the initial appointment
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    Date date = new Date(); 
	
	@BeforeEach
	public void setUp() {
		appointmentService = new AppointmentService();
	}
	
	@Test
	public void testAddAppointment() {
		Appointment appointment = new Appointment("12345", date, "Description");
		assertTrue(appointmentService.addAppointment(appointment));
	}
	
	@Test
	public void testAddDupliateAppointment() {
		Appointment appointment = new Appointment("12345", date, "Description");
		appointmentService.addAppointment(appointment);
		assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.addAppointment(appointment);
		});
	}
	
	@Test
	public void testDeleteAppointment() {
		Appointment appointment = new Appointment("12345", date, "Description");
		appointmentService.addAppointment(appointment);
		assertTrue(appointmentService.deleteAppointment("12345"));
	}
	
	@Test
	public void testDeleteNonExistentAppointment() {
		assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.deleteAppointment("22345");
		});
	}
	
	@Test
	public void testUpdateDate() throws ParseException {
	    Date initialDate = sdf.parse("09/15/2025"); // Valid future date
		Appointment appointment = new Appointment("12345", initialDate, "Description");
		appointmentService.addAppointment(appointment);
		Date newDate = sdf.parse("10/01/2027");
		assertTrue(appointmentService.updateDate("12345", newDate));
		assertEquals(newDate, appointmentService.appointmentMap.get("12345").getDate());
	}
	
	@Test
	public void testUpdateDescription() {
		Appointment appointment = new Appointment("12345", date, "Description");
		appointmentService.addAppointment(appointment);
		assertTrue(appointmentService.updateDescription("12345", "New Description"));
		assertEquals("New Description", appointmentService.appointmentMap.get("12345").getDescription());
	}

}