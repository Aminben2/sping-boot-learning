package com.example.demo.DTO.studentDtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
        @NotEmpty
        @NotBlank
        String lastName,

        @NotBlank
        @NotEmpty
        String firstName,

        @NotEmpty
        @Email
        String email,

        Integer schoolId
) {
}
