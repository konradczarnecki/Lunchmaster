package com.lunchmaster.api;

import com.lunchmaster.api.lunch.dto.Lunch;
import com.lunchmaster.api.lunch.dto.Order;
import com.sun.org.apache.regexp.internal.RE;

import java.util.Date;


public class Response<T> {

    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";

    private String status;
    private String details;

    private T content;

    public Response() {
    }

    public Response(String status) {
        this.status = status;
    }

    public Response(T type) {
        this.content=type;
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


    public Response success() {
        this.setStatus(SUCCESS);
        this.setDetails("Operation successful.");
        return this;
    }

    public Response error() {
        this.setStatus(FAILURE);
        this.setDetails("There was an unexpected error.");
        this.setContent(null);
        return this;
    }

    public Response forbidden(){
        this.setStatus(FAILURE);
        this.setDetails("Forbidden operation.");
        this.setContent(null);
        return this;
    }

    public boolean isSuccess(){
        return this.status.equals(SUCCESS);
    }

}
