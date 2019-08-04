package todolist;

import java.sql.Date;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import todolist.ToDoListTask;
import todolist.ToDoListTaskRepository;
import todolist.ToDoListMainForm;


@Controller
public class ToDoListHomeController {
	public int edit_id;
	
	@Autowired
	ToDoListTaskRepository repository;
    
    @RequestMapping
    public String index(@ModelAttribute ToDoListMainForm ToDoListMainForm, @RequestParam("isDone") Optional<Boolean> isDone) {
    	ToDoListMainForm.setDone(isDone.isPresent() ? isDone.get() : false);
    	ToDoListMainForm.setTasks(this.repository.findByDoneOrderByCreationdateDesc(ToDoListMainForm.isDone()));
        return "index";
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@ModelAttribute ToDoListEditForm ToDoListMainForm, @RequestParam("task_id") int id) {
    	edit_id = id;
    	ToDoListMainForm.setToDoTask(this.repository.findById(edit_id).get());
    	ToDoListMainForm.setToDoTaskId(edit_id);
        return "edit";
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(@ModelAttribute ToDoListEditForm ToDoListEditForm, 
    		@RequestParam(name = "tasknamenext") String namenext,
    		@RequestParam(name = "deadlinenext") Date deadlinenext) {
    	ToDoListTask ToDoListTask = this.repository.findById(edit_id).get();
    	ToDoListTask.setName(this.htmlEscape(namenext));
    	ToDoListTask.setDeadline(deadlinenext);
        this.repository.save(ToDoListTask);
        return "index";
    }
    
    @RequestMapping(value = "/done", method = RequestMethod.POST)
    public String done(@RequestParam("task_id") int id) {
    	ToDoListTask ToDoListTask = this.repository.findById(id).get();
    	ToDoListTask.setDone(true);
        this.repository.save(ToDoListTask);
        return "redirect:/?isDone=false";
    }
    
    @RequestMapping(value = "/restore", method = RequestMethod.POST)
    public String restore(@RequestParam("task_id") int id) {
    	ToDoListTask ToDoListTask = this.repository.findById(id).get();
    	ToDoListTask.setDone(false);
        this.repository.save(ToDoListTask);
        return "redirect:/?isDone=true";
    }
    
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String newItem(@RequestParam(name = "taskname") String name,
    		@RequestParam(name = "deadline") Date deadline,
    		ToDoListTask ToDoListTask) {
    	ToDoListTask.setDone(false);
    	ToDoListTask.setName(this.htmlEscape(name));
    	ToDoListTask.setDeadline(deadline);
    	ToDoListTask.setCreationdate();
        this.repository.save(ToDoListTask);
        return "redirect:";
    }
    
    /**
     * <p>[概 要] HTMLエスケープ処理</p>
     * @param  str 文字列
     * @return HTMLエスケープ後の文字列
     */
	public String htmlEscape(String str){
		StringBuffer result = new StringBuffer();
		for(char c : str.toCharArray()) {
			switch (c) {
			case '&' :
			case '<' :
			case '>' :
			case '"' :
			case '\'' :
			case ' ' :
				break;
			default :
				result.append(c);
				break;
			}
		}
		return result.toString();
	}
}