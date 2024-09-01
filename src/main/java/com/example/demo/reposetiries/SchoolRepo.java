package com.example.demo.reposetiries;

import com.example.demo.Entities.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepo extends JpaRepository<School,Integer> {
}
