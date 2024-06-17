package com.ramirogonzalez.simpleTodoList.model;

import lombok.Getter;
import lombok.Setter;

//just to return a message
@Getter @Setter
public class ResponseMessage {

    private String message;

    public ResponseMessage(String message) {
        this.message = message;
    }

    public ResponseMessage() {
    }
}
