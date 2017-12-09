package com.lunchmaster.api.registration.dto;

import com.lunchmaster.api.registration.validation.UniqueBankAccount;
import com.lunchmaster.api.registration.validation.UniqueEmail;
import com.lunchmaster.api.registration.validation.UniqueMobileNumber;
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
    @UniqueEmail
    private String email;

    @NotEmpty
    private String password;

    @UniqueBankAccount
    private String bankAccount;

    @UniqueMobileNumber
    private String mobile;

    private String part;

    private String group;

    private String team;

    private int floor;

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

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "RegistrationDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", mobile='" + mobile + '\'' +
                ", part='" + part + '\'' +
                ", group='" + group + '\'' +
                ", team='" + team + '\'' +
                ", floor='" + floor + '\'' +
                '}';
    }
}
