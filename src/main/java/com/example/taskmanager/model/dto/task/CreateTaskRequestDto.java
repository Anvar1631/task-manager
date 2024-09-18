package com.example.taskmanager.model.dto.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTaskRequestDto {

    @NotBlank
    private String title;

    private String description;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate dueDate;
}
