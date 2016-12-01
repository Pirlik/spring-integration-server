package com.griddynamics.integration.server.serializtion;

import org.springframework.core.serializer.Deserializer;

import java.io.IOException;
import java.io.InputStream;

public class ServerDeserializer implements Deserializer<byte[]> {
    @Override
    public byte[] deserialize(InputStream inputStream) throws IOException {
        return new byte[0];
    }
}
