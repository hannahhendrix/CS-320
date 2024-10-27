//Author Name: Hannah Hendrix

//Date: 9/27/2024

//Course ID: CS-320

//Description: Module 4 Milestone: Task Services

package TaskServiceJava;

public class Task {
	
	public String taskId;
	public String name;
	public String description;
	
	public Task(String taskId, String name, String description) {
		if(taskId == null || taskId.length() > 10) {
			//Verifies that id is not null, less than 10 characters, and cannot be updated
			throw new IllegalArgumentException("Invalid ID");
		}
		
		if(name == null || name.length() > 20) {
			//Verifies that name is not null and less than 20 characters
			throw new IllegalArgumentException("Invalid name");
		}
		
		if(description == null || description.length() > 50) {
			//Verifies that description is not null and less than 50 characters
			throw new IllegalArgumentException("Invalid Description");
		}
		
		this.taskId = taskId;
		this.name = name;
		this.description = description;
	}
	
	public String getTaskId() {
		return taskId;	
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
}