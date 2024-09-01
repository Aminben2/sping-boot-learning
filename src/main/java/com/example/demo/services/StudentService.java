package com.example.demo.services;

import com.example.demo.DTO.studentDtos.StudentDto;
import com.example.demo.DTO.studentDtos.StudentResponseDto;
import com.example.demo.Entities.Student;
import com.example.demo.mappers.StudentMapper;
import com.example.demo.reposetiries.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepo studentRepo;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepo studentRepo, StudentMapper studentMapper) {
        this.studentRepo = studentRepo;
        this.studentMapper = studentMapper;
    }

    public List<StudentResponseDto> getALlStudents()
    {
        return studentRepo.findAll().stream()
                .map(studentMapper::studentToStudentResponseDto)
                .collect(Collectors.toList());
    }

    public StudentResponseDto getOneStudent(Integer id)
    {
        var student = studentRepo.findById(id).orElse(new Student());
        return studentMapper.studentToStudentResponseDto(student);
    }

    public StudentResponseDto createStudent(StudentDto studentDto)
    {
        var student = studentMapper.dtoToStudent(studentDto);
        var savedStudent = studentRepo.save(student);
        return studentMapper.studentToStudentResponseDto(savedStudent);
    }

    public void deleteStudent(Integer id)
    {
        studentRepo.deleteById(id);
    }
}
