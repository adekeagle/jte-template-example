package pl.adcom.jte_template_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public String allTasks(Model model) {
        model.addAttribute("taskList", taskService.showAll());
        return "task";
    }

    @PostMapping("/tasks")
    public String addNewTask(@ModelAttribute Task task) {
        taskService.addTask(task);
        return "redirect:/tasks";
    }

    @PostMapping("/add")
    public String newTask(Task task) {
        return "newTask";
    }

    @PostMapping("/toggleTaskStatus/{id}")
    public String toggleTaskStatus(@PathVariable long id) {
        taskService.changeStatus(id, taskService.showTaskById(id).getIsDone());
        return "redirect:/tasks";
    }
}
