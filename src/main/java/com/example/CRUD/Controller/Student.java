package com.example.CRUD.Controller;

import com.example.CRUD.DTO.AllDto;
import com.example.CRUD.DTO.StudentCreateDto;
import com.example.CRUD.Model.Faculty;
import com.example.CRUD.Model.StudentModel;
import com.example.CRUD.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Student {

    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public ResponseEntity<List<StudentModel>> getAllUserInfo(){
        System.out.println("sakhti");
       return ResponseEntity.ok(studentService.getAllStudentFromDb());
    }

    @PostMapping("/")
    public ResponseEntity<StudentModel> createNewStudent(@RequestBody StudentCreateDto payload){
       return ResponseEntity.ok(studentService.crateStudentFromDb(payload));
    }

    @GetMapping("/staff")
    public ResponseEntity<AllDto.FacultyResponseDto> listFaculty(@Valid @ModelAttribute AllDto.FacultyListDto payload){
        System.out.println(payload);
        return ResponseEntity.ok(studentService.getAllFacultyListDb(payload));
    }

    @PostMapping("/staff")
    public ResponseEntity<Faculty> createFaculty(@Valid @RequestBody AllDto.CreateFaculty payload){
        return ResponseEntity.ok(studentService.createFaculty(payload));
    }

}
