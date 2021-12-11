package com.labovichl.lab3.connection;

import java.io.Serializable;

public class Message implements Serializable {
    private MessageType typeMessage;
    private String textMessage;
    private String sesionId;

    public Message(MessageType typeMessage) {
        this.typeMessage = typeMessage;
    }

    public Message(MessageType typeMessage, String textMessage) {
        this.typeMessage = typeMessage;
        this.textMessage = textMessage;
    }

    public Message(MessageType typeMessage, String textMessage, String sesionId) {
        this.typeMessage = typeMessage;
        this.textMessage = textMessage;
        this.sesionId = sesionId;
    }

    public MessageType getTypeMessage() {
        return typeMessage;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public String getSesionId() {
        return sesionId;
    }
}
