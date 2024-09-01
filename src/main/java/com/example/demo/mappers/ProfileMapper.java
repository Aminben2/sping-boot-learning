package com.example.demo.mappers;

import com.example.demo.DTO.profileDtos.ProfileDto;
import com.example.demo.DTO.profileDtos.ProfileResponseDto;
import com.example.demo.Entities.Student;
import com.example.demo.Entities.StudentProfile;
import org.springframework.stereotype.Component;


@Component
public class ProfileMapper {

    public StudentProfile dtoToProfile(ProfileDto profileDto)
    {
        var std = new Student();
        std.setId(profileDto.studentId());
        return new StudentProfile(
                profileDto.bio(),
                std
        );
    }

    public ProfileDto profileToDto(StudentProfile studentProfile)
    {
        return new ProfileDto(
                studentProfile.getBio(),
                studentProfile.getStudent().getId()
        );
    }

    public ProfileResponseDto profileToProfileResponseDto(StudentProfile studentProfile)
    {
        return new ProfileResponseDto(
                studentProfile.getBio()
        );
    }
}
