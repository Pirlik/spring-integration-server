package com.griddynamics.integration.server.serializtion;

import org.springframework.core.serializer.Deserializer;
import org.springframework.core.serializer.Serializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class ServerSerializer implements Serializer<byte[]>, Deserializer<byte[]> {
    @Override
    public byte[] deserialize(InputStream inputStream) throws IOException {
        return new byte[0];
    }

    @Override
    public void serialize(byte[] bytes, OutputStream outputStream) throws IOException {

    }
}
