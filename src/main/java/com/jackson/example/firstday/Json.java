package com.jackson.example.firstday;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class Json
{

    private static ObjectMapper objectMapper =  getDefaultObjectMapper();

    private static ObjectMapper getDefaultObjectMapper()
    {
        ObjectMapper defaultObjectMapper =  new ObjectMapper();
        defaultObjectMapper.registerModule(new JavaTimeModule());
        defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return defaultObjectMapper;
    }

    public static JsonNode parse(String src) throws JsonProcessingException
    {
        JsonNode jsonNode = objectMapper.readTree(src);
        return jsonNode;
    }

    public static <T> T fromJson(JsonNode jsonNode, Class<T> _class) throws JsonProcessingException
    {
        return objectMapper.treeToValue(jsonNode, _class);
    }

    public static JsonNode toJson(Object _object)
    {
        return objectMapper.valueToTree(_object);
    }

    public static String stringify(JsonNode jsonNode) throws JsonProcessingException
    {
        return generataString(jsonNode, false);
    }

    public static String stringifyPrettyWay(JsonNode jsonNode) throws JsonProcessingException
    {
        return generataString(jsonNode, true);
    }

    private static String generataString(JsonNode jsonNode, boolean pretty) throws JsonProcessingException
    {
        ObjectWriter objectWriter = objectMapper.writer();
        if(pretty)
            objectWriter =  objectWriter.with(SerializationFeature.INDENT_OUTPUT);
        return objectWriter.writeValueAsString(jsonNode);
    }
}
