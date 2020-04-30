package com.students.demo.controllers;

import com.students.demo.models.Login;
import com.students.demo.repo.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;

    @RequestMapping(method= RequestMethod.POST, value="/admin/login")
    @CrossOrigin(value = "http://localhost:4200")
    public Login save(@RequestBody Login login){
       return loginRepository.save(login);
    }
}
