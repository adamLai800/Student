package com.adam.controller;

import com.adam.model.Student;
import com.adam.repository.StudentRepository;
import com.adam.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    public StudentService studentService;

    //Get By Hello World
    @GetMapping(path = "/findByHelloWorld") // Map ONLY Get By Id Requests
    public @ResponseBody String findByHelloWorld() {
        return studentService.getHelloWold();
    }

    //Add
    @PostMapping(path = "/addNew") // Map ONLY POST Requests
    public @ResponseBody String addNew(
            @RequestParam String name,
            @RequestParam String sex) {

        Student student = new Student();
        student.setName(name);
        student.setSex(sex);
        studentRepository.save(student);
        return "Saved";
    }

    //Grt By Id
    @GetMapping(path = "/findById") // Map ONLY Get By Id Requests
    public @ResponseBody
    Optional<Student> findById(@RequestParam int id) {

        return studentRepository.findById(id);
    }

}
