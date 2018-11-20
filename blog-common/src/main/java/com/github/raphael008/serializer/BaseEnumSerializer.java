package com.github.raphael008.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.github.raphael008.enums.BaseEnum;

import java.io.IOException;

public class BaseEnumSerializer extends StdSerializer<BaseEnum> {

    public BaseEnumSerializer() {
        this(null);
    }

    public BaseEnumSerializer(Class<BaseEnum> t) {
        super(t);
    }

    @Override
    public void serialize(BaseEnum baseEnum, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
//        Integer code = baseEnum.getCode();
//        jsonGenerator.writeNumber(code);

        String value = baseEnum.getValue();
        jsonGenerator.writeString(value);
    }
}
