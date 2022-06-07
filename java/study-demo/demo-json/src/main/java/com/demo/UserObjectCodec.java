package com.demo;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.ResolvedType;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.Iterator;

public class UserObjectCodec extends ObjectCodec {
    @Override
    public Version version() {
        return null;
    }

    @Override
    public <T> T readValue(JsonParser p, Class<T> valueType) throws IOException {
        return null;
    }

    @Override
    public <T> T readValue(JsonParser p, TypeReference<T> valueTypeRef) throws IOException {
        return null;
    }

    @Override
    public <T> T readValue(JsonParser p, ResolvedType valueType) throws IOException {
        return null;
    }

    @Override
    public <T> Iterator<T> readValues(JsonParser p, Class<T> valueType) throws IOException {
        return null;
    }

    @Override
    public <T> Iterator<T> readValues(JsonParser p, TypeReference<T> valueTypeRef) throws IOException {
        return null;
    }

    @Override
    public <T> Iterator<T> readValues(JsonParser p, ResolvedType valueType) throws IOException {
        return null;
    }

    @Override
    public void writeValue(JsonGenerator gen, Object value) throws IOException {
        User user = User.class.cast(value);
        gen.writeStartObject();
        gen.writeStringField("name", user.getName());
        gen.writeNumberField("age", user.getAge());
        gen.writeEndObject();
    }

    @Override
    public <T extends TreeNode> T readTree(JsonParser p) throws IOException {
        return null;
    }

    @Override
    public void writeTree(JsonGenerator gen, TreeNode tree) throws IOException {

    }

    @Override
    public TreeNode createObjectNode() {
        return null;
    }

    @Override
    public TreeNode createArrayNode() {
        return null;
    }

    @Override
    public JsonParser treeAsTokens(TreeNode n) {
        return null;
    }

    @Override
    public <T> T treeToValue(TreeNode n, Class<T> valueType) throws JsonProcessingException {
        return null;
    }
}
