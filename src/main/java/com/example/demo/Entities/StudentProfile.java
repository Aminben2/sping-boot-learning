package com.example.demo.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "student_profile")
public class StudentProfile {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "bio")
    private String bio;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public StudentProfile() {
    }

    public StudentProfile(String bio, Student student) {
        this.bio = bio;
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

