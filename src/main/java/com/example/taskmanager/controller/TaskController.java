package com.example.taskmanager.controller;

import com.example.taskmanager.model.dto.task.*;
import com.example.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/all")
    public List<TaskDto> getAll() {
        return taskService.getAll();
    }

    @PostMapping("/create")
    public CreateTaskResponseDto create(@Valid @RequestBody CreateTaskRequestDto requestDto) {
        return taskService.create(requestDto);
    }

    @PutMapping("/update")
    public UpdateTaskResponseDto update(@Valid @RequestBody UpdateTaskRequestDto requestDto) {
        return taskService.update(requestDto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        taskService.deleteById(id);
    }
}
