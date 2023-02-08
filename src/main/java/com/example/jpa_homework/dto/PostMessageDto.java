package com.example.jpa_homework.dto;

import lombok.Getter;

@Getter
public class PostMessageDto {
    private String message;

    public void postMessage(String message)
    {
        this.message = message;
    }

}
