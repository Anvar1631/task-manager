package com.example.taskmanager.db.repository;

import com.example.taskmanager.db.entity.TaskEntity;
import com.example.taskmanager.model.enums.TaskStatusEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void createTask() {
        TaskEntity task = TaskEntity.builder()
                .title("task 1")
                .status(TaskStatusEnum.OPEN)
                .build();

        TaskEntity saved = taskRepository.save(task);

        assertNotNull(saved);
        assertEquals(task.getTitle(), saved.getTitle());
    }

    @Test
    public void getListOfTasks() {

        TaskEntity task1 = TaskEntity.builder()
                .title("task 1")
                .status(TaskStatusEnum.OPEN)
                .build();

        TaskEntity task2 = TaskEntity.builder()
                .title("task 2")
                .status(TaskStatusEnum.OPEN)
                .build();

        taskRepository.saveAll(List.of(task1, task2));

        List<TaskEntity> tasks = taskRepository.findAll();
        assertNotNull(tasks);
        assertEquals(2, tasks.size());
    }

    @Test
    public void updateTask() {
        TaskEntity task = taskRepository.save(
                TaskEntity.builder()
                        .title("task 1")
                        .status(TaskStatusEnum.OPEN)
                        .build()
        );

        task.setTitle("task 2");

        taskRepository.save(task);

        TaskEntity updatedTask = taskRepository.findById(task.getId()).orElse(null);

        assertNotNull(updatedTask);
        assertEquals("task 2", updatedTask.getTitle());
    }

    @Test
    public void deleteTask() {
        TaskEntity task = taskRepository.save(
                TaskEntity.builder()
                        .title("task 1")
                        .status(TaskStatusEnum.OPEN)
                        .build()
        );

        taskRepository.deleteById(task.getId());
        TaskEntity deletedTask = taskRepository.findById(task.getId()).orElse(null);
        assertNull(deletedTask);
    }
}