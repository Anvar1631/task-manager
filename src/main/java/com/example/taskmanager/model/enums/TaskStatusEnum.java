package com.example.taskmanager.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Optional;

@Getter
@RequiredArgsConstructor
public enum TaskStatusEnum {

    OPEN(1),
    IN_PROGRESS(2),
    COMPLETED(3);

    private final int code;

    public static Optional<TaskStatusEnum> of(Integer code) {
        return Arrays.stream(values())
                .filter(f -> f.getCode() == code)
                .findFirst();
    }
}
