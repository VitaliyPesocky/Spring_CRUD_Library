package com.app.controller;

import com.app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    private StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getStudent(Model model){
        model.addAttribute(studentRepository.getAllStudents());
        return "index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addStudent(Model model){
        return "addStudent";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addStudent(@RequestParam("name") String name){
        return "";
    }
}
