package com.example.demo.controllers;

import com.example.demo.DTO.schoolDtos.SchoolDto;
import com.example.demo.DTO.schoolDtos.SchoolResponseDto;
import com.example.demo.services.SchoolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schools")
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("/")
    public List<SchoolResponseDto> getALlSchools()
    {
        return schoolService.getALlSchools();
    }

    @PostMapping("/")
    public SchoolResponseDto createSchool(@RequestBody SchoolDto schoolDto)
    {
        return schoolService.createSchool(schoolDto);
    }
}
