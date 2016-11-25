package com.example.administrator.myapplication.bean;

/**
 * Created by Administrator on 2016/11/25.
 */

public class Messagelist extends MessageEvent {

    private String message;

    public Messagelist(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
