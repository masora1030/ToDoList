package todolist;

import java.util.List;
import todolist.ToDoListTask;

public class ToDoListMainForm {
    public boolean isDone;
    
    public List<ToDoListTask> tasks;

    public List<ToDoListTask> getToDoTasks() {
        return tasks;
    }

    public void setTasks(List<ToDoListTask> tasks) {
        this.tasks = tasks;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }
}