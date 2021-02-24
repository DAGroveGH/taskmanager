package com.hcl.david.taskmanager.service;

import java.util.ArrayList;
import java.util.List;

import com.hcl.david.taskmanager.exception.TaskNotFoundException;
import com.hcl.david.taskmanager.model.Task;
import com.hcl.david.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepo;

    public List<Task> getAllByUserId(Long id) {
        List<Task> taskList = new ArrayList<Task>();
        for(Task task : taskRepo.getAllByUserId(id)) {
            taskList.add(task);
        }
        return taskList;
    }

    public Task save(Task task) {
        return taskRepo.save(task);
    }

    public Task findById(Long id) {
        try {
            taskRepo.findById(id).get();
        }catch(TaskNotFoundException ex) {
            throw new TaskNotFoundException(id);
        }
        return taskRepo.findById(id).get();
    }

    public Task getUserByTaskId(Long taskId) {
        return taskRepo.getUserByTaskId(taskId);
    }

    public boolean delete(Long taskId) {
        taskRepo.deleteById(taskId);
        if(!taskRepo.existsById(taskId)) {
            return true;
        }
        return false;
    }

}