package com.example.lab6;
public class LoginValidator {
    public boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty() && name.matches("[a-zA-Z]+");
    }

    public boolean isValidLastName(String lastName) {
        return lastName != null && !lastName.trim().isEmpty() && lastName.matches("[a-zA-Z]+");
    }

    public boolean isValidPassword(String password) {
        return password != null && password.length() >= 6; // Example rule: min 6 chars
    }
}

