package com.jackson.example.firstday;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

public class JsonTestMain {

    public static void main(String[] args)
    {
        String jsonSouce = "{\"title\":\"json propertie title\"}";
        try {
            JsonNode jsonNode = Json.parse(jsonSouce);
            System.out.println(jsonNode.get("title").asText());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
