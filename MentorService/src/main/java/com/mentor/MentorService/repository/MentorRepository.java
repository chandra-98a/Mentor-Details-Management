package com.mentor.MentorService.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.mentor.MentorService.entity.Mentor;

public interface MentorRepository extends JpaRepository<Mentor, Long>{

}
