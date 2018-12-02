package com.attc.cattail.service.impl;

import com.attc.cattail.entity.primary.Student;
import com.attc.cattail.entity.primary.Teacher_pri;
import com.attc.cattail.entity.secondary.Teacher;
import com.attc.cattail.repository.primary.MyRepository;
import com.attc.cattail.repository.primary.TeacherPriRepository;
import com.attc.cattail.repository.secondary.TeacherRepository;
import com.attc.cattail.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MyServiceImpl implements MyService {
    @Autowired
    MyRepository myRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    TeacherPriRepository teacherPriRepository;

    @Override
    public List<Student> findAll() {
        return myRepository.findAll();
    }

    @Override
    public void addOne(Student user) {
        myRepository.saveAndFlush(user);
    }

    @Override
    public void delOne(Integer id) {
        myRepository.deleteById(id);
    }

    @Override
    public Student findOne(Integer id) {
        return myRepository.getOne(id);
    }

    @Override
    public Student modifyOne(Student student) {
        myRepository.modifyOne(student.getName(),student.getAge(),student.getClassname(),student.getId());
        return myRepository.getOne(student.getId());
    }

    @Override
    public List<Teacher> findTeacherAll() {
        return teacherRepository.findAll();
    }

    @Override
    public List<Teacher_pri> findTeacherPriAll() {
        return teacherPriRepository.findAll();
    }
}
