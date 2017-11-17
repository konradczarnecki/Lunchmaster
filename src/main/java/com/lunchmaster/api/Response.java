package com.lunchmaster.api;

public class Response <T> {

    public static final String SUCCESS = "success";
    public static final String FAILURE = "failure";

    private String status;
    private T content;

    public Response(){}

    public Response(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
