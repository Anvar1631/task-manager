package com.example.taskmanager.model.dto.task;

import com.example.taskmanager.model.enums.TaskStatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private LocalDate dueDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private TaskStatusEnum status;
}
