package com.demo;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author ying.zhang01
 */
public class JacksonDemo {

    public static void main(String[] args) throws IOException {
        testContainerNode();
    }

    public static void test() throws IOException {
        JsonFactory jsonFactory = new JsonFactory();

        try(JsonGenerator jsonGenerator = jsonFactory.createGenerator(System.out, JsonEncoding.UTF8)) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("name", "zhangying");
            jsonGenerator.writeNumberField("age", 18);
            jsonGenerator.writeEndObject();
        }
    }

    public static void testWriteObject() throws IOException {
        JsonFactory factory = new JsonFactory();
        try (JsonGenerator generator = factory.createGenerator(System.out)) {
            generator.setCodec(new UserObjectCodec());
            generator.writeObject(new User());
        }
    }

    public static void testJsonParser() throws IOException {
//        String jsonStr = "{\"name\":\"YourBatman\",\"age\":18}";
        String jsonStr = "13";
        JsonFactory factory = new JsonFactory();
        try (JsonParser parser = factory.createParser(jsonStr)){
            while (parser.currentToken() != null && parser.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = parser.getCurrentName();
                if ("name".equals(fieldName)) {
                    parser.nextToken();
                    System.out.println(parser.getValueAsInt(20));
                } else if ("age".equals(fieldName)) {
                    parser.nextToken();
                    System.out.println(parser.getValueAsString("haha"));
                }
            }
        }
    }

    public static void testJsonFactory() throws IOException {
        String jsonStr = "{\"age\":18, \"age\": 28 }";
        JsonFactory factory = new JsonFactoryBuilder()
                .enable(StreamReadFeature.STRICT_DUPLICATE_DETECTION)
                .build();

        try (JsonParser jsonParser = factory.createParser(jsonStr)) {
            // 使用factory定制将不生效
//             factory.enable(JsonParser.Feature.STRICT_DUPLICATE_DETECTION);

            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = jsonParser.getCurrentName();
                if ("age".equals(fieldName)) {
                    jsonParser.nextToken();
                    System.out.println(jsonParser.getIntValue());
                }
            }
        }
    }

    public static void testObjectMapper() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Integer age = objectMapper.readValue("1", int.class);
        Map map = objectMapper.readValue("{\"name\":  \"YourBatman\"}", Map.class);
        System.out.println(age);
        System.out.println(map);

        User user = new User();
        System.out.println(objectMapper.writeValueAsString(user));
        System.out.println(objectMapper.writeValueAsString(List.of(1, 2, 3)));

        List<Long> list = objectMapper.readValue("[1,2,3]", new TypeReference<List<Long>>() {});
        Long id = list.get(0);
    }

    public static void testJsonMapper() throws JsonProcessingException {
        JsonMapper jsonMapper = JsonMapper.builder()
                .configure(JsonReadFeature.ALLOW_SINGLE_QUOTES, true)
                .build();

        User user = jsonMapper.readValue("{'name':  'YourBatman', 'age': 118}", User.class);
        System.out.println(user);
    }

    public static void testJsonNode() {
        JsonNodeFactory factory = JsonNodeFactory.instance;
        JsonNode node = factory.numberNode(1);
        System.out.println(node.isNumber() + ": " + node.intValue());

        // null节点
        node = factory.nullNode();
        System.out.println(node.isNull() + ":" + node.asText());

        // missing节点
        node = factory.missingNode();
        System.out.println(node.isMissingNode() + ":" + node.asText());

        // POJONode节点
        node = factory.pojoNode(new User());
        System.out.println(node.isPojo() + ":" + node.asText());
    }

    public static void testContainerNode() {
        JsonNodeFactory factory = JsonNodeFactory.instance;
        ObjectNode root = factory.objectNode();
        root.put("name", "zhang ying");

        ArrayNode arrayNode = factory.arrayNode();
        arrayNode.add("java").add("c");
        root.set("languages", arrayNode);

        ObjectNode dog = factory.objectNode();
        dog.put("name", "小白").put("age", 3);
        root.set("dog", dog);

        System.out.println(root);
        System.out.println(root.get("dog").get("name"));
        for (JsonNode node : root) {
            System.out.println(node.getNodeType() + ": " + node);
        }
        System.out.println(root.at("/dog/dog/sex"));

        JsonMapper jsonMapper = JsonMapper.builder().build();
        User user = new User();
        JsonNode userNode = jsonMapper.valueToTree(user);
        System.out.println(userNode);
        for (JsonNode node : userNode) {
            System.out.println(node.getNodeType() + ": " + node);
        }



    }
}
