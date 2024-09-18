package com.example.taskmanager.service;

import com.example.taskmanager.db.entity.TaskEntity;
import com.example.taskmanager.db.repository.TaskRepository;
import com.example.taskmanager.model.dto.task.*;
import com.example.taskmanager.model.enums.TaskStatusEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskServiceImpl taskService;

    @Test
    void createTask() {
        TaskEntity task = TaskEntity.builder()
                .title("task 1")
                .status(TaskStatusEnum.OPEN).build();

        when(this.taskRepository.save(any(TaskEntity.class)))
                .thenReturn(task);

        CreateTaskResponseDto responseDto = taskService.create(
                CreateTaskRequestDto.builder()
                        .title(task.getTitle())
                        .build()
        );

        assertNotNull(responseDto);
        assertEquals("task 1", responseDto.getTitle());
    }

    @Test
    void getAllTasks() {
        List<TaskEntity> list = List.of(
                TaskEntity.builder().id(1L).title("task 1").description("description 1").status(TaskStatusEnum.OPEN).build(),
                TaskEntity.builder().id(2L).title("task 2").description("description 2").status(TaskStatusEnum.OPEN).build(),
                TaskEntity.builder().id(3L).title("task 3").description("description 3").status(TaskStatusEnum.OPEN).build()
        );

        when(taskRepository.findAll()).thenReturn(list);

        List<TaskDto> all = taskService.getAll();
        assertEquals(all.size(), list.size());
    }

    @Test
    void updateTask() {
        TaskEntity task = TaskEntity.builder()
                .title("task 1")
                .status(TaskStatusEnum.OPEN).build();

        when(this.taskRepository.findById(anyLong())).thenReturn(Optional.of(task));
        when(this.taskRepository.save(any(TaskEntity.class))).thenReturn(task);

        UpdateTaskResponseDto responseDto = taskService.update(
                UpdateTaskRequestDto.builder()
                        .id(anyLong())
                        .title(task.getTitle())
                        .build()
        );

        assertNotNull(responseDto);
        assertEquals(task.getTitle(), responseDto.getTitle());
    }

    @Test
    void deleteTaskById() {
        Mockito
                .doNothing()
                .when(this.taskRepository)
                .deleteById(anyLong());

        taskService.deleteById(anyLong());
    }

}