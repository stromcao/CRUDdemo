package com.example.cruddemo.service;

import com.example.cruddemo.entity.Student;
import com.example.cruddemo.mapper.CurddemoMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CrudService {
    private CurddemoMapper curddemoMapper;
    @Autowired
    public CrudService(CurddemoMapper curddemoMapper){
        this.curddemoMapper = curddemoMapper;
    }
    public void Insert(Student student){
        curddemoMapper.Create(student);
    }
    public ArrayList<Student> SelectAllStudents(){
        ArrayList<Student> students = curddemoMapper.SelectAllStudents();
        return students;
    }
}
