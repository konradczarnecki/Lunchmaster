package com.lunchmaster.api.registration.dto;

import com.lunchmaster.api.registration.validation.ValidEmail;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class RegistrationDto {

    @NotEmpty
    @Size(max = 20, message = "must be between {2} and {1}")
    private String firstName;

    @NotEmpty
    @Size(max = 30, message = "must be between {2} and {1}")
    private String lastName;

    @NotEmpty
    @ValidEmail
    private String email;

    @NotEmpty
    private String password;


    public RegistrationDto() {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RegistrationDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
