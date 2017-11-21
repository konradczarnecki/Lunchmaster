package com.lunchmaster.api;

public class Response<T>{

    public static final String SUCCESS = "success";
    public static final String FAILURE = "failure";

    private String status;
    private String details;

    private T content;

    public Response() {
    }

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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }



    public void deleteSuccess(Class cls, int id) {
        this.status = SUCCESS;
        this.details = cls.getSimpleName() + " with id=" + id + " was successfully deleted.";
    }

    public void deleteBulkSuccess(Class cls) {
        this.status = SUCCESS;
        this.details = "Objects of type "+cls.getSimpleName() + " were successfully deleted.";
    }

    public void deleteNotFound(Class cls, int id) {
        this.status = FAILURE;
        this.details = "Error during delete operation on " + cls.getSimpleName() + " with id=" + id + ". Object not found!";
    }

    public void deleteBulkError(Class cls, Exception exc){
        this.status = FAILURE;
        this.details = "Error during bulk delete operation on objects of type " + cls.getSimpleName() + ": "+exc.toString();
    }

    public void deleteFoundButError(Class cls, int id, Exception exc) {
        this.status = FAILURE;
        this.details = cls.getSimpleName() + " with id=" + id + " was found, but there was an error during deletion: "+exc.toString();
    }

    public void saveSuccess(Class cls, int id) {
        this.status = SUCCESS;
        this.details = cls.getSimpleName() + " with id=" + id + " was successfully saved.";
    }

    public void saveError(Class cls, int id, Exception exc) {
        this.status = FAILURE;
        this.details =  "Error during save operation on " + cls.getSimpleName() + " with id=" + id+": " + exc.toString();
    }

}