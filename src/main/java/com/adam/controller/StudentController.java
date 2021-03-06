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

    //Update Name By Id
    @GetMapping(path = "/setFixedNameFor") // Map ONLY Get By Student Requests
    public @ResponseBody String setFixedNameFor(@RequestParam String name,
                                                @RequestParam int id) {

        studentRepository.setFixedNameFor(name,id);
        return "PUT OK";
    }

    //Delete By Id
    @DeleteMapping(path = "/deleteById") // Map ONLY Delete All Requests
    public @ResponseBody String deleteById(@RequestParam int id) {
        studentRepository.deleteById(id);
        String showdeleteid = " Id " + id;
        return showdeleteid;
    }

}
