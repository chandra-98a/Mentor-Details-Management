package com.mentor.MentorService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mentor.MentorService.entity.Mentor;

public interface TeamRepository extends JpaRepository<Mentor, Long>{

}
