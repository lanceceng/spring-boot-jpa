package com.attc.cattail.controller;

import com.alibaba.fastjson.JSONObject;
import com.attc.cattail.entity.primary.Student;
import com.attc.cattail.entity.primary.Teacher_pri;
import com.attc.cattail.entity.secondary.Teacher;
import com.attc.cattail.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    MyService myService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/all")
    @ResponseBody
    public JSONObject findAll() {
        List<Student> list = myService.findAll();
        List<Teacher_pri> t_list = myService.findTeacherPriAll();
        JSONObject json = new JSONObject();
        json.put("s_data", list);
        json.put("t_data", t_list);
        return json;
    }

    @RequestMapping("/add")
    @ResponseBody
    public JSONObject addOne(Student student) {
        myService.addOne(student);
        JSONObject json = new JSONObject();
        json.put("data", student);
        return json;
    }

    @RequestMapping("/del")
    public void delOne(Integer id) {
        myService.delOne(id);
    }

    @RequestMapping("/find")
    @ResponseBody
    public JSONObject findOne(Integer id) {
        Student student = myService.findOne(id);
        JSONObject json = new JSONObject();
        json.put("data", student);
        return json;
    }


    @RequestMapping("/modify")
    @ResponseBody
    public JSONObject modifyOne(Student user) {
        Student student = myService.modifyOne(user);
        JSONObject json = new JSONObject();
        json.put("data", student);
        return json;
    }

    @RequestMapping("/workAll")
    @ResponseBody
    public JSONObject workAll() {
        List<Teacher> list = myService.findTeacherAll();
        JSONObject json = new JSONObject();
        json.put("data", list);
        return json;
    }
}