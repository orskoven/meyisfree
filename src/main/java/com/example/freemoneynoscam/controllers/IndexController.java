package com.example.freemoneynoscam.controllers;

import com.example.freemoneynoscam.services.InsertEmailsToDb;
import com.example.freemoneynoscam.services.ValidateEmailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLException;
import java.util.Objects;

@Controller
public class IndexController {
    ValidateEmailService validateEmailService = new ValidateEmailService();

    @GetMapping("/")
    public String index(){
        InsertEmailsToDb.connectToDb();
        return "index";
    }

    @PostMapping("/submit")
    public String test(WebRequest dataFromForm) throws SQLException {
        String result = "";
        String email = dataFromForm.getParameter("email");
        if (validateEmailService.isEmailValid(email)){
        InsertEmailsToDb.insertEmailToDb(Objects.requireNonNull(email));
        result = "test";
        }
        if (!validateEmailService.isEmailValid(email)) {
            result = "stop";
        }
        return result;
    }
}
