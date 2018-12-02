package com.attc.cattail.service;

import com.attc.cattail.entity.primary.Student;
import com.attc.cattail.entity.primary.Teacher_pri;
import com.attc.cattail.entity.secondary.Teacher;
import java.util.List;

public interface MyService {
    List<Student> findAll();

    void addOne(Student user);

    void delOne(Integer id);

    Student findOne(Integer id);

    Student modifyOne(Student user);

    List<Teacher> findTeacherAll();

    List<Teacher_pri> findTeacherPriAll();
}
