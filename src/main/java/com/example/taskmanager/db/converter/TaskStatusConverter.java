package com.example.taskmanager.db.converter;

import com.example.taskmanager.model.enums.TaskStatusEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class TaskStatusConverter implements AttributeConverter<TaskStatusEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(TaskStatusEnum taskStatusEnum) {
        if (taskStatusEnum == null) {
            throw new IllegalArgumentException();
        }

        return taskStatusEnum.getCode();
    }

    @Override
    public TaskStatusEnum convertToEntityAttribute(Integer code) {
        if (code == null) {
            throw new IllegalArgumentException();
        }

        return Stream.of(TaskStatusEnum.values())
                .filter(c -> c.getCode() == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
