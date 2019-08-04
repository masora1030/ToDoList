package todolist;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import todolist.ToDoListTask;

public interface ToDoListTaskRepository extends JpaRepository<ToDoListTask, Integer> {
	public List<ToDoListTask> findByDoneOrderByCreationdateDesc(boolean done);
}