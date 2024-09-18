package com.example.taskmanager.service;

import com.example.taskmanager.db.entity.TaskEntity;
import com.example.taskmanager.db.repository.TaskRepository;
import com.example.taskmanager.model.dto.task.*;
import com.example.taskmanager.model.enums.TaskStatusEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Override
    public List<TaskDto> getAll() {
        List<TaskEntity> tasks = taskRepository.findAll();

        return tasks.stream()
                .map(this::convertToTaskDto)
                .toList();
    }

    @Override
    public CreateTaskResponseDto create(CreateTaskRequestDto requestDto) {
        TaskEntity taskEntity = TaskEntity.builder()
                .title(requestDto.getTitle())
                .description(requestDto.getDescription())
                .dueDate(requestDto.getDueDate())
                .status(TaskStatusEnum.OPEN).build();

        TaskEntity saved = taskRepository.save(taskEntity);

        return CreateTaskResponseDto.builder()
                .id(saved.getId())
                .title(saved.getTitle())
                .description(saved.getDescription())
                .dueDate(saved.getDueDate())
                .status(saved.getStatus()).build();
    }

    @Override
    public UpdateTaskResponseDto update(UpdateTaskRequestDto requestDto) {
        TaskEntity task = taskRepository.findById(requestDto.getId()).orElseThrow();

        task.setTitle(requestDto.getTitle());
        task.setDescription(requestDto.getDescription());
        task.setDueDate(requestDto.getDueDate());
        task.setStatus(requestDto.getStatus());

        TaskEntity savedTask = taskRepository.save(task);

        return UpdateTaskResponseDto.builder()
                .id(savedTask.getId())
                .title(savedTask.getTitle())
                .description(savedTask.getDescription())
                .status(savedTask.getStatus())
                .dueDate(savedTask.getDueDate()).build();
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    private TaskDto convertToTaskDto(TaskEntity item) {
        return TaskDto.builder()
                .id(item.getId())
                .title(item.getTitle())
                .description(item.getDescription())
                .dueDate(item.getDueDate())
                .status(item.getStatus()).build();
    }
}
