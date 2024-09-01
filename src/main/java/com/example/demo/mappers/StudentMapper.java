package com.example.demo.mappers;

import com.example.demo.DTO.studentDtos.StudentDto;
import com.example.demo.DTO.studentDtos.StudentResponseDto;
import com.example.demo.Entities.School;
import com.example.demo.Entities.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student dtoToStudent(StudentDto studentDto)
    {
        var school = new School();
        school.setId(studentDto.schoolId());
        return new Student(
                studentDto.lastName(),
                studentDto.firstName(),
                studentDto.email(),
                school
        );
    }

    public StudentDto studentToDto(Student student)
    {
        return new StudentDto(
                student.getLastName(),
                student.getFirstName(),
                student.getEmail(),
                student.getSchool().getId()
        );
    }

    public StudentResponseDto studentToStudentResponseDto(Student student)
    {
        return new StudentResponseDto(
                student.getLastName(),
                student.getFirstName(),
                student.getEmail()
        );
    }
}
