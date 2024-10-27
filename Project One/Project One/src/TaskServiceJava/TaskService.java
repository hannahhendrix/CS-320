package TaskServiceJava;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
	//Using a HashMap[ to store tasks, keyed by their unique id
	public Map<String, Task> taskMap = new HashMap<>();
	
	//Add a task to the service
	public boolean addTask(Task task) {
		if(taskMap.containsKey(task.getTaskId())) {
			//Ensure task IDs are unique
			throw new IllegalArgumentException("Task ID already exists");
		}
		taskMap.put(task.getTaskId(), task);
		return true;
	}
	
	//Delete a task by ID
	public boolean deleteTask(String taskId) {
		if(taskMap.remove(taskId) != null) {
			return true;
		}
		else {
			throw new IllegalArgumentException("Task ID not found");
		}
	}
	
	//Update a task's name
	public boolean updateName(String taskId, String newName) {
		Task task = taskMap.get(taskId);
		if(task != null) {
			if(newName == null || newName.length() > 20) {
				throw new IllegalArgumentException("Invalid Name");
			}
			taskMap.get(taskId).name = newName;
			return true;
		}
		else {
			throw new IllegalArgumentException("Task ID not found");
		}
	}
	
	//Update a task's description
	public boolean updateDescription(String taskId, String newDescription) {
		Task task = taskMap.get(taskId);
		if(task != null) {
			if(newDescription == null || newDescription.length() > 50) {
				throw new IllegalArgumentException("invalid Description");
			}
			taskMap.get(taskId).description = newDescription;
			return true;
		}
		else {
			throw new IllegalArgumentException("Task ID not found");
		}
	}
}