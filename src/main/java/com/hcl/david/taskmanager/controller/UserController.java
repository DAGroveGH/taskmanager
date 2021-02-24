package com.hcl.david.taskmanager.controller;

import com.hcl.david.taskmanager.model.User;
import com.hcl.david.taskmanager.service.TaskService;
import com.hcl.david.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("sessionName")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @GetMapping({"/","/index","/home"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());
        mv.addObject("sessionName", user.getUsername());
        mv.addObject("user", user);
        mv.addObject("tasks", taskService.getAllByUserId(user.getUserId()));
        return mv;
    }

    @RequestMapping("/login")
    public String loginPage() {
        return "login";
    }
    @RequestMapping("/logout")
    public String logoutPage() {
        return "logout";
    }
    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public ModelAndView register(User user) {
        ModelAndView mv = new ModelAndView();
        if(userService.findByUsername(user.getUsername()) != null) {
            mv.setViewName("register");
            mv.addObject("message", "Username is already in use");
            mv.addObject("user", user);
        }else {
            mv.addObject("user",userService.save(user).getUsername());
            mv.addObject("message", "New user created successfully");
            mv.setViewName("login");
        }
        return mv;
    }
}
