package com.hcl.david.taskmanager.controller;

import com.hcl.david.taskmanager.model.Task;
import com.hcl.david.taskmanager.model.User;
import com.hcl.david.taskmanager.service.TaskService;
import com.hcl.david.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@SessionAttributes("sessionName")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping("/create-task")
    public ModelAndView addTaskPage() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("users", userService.findAll());
        return mv;
    }

    @PostMapping("/create-task")
    public ModelAndView addTask(Principal principal, Task task) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("create-task");
        task.setUser(userService.findByUsername(principal.getName()));
        Task savedTask = taskService.save(task);
        if(savedTask != null) {
            mv.addObject("message", "Task saved successfully");
        }else {
            mv.addObject("error", "Task could not be saved");
        }
        mv.addObject("users", userService.findAll());
        return mv;
    }


    @GetMapping("/edit-task/{id}")
    public ModelAndView editTaskPageWithId(@PathVariable String id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("edit-task");
        mv.addObject("current", taskService.findById(Long.parseLong(id)));
        mv.addObject("users", userService.findAll());
        return mv;
    }

    @PostMapping("/update")
    public ModelAndView editTask(Principal principal, @RequestParam String taskId, Task task,
                                 @ModelAttribute("sessionName") String session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        task.setUser(userService.findByUsername(principal.getName()));
        task.setTaskId(Long.parseLong(taskId));
        Task savedTask = taskService.save(task);
        if(savedTask != null) {
            mv.addObject("message", "Task saved successfully");
        }else {
            mv.addObject("error", "Task could not be saved");
        }
        mv.addObject("user", userService.findByUsername(session));
        mv.addObject("tasks", taskService.getAllByUserId(userService.findByUsername(session).getUserId()));
        return mv;
    }
    @GetMapping("/delete-task/{id}")
    public ModelAndView deleteTaskPageWithId(@PathVariable String id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("delete-task");
        mv.addObject("current", taskService.findById(Long.parseLong(id)));
        return mv;
    }

    @PostMapping("/delete")
    public ModelAndView deleteTask(@ModelAttribute("sessionName") String session, @RequestParam String taskId) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        if(taskService.delete(Long.parseLong(taskId))) {
            mv.addObject("message", "Task deleted successfully");
        }else {
            mv.addObject("error", "Task could not be deleted");
        }
        User user = userService.findByUsername(session);
        mv.addObject("user", user);
        mv.addObject("tasks", taskService.getAllByUserId(user.getUserId()));

        return mv;
    }
}
