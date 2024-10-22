package pl.adcom.jte_template_example;

import java.util.List;

public interface TaskService {

    void addTask(Task task);
    void deleteTask(long id);
    List<Task> showAll();
    Task showTaskById(long id);
    void changeStatus(long id, boolean status);
}
