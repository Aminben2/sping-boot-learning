package com.example.demo.services;

import com.example.demo.DTO.schoolDtos.SchoolDto;
import com.example.demo.DTO.schoolDtos.SchoolResponseDto;
import com.example.demo.mappers.SchoolMapper;
import com.example.demo.reposetiries.SchoolRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    private final SchoolRepo schoolRepo;
    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolRepo schoolRepo, SchoolMapper schoolMapper) {
        this.schoolRepo = schoolRepo;
        this.schoolMapper = schoolMapper;
    }

    public List<SchoolResponseDto> getALlSchools()
    {
        return schoolRepo.findAll()
                .stream()
                .map(schoolMapper::schoolToSchoolResponseDto)
                .collect(Collectors.toList());
    }

    public SchoolResponseDto createSchool(SchoolDto schoolDto)
    {
        var school = schoolMapper.dtoToSchool(schoolDto);
        return schoolMapper.schoolToSchoolResponseDto(schoolRepo.save(school));
    }
}
