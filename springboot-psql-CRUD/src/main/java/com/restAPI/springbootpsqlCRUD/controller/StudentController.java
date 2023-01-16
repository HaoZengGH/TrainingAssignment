package com.restAPI.springbootpsqlCRUD.controller;

import com.restAPI.springbootpsqlCRUD.pojo.dto.StudentResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.restAPI.springbootpsqlCRUD.pojo.dto.StudentResponseDTO.*;
import com.restAPI.springbootpsqlCRUD.service.StudentService;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service){
        this.service=service;
    }

    @GetMapping("/students")
    public ResponseEntity<StudentResponseDTO> getAllStudent(){
        return new ResponseEntity<>(service.getAllStudent(), HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDTO>getStudentById(@PathVariable(value="id")Long id){
        return new ResponseEntity<>(service.getStudentById(id), HttpStatus.OK);
    }

    @PostMapping("/students/{name}")
    public ResponseEntity<String> createStudent(@PathVariable(value="name")String name){
        service.createStudent(name);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }

    @PutMapping("/students/{id}/{name}")
    public ResponseEntity<StudentDTO>updateStudent(@PathVariable(value="id")Long id,@PathVariable(value="name")String name){
        return new ResponseEntity<>(service.updateStudent(id,name), HttpStatus.OK);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable(value="id")Long id){
        service.deleteStudent(id);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }

}
