package com.example.cruddemo.controller;

import com.example.cruddemo.entity.Student;
import com.example.cruddemo.service.CrudService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

@RestController
@RequestMapping("/students")
public class CruddemoController {
    @Resource
    CrudService crudService;

    @PostMapping("/create")
    public String create(@ModelAttribute Student student){
        crudService.Insert(student);
        return "增加成功";
    }

    @GetMapping("/selectAll")
    public ArrayList<Student> SelectAllStudents(){
        ArrayList<Student> students = crudService.SelectAllStudents();
        return students;
    }

    @GetMapping("/selectOne")
    public Student findStuByName(@RequestParam String name){
        System.out.println("这里是控制器");
        return crudService.findStuByName(name);
    }
}