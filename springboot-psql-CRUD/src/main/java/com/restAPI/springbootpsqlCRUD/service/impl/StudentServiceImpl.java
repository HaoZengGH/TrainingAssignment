package com.restAPI.springbootpsqlCRUD.service.impl;

import com.restAPI.springbootpsqlCRUD.exception.GlobalException;
import com.restAPI.springbootpsqlCRUD.pojo.dto.StudentResponseDTO;
import static com.restAPI.springbootpsqlCRUD.pojo.dto.StudentResponseDTO.*;

import com.restAPI.springbootpsqlCRUD.pojo.entity.Student;
import com.restAPI.springbootpsqlCRUD.repository.StudentRepository;
import com.restAPI.springbootpsqlCRUD.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public StudentResponseDTO getAllStudent() {
        List<Student> studentCollection = studentRepository.findAll();
        List<StudentDTO> studentDTOS = studentCollection
                .stream()
                .map(s -> new StudentDTO(s))
                .collect(Collectors.toList());
        return new StudentResponseDTO(studentDTOS);
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id).get();
        if(student == null) {
            throw new GlobalException("no such student");
        }
        return new StudentDTO(student);
    }

    @Override
    public void createStudent(String name){
        studentRepository.save(new Student(name));
    }

    @Override
    public StudentDTO updateStudent(Long id,String name){
        studentRepository.saveAndFlush(new Student(id,name));
        Student student=studentRepository.findById(id).get();
        return new StudentDTO(student);
    }

    @Override
    public void deleteStudent(Long id){
        Student student = studentRepository.findById(id).get();
        if(student == null) {
            throw new GlobalException("no such student");
        }
        studentRepository.delete(student);
    }

}
