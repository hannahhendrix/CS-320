package TaskServiceTest;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import TaskServiceJava.Task;


class TaskTest {

	@Test
	void testTask() {
		Task task = new Task("12345", "Task Name", "Description");
		assertTrue(task.getTaskId().equals("12345"));
		assertTrue(task.getName().equals("Task Name"));
		assertTrue(task.getDescription().equals("Description"));
	}
	
	@Test
	void testInvalidTaskId() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Task Name", "Description");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("01234567890", "Task Name", "Description");
		});
	}
	
	@Test
	void testInvalidTaskName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345", null, "Description");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345", "012345678901234567890", "Description");
		});
	}
	
	@Test
	void testInvalidTaskDescription() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345", "Task Name", null);
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345", "Task Name", "012345678901234567890123456789012345678901234567890");
		});
	}
}
