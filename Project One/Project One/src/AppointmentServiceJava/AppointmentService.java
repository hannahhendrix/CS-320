package AppointmentServiceJava;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;

public class AppointmentService {
	//Using a HashMap[ to store tasks, keyed by their unique id
	public Map<String, Appointment> appointmentMap = new HashMap<>();
	
	//Add an appointment to the service
	public boolean addAppointment(Appointment appointment) {
		if(appointmentMap.containsKey(appointment.getAppointmentId())) {
			//Ensure task IDs are unique
			throw new IllegalArgumentException("Appointment ID already exists");
		}
		appointmentMap.put(appointment.getAppointmentId(), appointment);
		return true;
	}
	
	//Delete an appointment by ID
	public boolean deleteAppointment(String appointmentId) {
		if(appointmentMap.remove(appointmentId) != null) {
			return true;
		}
		else {
			throw new IllegalArgumentException("Appointment ID not found");
		}
	}
	
	//Update an appointments date
	public boolean updateDate(String appointmentId, Date newDate) {
		Appointment appointment = appointmentMap.get(appointmentId);
		if(appointment != null) {
			if(newDate == null || newDate.before(new Date())) {
				throw new IllegalArgumentException("Invalid Date");
			}
			appointmentMap.get(appointmentId).date = newDate;
			return true;
		}
		else {
			throw new IllegalArgumentException("Appointment ID not found");
		}
	}
	
	//Update an appointments description
	public boolean updateDescription(String appointmentId, String newDescription) {
		Appointment appointment = appointmentMap.get(appointmentId);
		if(appointment != null) {
			if(newDescription == null || newDescription.length() > 50) {
				throw new IllegalArgumentException("invalid Description");
			}
			appointmentMap.get(appointmentId).description = newDescription;
			return true;
		}
		else {
			throw new IllegalArgumentException("Appointment ID not found");
		}
	}
}