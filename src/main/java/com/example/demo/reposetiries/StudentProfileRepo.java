package com.example.demo.reposetiries;

import com.example.demo.DTO.profileDtos.ProfileResponseDto;
import com.example.demo.Entities.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentProfileRepo extends JpaRepository<StudentProfile, Integer> {
    ProfileResponseDto findByStudentId(Integer id);
}
