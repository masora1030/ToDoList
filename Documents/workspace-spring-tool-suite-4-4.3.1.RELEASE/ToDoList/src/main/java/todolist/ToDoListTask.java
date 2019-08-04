package todolist;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "todolist")
public class ToDoListTask {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_id")
    public Integer task_id;

    @Length(min=1, max=30, message="タイトルは1文字以上30文字以内で入力してください。")
    @Column(name = "taskname")
    public String taskname;
    
    @Column(name = "done")
    public Boolean done;
    
    @Column(name = "deadline")
    public Date deadline;
    
    @Column(name = "creationdate")
    public Date creationdate;

    // getter and setter
    public int getId() {
        return task_id;
    }

    public void setId(int id) {
        this.task_id = id;
    }

    public String getName() {
        return taskname;
    }

    public void setName(String title) {
        this.taskname = title;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
    
    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
    
    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate() {
    	java.util.Date d = new java.util.Date();   //現在時刻に設定
    	this.creationdate = new java.sql.Date(d.getTime());
    }
    
}