package com.jackson.example.firstday;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.jackson.example.firstday.pojo.AuthorPOJO;
import com.jackson.example.firstday.pojo.DayPOJO;
import com.jackson.example.firstday.pojo.SimpleTestCaseJsonPOJO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonTest {

    private final String simpleTestCaseJsonSouce = "{ \"title\": \"json propertie title\" }";

    private final String dayJsonTest = "{\n" +
            "  \"name\": \"Today\",\n" +
            "  \"date\": \"2021-02-24\"\n" +
            "}";

    private final String authorJsonTest = "{\n" +
            "  \"author_name\": \"Pedro Henrique\",\n" +
            "  \"books\": [\n" +
            "    {\n" +
            "      \"title\": \"title1\",\n" +
            "      \"inprint\": true,\n" +
            "      \"publish_date\": \"2021-02-25\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"title2\",\n" +
            "      \"inprint\": false,\n" +
            "      \"publish_date\": \"2021-02-26\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    @Test
    void whenInvokeParseWithCorrectJsonMustReturnNamedPropertie() throws JsonProcessingException
    {
        JsonNode jsonNode =  Json.parse(simpleTestCaseJsonSouce);
        assertEquals(jsonNode.get("title").asText(),"json propertie title");
    }

    @Test
    void whenInvokefromJsonWithMappedObjectMustReturnValidPOJOObject() throws JsonProcessingException
    {
        JsonNode node = Json.parse(simpleTestCaseJsonSouce);
        SimpleTestCaseJsonPOJO pojo =  Json.fromJson(node, SimpleTestCaseJsonPOJO.class);

        assertEquals(pojo.getTitle(),"json propertie title");
    }

    @Test
    void whenInvoketoJsonPasingPOJOObjectMustReturnJsonNodeObject()
    {
        SimpleTestCaseJsonPOJO pojo =  new SimpleTestCaseJsonPOJO();
        pojo.setTitle("Let me test this method");

        JsonNode jsonNode =  Json.toJson(pojo);
        assertEquals(jsonNode.get("title").asText(), "Let me test this method");
    }

    @Test
    void whenInvokestringifyPassingJsonNodeMustReturnStringfiedValues() throws JsonProcessingException
    {
        SimpleTestCaseJsonPOJO pojo =  new SimpleTestCaseJsonPOJO();
        pojo.setTitle("Let me test this method");

        JsonNode jsonNode =  Json.toJson(pojo);
        assertEquals("{\"title\":\"Let me test this method\"}", Json.stringify(jsonNode));
    }

    @Test
    void whenInvokefromJsonWithMappedObjectMustReturnValidPOJOObjectAuthorCase() throws JsonProcessingException
    {
        JsonNode jsonNode =  Json.parse(authorJsonTest);
        AuthorPOJO pojo = Json.fromJson(jsonNode, AuthorPOJO.class);

        assertEquals("Pedro Henrique", pojo.getAuthorName().toString());
        assertEquals(2, pojo.getBooks().size());
        assertEquals("title1", pojo.getBooks().get(0).getTitle());
        assertEquals(true, pojo.getBooks().get(0).isInprint());
        assertEquals("2021-02-25", pojo.getBooks().get(0).getPublishDate().toString());
        assertEquals("title2", pojo.getBooks().get(1).getTitle());
        assertEquals(false, pojo.getBooks().get(1).isInprint());
        assertEquals("2021-02-26", pojo.getBooks().get(1).getPublishDate().toString());

    }
}