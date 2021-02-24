package com.hcl.david.taskmanager.repository;

import com.hcl.david.taskmanager.model.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {
    @Query("SELECT t FROM task t WHERE t.user.userId=?1")
    public List<Task> getAllByUserId(Long UserId);

    @Query("SELECT user FROM task t WHERE t.taskId=?1")
    public Task getUserByTaskId(Long taskId);
}
