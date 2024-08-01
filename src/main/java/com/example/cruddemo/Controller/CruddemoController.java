package com.example.cruddemo.Controller;

import com.example.cruddemo.entity.Student;
import com.example.cruddemo.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/students")
public class CruddemoController {
    @Autowired
    CrudService crudService;

    @PostMapping("create")
    public String create(@RequestBody Student student){
        crudService.Insert(student);
        return "增加成功";
    }
    @GetMapping("SelectAllStudents")
    public ArrayList<Student> SelectAllStudents(){
        ArrayList<Student> students = crudService.SelectAllStudents();
        return students;
    }
}
