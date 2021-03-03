package com.example.reactive;

public class Greeting {
    private int id;
    private String content;

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Greeting(int id, String content) {
        this.id = id;
        this.content = content;
    }
}
