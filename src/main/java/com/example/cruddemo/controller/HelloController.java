package com.example.cruddemo.controller;

import com.example.cruddemo.entity.Student;
import com.example.cruddemo.mapper.CruddemoMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class HelloController {
    @Resource
    CruddemoMapper mapper;
    @ResponseBody
    @GetMapping ("/hello")
    public String hellotest(){
        return "这是一个hello测试！";
    }
    @ResponseBody
    @GetMapping ("/stu")
    public Student stutest(){
        return new Student("张三", 18);
    }

    @ResponseBody
    @GetMapping("/selectOne")
    public Student findStuByName(@RequestParam String name){
        return mapper.findStuByName(name);
    }
}
