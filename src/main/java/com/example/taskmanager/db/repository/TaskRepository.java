package com.example.taskmanager.db.repository;

import com.example.taskmanager.db.entity.TaskEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends ListCrudRepository<TaskEntity, Long> {

}
