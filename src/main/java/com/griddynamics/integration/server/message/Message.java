package com.griddynamics.integration.server.message;

import org.apache.tomcat.util.codec.binary.StringUtils;

public class Message {

    String message;

    public Message(String message) {
        this.message = message;
    }

    public Message(byte[] message) {
        this.message = StringUtils.newStringUtf8(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
