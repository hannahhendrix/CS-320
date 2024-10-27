//Author Name: Hannah Hendrix

//Date: 10/6/2024

//Course ID: CS-320

//Description: Module 5 Milestone: Appointment Service

package AppointmentServiceJava;

import java.util.Date;

public class Appointment {
	
	public String appointmentId;
	public Date date;
	public String description;
	
	public Appointment(String appointmentId, Date date, String description) {
		if(appointmentId == null || appointmentId.length() > 10) {
			//Verifies that id is not null, less than 10 characters, and cannot be updated
			throw new IllegalArgumentException("Invalid ID");
		}
		
		if(date == null || date.before(new Date())) {
			//Verifies that name is not null and less than 20 characters
			throw new IllegalArgumentException("Invalid Date");
		}
		
		if(description == null || description.length() > 50) {
			//Verifies that description is not null and less than 50 characters
			throw new IllegalArgumentException("Invalid Description");
		}
		
		this.appointmentId = appointmentId;
		this.date = date;
		this.description = description;
	}
	
	public String getAppointmentId() {
		return appointmentId;	
	}
	
	public Date getDate() {
		return date;
	}
	
	public String getDescription() {
		return description;
	}
}