package com.example.CRUD.Service;

import com.example.CRUD.DTO.AllDto;
import com.example.CRUD.DTO.StudentCreateDto;
import com.example.CRUD.Model.Faculty;
import com.example.CRUD.Model.Fees;
import com.example.CRUD.Model.Salary;
import com.example.CRUD.Model.StudentModel;
import com.example.CRUD.Respository.FacultyRepo;
import com.example.CRUD.Respository.FeesRepo;
import com.example.CRUD.Respository.SalaryRepo;
import com.example.CRUD.Respository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    FacultyRepo facultyRepo;

    @Autowired
    FeesRepo feesRepo;

    @Autowired
    SalaryRepo salaryRepo;

    public List<StudentModel> getAllStudentFromDb(){
        return studentRepo.findAll();
    }

    public StudentModel crateStudentFromDb(StudentCreateDto payload){
        StudentModel st = new StudentModel();
        st.setName(payload.getName());
        return studentRepo.save(st);
    }

    public AllDto.FacultyResponseDto getAllFacultyListDb(AllDto.FacultyListDto payload){
        Stream<Faculty> allData = facultyRepo.findAll().stream();
        int total = (int) allData.count();
        List<Faculty> data = facultyRepo.findAll().stream().skip(payload.getPage()).limit(payload.getPageSize()).toList();
        int totalPages = total / payload.getPageSize();
        return new AllDto.FacultyResponseDto(data, total, totalPages);
    }

    public Faculty createFaculty(AllDto.CreateFaculty payload){
        Faculty faculty = new Faculty();
        faculty.setName(payload.getName());

        faculty = facultyRepo.save(faculty);

        Salary salary = new Salary();
        salary.setDate(LocalDate.now());
        salary.setSalary(payload.getFees());
        salary.setFaculty(faculty);

        salary = salaryRepo.save(salary);

        faculty.setSalaryList(List.of(salary));

        return faculty;
    }


}
