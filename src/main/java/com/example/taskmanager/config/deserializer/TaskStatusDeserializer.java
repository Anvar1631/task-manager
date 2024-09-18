package com.example.taskmanager.config.deserializer;

import com.example.taskmanager.model.enums.TaskStatusEnum;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.Optional;

public class TaskStatusDeserializer extends StdDeserializer<TaskStatusEnum> {

    protected TaskStatusDeserializer() {
        super(TaskStatusEnum.class);
    }

    @Override
    public TaskStatusEnum deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {

        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        Integer status = node.asInt();

        Optional<TaskStatusEnum> taskStatusEnum = TaskStatusEnum.of(status);

        return taskStatusEnum.orElseThrow();
    }
}
