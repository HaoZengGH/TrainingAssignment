package com.restAPI.springbootpsqlCRUD.service;

import static com.restAPI.springbootpsqlCRUD.pojo.dto.StudentResponseDTO.*;

import com.restAPI.springbootpsqlCRUD.pojo.dto.StudentResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    StudentResponseDTO getAllStudent();
    StudentDTO getStudentById(Long id);
    void createStudent(String name);
    StudentDTO updateStudent(Long id,String name);
    void deleteStudent(Long id);
}

