package com.self.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StudentDetailRequest {

        @NotNull(message = "First Name can't be null")
        private String firstName;

        @NotNull (message = "Last Name can't be null")
        private String lastName;

        @NotNull (message = "E-mail can't be null")
        @Email
        private String emial;

        @NotNull(message = "Password can't be nul")
        @Size(min = 5, max = 20, message = "password can't be less than 5 and more thn 20 characters.")
        private String password;

        private String id;

        public String getFirstName() {
        return firstName;
    }

        public String getLastName() {
        return lastName;
    }

        public String getEmial() {
        return emial;
    }

        public String getId() {
        return id;
    }

        public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

        public void setLastName(String lastName) {
        this.lastName = lastName;
    }

        public void setEmial(String emial) {
        this.emial = emial;
    }

        public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
