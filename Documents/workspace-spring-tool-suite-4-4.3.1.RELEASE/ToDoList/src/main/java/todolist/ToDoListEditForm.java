package todolist;

import todolist.ToDoListTask;

public class ToDoListEditForm {
	
    public ToDoListTask task;
    
    public int task_id;

    public ToDoListTask getToDoTask() {
        return task;
    }

    public void setToDoTask(ToDoListTask task) {
        this.task = task;
    }
    
    public int getToDoTaskId() {
        return task_id;
    }

    public void setToDoTaskId(int id) {
        this.task_id = id;
    }
}
