package com.example.taskmanager.model.dto.task;

import com.example.taskmanager.config.deserializer.TaskStatusDeserializer;
import com.example.taskmanager.model.enums.TaskStatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTaskRequestDto {

    private Long id;

    @NotBlank
    private String title;

    private String description;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate dueDate;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonDeserialize(using = TaskStatusDeserializer.class)
    private TaskStatusEnum status;
}
