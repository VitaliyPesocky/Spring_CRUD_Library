package com.app.controller;

import com.app.model.Student;
import com.app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {
    private StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getStudents(ModelMap model){
        List<Student> students = studentRepository.getAllStudents();
        model.addAttribute("students", students);
        return "index.jsp";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addStudent(Model model){
        return "addStudent";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addStudent(@RequestParam("name") String name, @RequestParam("age") String age, @RequestParam("isAdmin") Boolean isExtrumural, Model model){
        Student student = new Student(name, Integer.parseInt(age), isExtrumural);
        student.setCreatedDate();
        studentRepository.addStudent(student);
        return "redirect:/";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateStudent(Model model, @PathVariable Integer id){
        Student student = studentRepository.getStudentById(id);
        model.addAttribute("studentAttribute", student);
        return "updateStudent";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    public String updateStudent(@RequestParam("name") String name, @RequestParam("age") String age, @RequestParam("isAdmin") Boolean isExtrumural,
                                @PathVariable Integer id, Model model){
        Student student = studentRepository.getStudentById(id);
        student.setName(name);
        student.setAge(Integer.parseInt(age));
        student.setExtrumural(isExtrumural);
        studentRepository.updateStudent(student);
        return "redirect:/";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable Integer id){
        studentRepository.deleteStudent(id);
        return "redirect:/";
    }
}
