package com.github.raphael008.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.raphael008.enums.BaseEnum;

import java.io.IOException;

public class BaseEnumDeserializer extends StdDeserializer<BaseEnum> {

    protected BaseEnumDeserializer() {
        this(null);
    }

    protected BaseEnumDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public BaseEnum deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        return null;
    }
}
