package com.example.cruddemo.mapper;

import com.example.cruddemo.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface CurddemoMapper {
    @Insert("INSERT INTO student(name,age) VALUES(#{name},#{age}) ")
    void Create(Student student);
    @Select("Select * from student")
    ArrayList<Student> SelectAllStudents();

}
