package com.adam.service.Impl;

import com.adam.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    @Override
    public String getHelloWold() {
        return "Hello Wold";
    }
}
