package com.example.taskmanager.db.entity;

import com.example.taskmanager.model.enums.TaskStatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    private String description;
    private LocalDate dueDate;
    @Column(nullable = false)
    private TaskStatusEnum status;
}
