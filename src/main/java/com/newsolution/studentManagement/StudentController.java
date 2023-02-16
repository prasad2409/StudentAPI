package com.newsolution.studentManagement;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    Map<Integer,Student> db = new HashMap<>();

    @GetMapping("/get_info")
    Student getStudent(@RequestParam("id") int admNo){
        return db.get(admNo);
    }

    @PostMapping("/add")
    String addStudent(@RequestBody Student student){
        db.put(student.getAdmNo(),student);
        return "Student has been add Successfully";
    }
    @DeleteMapping("/delete/{id}")
    String deleteStudent(@PathVariable("id") int admNo){
        db.remove(admNo);
        return "Student Deleted";
    }
}
