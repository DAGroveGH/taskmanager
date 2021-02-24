package com.hcl.david.taskmanager.model;

import java.sql.Date;

import javax.persistence.*;

@Entity(name="task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;
    private String taskName;
    private String description;
    private String severity;
    private Date startDate;
    private Date endDate;
    @ManyToOne
    private User user;

    public Task() {
        super();
    }

    public Task(Long taskId, String taskName, String description, String severity, Date startDate,
                Date endDate, User user) {
        super();
        this.taskId = taskId;
        this.taskName = taskName;
        this.description = description;
        this.severity = severity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Task [taskId=" + taskId + ", taskName=" + taskName + ", description=" + description + ", email="
                + ", severity=" + severity + ", startDate=" + startDate + ", endDate=" + endDate + "]";
    }



}
