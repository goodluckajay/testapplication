package com.self.model;

import javax.validation.constraints.NotNull;

public class StudentDetailRequestUpdate {

    @NotNull(message = "First Name can't be null")
    private String firstName;

    @NotNull (message = "Last Name can't be null")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
