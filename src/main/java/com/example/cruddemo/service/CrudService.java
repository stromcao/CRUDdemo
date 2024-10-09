package com.example.cruddemo.service;

import com.example.cruddemo.entity.Student;
import com.example.cruddemo.mapper.CruddemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class CrudService {
    @Resource
    CruddemoMapper cruddemoMapper;
    public void Insert(Student student){
        cruddemoMapper.Create(student);
    }
    public ArrayList<Student> SelectAllStudents(){
        ArrayList<Student> students = cruddemoMapper.SelectAllStudents();
        return students;
    }
    public Student findStuByName(String name){
        System.out.println("这是一个测试");
        return cruddemoMapper.findStuByName(name);
    }
}
