package com.example.demo.DTO.studentDtos;

import com.example.demo.Entities.Student;

import java.util.List;

public record StudentResponseDto(
        String lastName,
        String firstName,
        String email
) {
}
