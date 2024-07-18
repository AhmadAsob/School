package com.example.school.Controller;

import com.example.school.Model.Student;
import com.example.school.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/getAllStudent")
    public ResponseEntity getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/getStudentByFilterId/{id}")
    public ResponseEntity getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/insertStudent")
    public ResponseEntity createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }
}
