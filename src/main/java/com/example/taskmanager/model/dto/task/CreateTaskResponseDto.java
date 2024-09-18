package com.example.taskmanager.model.dto.task;

import com.example.taskmanager.model.enums.TaskStatusEnum;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTaskResponseDto {
    private Long id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private TaskStatusEnum status;
}
