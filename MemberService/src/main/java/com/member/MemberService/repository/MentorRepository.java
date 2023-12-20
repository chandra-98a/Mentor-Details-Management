package com.member.MemberService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.member.MemberService.entities.Mentor;
@Repository
public interface MentorRepository extends JpaRepository<Mentor,Long>{


	

	boolean existsByEmail(String email);

	Optional<Mentor> findByEmail(String email);

}
