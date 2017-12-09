package com.example.artistle.message_chat_for_loading.dto;

import java.util.Date;

/**
 * Created by artistle on 31.10.17.
 */

public class message_dto {
    private String title;
    //private Date data;


    public message_dto() {

    }

    public message_dto(String text) {
        this.title = text;
    }

    public String getText() {
        return title;
    }

    public void setText(String text) {
        this.title = text;
    }

}
