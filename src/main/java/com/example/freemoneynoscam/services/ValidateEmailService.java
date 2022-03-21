package com.example.freemoneynoscam.services;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ValidateEmailService {

    public boolean isEmailValid(String email) {
        boolean isValid = false;
        //TODO implement logic such that we verify an e-mail is valid
            if (email.contains("@") && email.contains(".")) {
                isValid = true;
            }
        return isValid;
    }
    }
