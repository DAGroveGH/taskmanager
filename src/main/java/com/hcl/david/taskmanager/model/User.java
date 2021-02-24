package com.hcl.david.taskmanager.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String username;
    private String password;
    private String email;
    @OneToMany(mappedBy = "user")
    private List<Task> task;
    public User() {
        super();
    }
    public User(Long userId, String username, String password, String email, List<Task> task) {
        super();
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.task = task;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<Task> getTask() {
        return task;
    }
    public void setTask(List<Task> task) {
        this.task = task;
    }

}
