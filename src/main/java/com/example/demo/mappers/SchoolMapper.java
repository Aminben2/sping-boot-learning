package com.example.demo.mappers;

import com.example.demo.DTO.schoolDtos.SchoolDto;
import com.example.demo.DTO.schoolDtos.SchoolResponseDto;
import com.example.demo.Entities.School;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class SchoolMapper {

    private final StudentMapper studentMapper;

    public SchoolMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public School dtoToSchool(SchoolDto schoolDto)
    {
        return new School(
                schoolDto.name()
        );
    }

    public SchoolDto schoolToDto(School school)
    {
        return new SchoolDto(
                school.getName()
        );
    }

    public SchoolResponseDto schoolToSchoolResponseDto(School school)
    {
        return new SchoolResponseDto(
                school.getName(),
                school.getStudents()
                        .stream()
                        .map(studentMapper::studentToStudentResponseDto)
                        .collect(Collectors.toList())
        );
    }
}
