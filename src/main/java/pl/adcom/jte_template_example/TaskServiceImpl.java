package pl.adcom.jte_template_example;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    List<Task> tasks;

    public TaskServiceImpl() {
        tasks = new ArrayList<>();
        tasks.add(new Task(1L, "Posprzątaj", false));
        tasks.add(new Task(2L, "Wynieś śmieci", true));
        tasks.add(new Task(3L, "Wyjdź z psem", false));
    }

    private static void accept(Task t) {
        t.setIsDone(!t.getIsDone());
    }

    @Override
    public void addTask(Task task) {
        if (task.getIsDone() == null) task.setIsDone(false);
        tasks.add(new Task(task.getId(), task.getName(), task.getIsDone()));
    }

    @Override
    public void deleteTask(long id) {
        Task task = tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Nic nie znalzałem!"));

        tasks.remove(task);
    }

    @Override
    public List<Task> showAll() {
        return tasks;
    }

    @Override
    public Task showTaskById(long id) {
        return tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Nic nie znalazłem!"));
    }

    @Override
    public void changeStatus(long id, boolean status) {
            Optional<Task> findedTask = Optional.ofNullable(tasks.stream()
                    .filter(t -> t.getId() == id)
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Brak takiego zadania")));

            findedTask.ifPresent(TaskServiceImpl::accept);
    }
}
