package com.example.demo.DTO.schoolDtos;

import com.example.demo.DTO.studentDtos.StudentResponseDto;

import java.util.List;

public record SchoolResponseDto(
        String name,
        List<StudentResponseDto> students
) {
}
