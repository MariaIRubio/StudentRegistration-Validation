package com.exercise.studentregistrationvalidation.controller;

import com.exercise.studentregistrationvalidation.model.Student;
import com.exercise.studentregistrationvalidation.repo.StudentRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentRepo studentRepo;

    @GetMapping("/student")
    public String registration(Model model){
        model.addAttribute("student", new Student());
        return "registration-form";
    }

    @PostMapping("/save")
    public String processForm(@Valid @ModelAttribute("student") Student student, BindingResult binder){
        if(binder.hasErrors()){
            return "registration-form";
        }else {
            studentRepo.save(student);
            return "confirmation";
        }
    }

    @RequestMapping("/students-list")
    public String showList(Model model){
    List<Student> studentList = studentRepo.findAll();
    model.addAttribute("studentList", studentList);
        return "student-list";
    }
}
