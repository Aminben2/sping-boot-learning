package com.example.demo.services;

import com.example.demo.DTO.profileDtos.ProfileDto;
import com.example.demo.DTO.profileDtos.ProfileResponseDto;
import com.example.demo.mappers.ProfileMapper;
import com.example.demo.reposetiries.StudentProfileRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentProfileService {

    private final StudentProfileRepo studentProfileRepo;
    private final ProfileMapper profileMapper;

    public StudentProfileService(StudentProfileRepo studentProfileRepo, ProfileMapper profileMapper) {
        this.studentProfileRepo = studentProfileRepo;
        this.profileMapper = profileMapper;
    }

    public ProfileResponseDto getStudentProfile(Integer id)
    {
        return studentProfileRepo.findByStudentId(id);
    }

    public List<ProfileResponseDto> getAllProfiles()
    {
        return studentProfileRepo.findAll()
                .stream()
                .map(profileMapper::profileToProfileResponseDto)
                .collect(Collectors.toList());
    }

    private ProfileResponseDto createProfile(ProfileDto profileDto)
    {
        var profile = profileMapper.dtoToProfile(profileDto);
        return profileMapper.profileToProfileResponseDto(studentProfileRepo.save(profile));
    }

    private ProfileResponseDto updateProfile(ProfileDto profileDto)
    {
        return null;
    }

    private void deleteProfile(Integer id)
    {
        studentProfileRepo.deleteById(id);
    }
}
