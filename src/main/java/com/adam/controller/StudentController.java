package com.adam.controller;

import com.adam.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/student")
public class StudentController {
    @Autowired
    public StudentService studentService;

    //Get By Hello World
    @GetMapping(path = "/findByHelloWorld") // Map ONLY Get By Id Requests
    public @ResponseBody String findByHelloWorld() {
        return studentService.getHelloWold();
    }
}
