package com.lunchmaster.api;

import com.lunchmaster.api.lunch.dto.Lunch;
import com.lunchmaster.api.lunch.dto.Order;
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


    public void success() {
        this.setStatus(SUCCESS);
    }

    public void failure() {
        this.setStatus(FAILURE);
    }


    /* GENERIC RESPONSES */
    /* successful delete of single entity */
    public void deleteSuccess(Class cls, int id) {
        this.status = SUCCESS;
        this.details = cls.getSimpleName() + " with id=" + id + " was successfully deleted.";
    }

    /* successful delete of multiple entities */
    public void deleteBulkSuccess(Class cls) {
        this.status = SUCCESS;
        this.details = "Objects of type " + cls.getSimpleName() + " were successfully deleted.";
    }

    /* attempt to delete an entity that does not exist in database */
    public void deleteNotFound(Class cls, int id) {
        this.status = FAILURE;
        this.details = "Error during delete operation on " + cls.getSimpleName() + " with id=" + id + ". Object not found!";
    }

    /* unexpected error occurred during deletion of multiple entities */
    public void deleteBulkError(Class cls, Exception exc) {
        this.status = FAILURE;
        this.details = "Error during bulk delete operation on objects of type " + cls.getSimpleName() + ": " + exc.toString();
    }

    /* entity was found in database, but there was other error
     during delete (usually because database forbids breaking relations
      -f.ex. deleting lunch when orders are pointing to it ) */
    public void deleteFoundButError(Class cls, int id, Exception exc) {
        this.status = FAILURE;
        this.details = cls.getSimpleName() + " with id=" + id + " was found, but there was an error during deletion: " + exc.toString();
    }

    /* entity successfully saved */
    public void saveSuccess(Class cls, int id) {
        this.status = SUCCESS;
        this.details = cls.getSimpleName() + " with id=" + id + " was successfully saved.";
    }

    /* unexpected save error */
    public void saveError(Class cls, int id, Exception exc) {
        this.status = FAILURE;
        this.details = "Error during save operation on " + cls.getSimpleName() + " with id=" + id + ": " + exc.toString();
    }


    /* SPECIALIZED RESPONSES */
    /* Placing/editing order on non-OPEN lunch */
    public void saveOrderErrorLunchIsNotOpen(int orderId, int lunchId) {
        this.status = FAILURE;
        this.details = "Error during lunch edit. Order(id=" + orderId + ") cannot be placed or changed because the lunch(" + lunchId + ") it's referring to is no longer OPEN";
    }

    /* Trying to save existing lunch */
    public void saveLunchErrorLunchExists(int lunchId) {
        this.status = FAILURE;
        this.details = "Error during lunch save. Lunch(id=" + lunchId + ") cannot be changed because it already exists in the database. Use specialized api calls to edit lunch properties.";
    }

    /* Error while trying to change lunch status*/
    public void updateLunchStatusError(int lunchId, String status, boolean lunchExist) {
        this.status = FAILURE;
        if (lunchExist) {
            this.details = "Error while updating lunch status. Lunch with id=" + lunchId + " cannot change status to " + status +
                    ". This incident will be noted and sent to Santa Claus." +
                    "No presents for you, fucking hacker! :(";
        }
        else{
            this.details = "Error while updating lunch status. Lunch with id=" + lunchId + " doesn't exist.";
        }
    }

    /* Successfully changed lunch status */
    public void updateLunchStatusSuccess(int lunchId, String status){
        this.status=SUCCESS;
        this.details="Lunch with id="+lunchId+" was successfuly changed to '"+status+"'.";
    }

    /* Error while updating deadline */
    public void updateLunchDeadlineError(int lunchId, Date deadline, boolean lunchExist){
        this.status=FAILURE;
        if(lunchExist){
            this.details="Error while trying to update deadline of lunch(id="+lunchId+". Deadline is older that present moment.";
        }
        else{
            this.details="Error while trying to update deadline. Lunch "+lunchId+" doesn't exist!";
        }
    }

    /* Successfully updated deadline */
    public void updateLunchDeadlineSuccess(int lunchId, Date deadline){
        this.status=SUCCESS;
        this.details="Successfully updated deadline for lunch(id="+lunchId+"). New deadline is "+deadline+".";
    }

}
