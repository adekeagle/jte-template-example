package pl.adcom.jte_template_example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@TestPropertySource(properties = "server.port=9091")
@AutoConfigureMockMvc
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService taskService;

    @Test
    void testAllTasks() throws Exception {

        Mockito.when(taskService.showAll()).thenReturn(
                Arrays.asList(
                        new Task(1L, "Posprzątaj", false),
                        new Task(2L, "Wynieś śmieci", true)
                )
        );

        mockMvc.perform(MockMvcRequestBuilders.get("/tasks"))
                .andExpect(status().isOk())
                .andExpect(view().name("task"))
                .andExpect(model().attributeExists("taskList"))
                .andExpect(model().attribute("taskList", taskService.showAll()));
    }

    @Test
    void testAddNewTask() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/tasks")
                        .param("id", "3")
                        .param("name", "Wyjdź z psem")
                        .param("isDone", "false"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/tasks"));

        Mockito.verify(taskService).addTask(any(Task.class));
    }

    @Test
    void testNewTaskForm() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("newTask"));
    }

    @Test
    void testToggleTaskStatus() throws Exception {
        Task task = new Task(1L, "Posprzątaj", false);

        Mockito.when(taskService.showTaskById(1L)).thenReturn(task);

        mockMvc.perform(MockMvcRequestBuilders.post("/toggleTaskStatus/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/tasks"));

        Mockito.verify(taskService).changeStatus(1L, false);
    }
}