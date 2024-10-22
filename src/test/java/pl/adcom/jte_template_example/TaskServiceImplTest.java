package pl.adcom.jte_template_example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceImplTest {

    private TaskService taskService;

    @BeforeEach
    void setUp() {
        taskService = new TaskServiceImpl();
    }

    @Test
    void shouldAddNewTaskToList() {
        Task newTask = new Task(4L, "Zrób zakupy", false);
        taskService.addTask(newTask);

        List<Task> tasks = taskService.showAll();
        assertEquals(4, tasks.size(), "Task list size should be 4 after adding a task");
        assertEquals("Zrób zakupy", tasks.get(3).getName());
    }

    @Test
    void testDeleteTask() {
        taskService.deleteTask(1L);
        List<Task> tasks = taskService.showAll();
        assertEquals(2, tasks.size(), "Task list size should be 2 after deletion");
    }

    @Test
    void showAll() {
        List<Task> tasks = taskService.showAll();
        assertEquals(3, tasks.size(), "Initial task list size should be 3");
    }

    @Test
    void showTaskById() {
        Task task = taskService.showTaskById(1L);
        assertNotNull(task, "Task with ID 1 should exist");
        assertEquals("Posprzątaj", task.getName(), "Task name should match");
    }

    @Test
    void changeStatus() {
        taskService.changeStatus(1L, false);
        Task task = taskService.showTaskById(1L);
        assertTrue(task.getIsDone(), "Task status should be changed to true");
    }

    @Test
    void testTaskNotFound() {
        Exception exception = assertThrows(RuntimeException.class, () -> taskService.showTaskById(99L));
        assertEquals("Nic nie znalazłem!", exception.getMessage());
    }
}