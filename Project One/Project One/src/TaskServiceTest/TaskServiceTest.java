package TaskServiceTest;

import TaskServiceJava.Task;
import TaskServiceJava.TaskService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskServiceTest {

	private TaskService taskService;
	
	@BeforeEach
	public void setUp() {
		taskService = new TaskService();
	}
	
	@Test
	public void testAddTask() {
		Task task = new Task("12345", "Task Name", "Description");
		assertTrue(taskService.addTask(task));
	}
	
	@Test
	public void testAddDupliateTask() {
		Task task = new Task("12345", "Task Name", "Description");
		taskService.addTask(task);
		assertThrows(IllegalArgumentException.class, () -> {
			taskService.addTask(task);
		});
	}
	
	@Test
	public void testDeleteTask() {
		Task task = new Task("12345", "Task Name", "Description");
		taskService.addTask(task);
		assertTrue(taskService.deleteTask("12345"));
	}
	
	@Test
	public void testDeleteNonExistentTask() {
		assertThrows(IllegalArgumentException.class, () -> {
			taskService.deleteTask("22345");
		});
	}
	
	@Test
	public void testUpdateName() {
		Task task = new Task("12345", "Task Name", "Description");
		taskService.addTask(task);
		assertTrue(taskService.updateName("12345", "New Task Name"));
		assertEquals("New Task Name", taskService.taskMap.get("12345").getName());
	}
	
	@Test
	public void testUpdateDescription() {
		Task task = new Task("12345", "Task Name", "Description");
		taskService.addTask(task);
		assertTrue(taskService.updateDescription("12345", "New Description"));
		assertEquals("New Description", taskService.taskMap.get("12345").getDescription());
	}

}
