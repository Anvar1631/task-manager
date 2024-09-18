package com.example.taskmanager.service;

import com.example.taskmanager.model.dto.task.*;

import java.util.List;

public interface TaskService {

    List<TaskDto> getAll();

    CreateTaskResponseDto create(CreateTaskRequestDto requestDto);

    UpdateTaskResponseDto update(UpdateTaskRequestDto requestDto);

    void deleteById(Long id);
}
