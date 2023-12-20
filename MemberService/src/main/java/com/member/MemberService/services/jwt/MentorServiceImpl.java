package com.member.MemberService.services.jwt;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.member.MemberService.entities.Mentor;
import com.member.MemberService.repository.MentorRepository;

@Service
public class MentorServiceImpl  implements  UserDetailsService{

	private final MentorRepository mentorRepository;
	
	
	@Autowired
	public MentorServiceImpl(MentorRepository mentorRepository) {
		super();
		this.mentorRepository = mentorRepository;
	}



	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// write logic to fetch mentor from DB
		Mentor mentor=mentorRepository.findByEmail(email)
				   .orElseThrow(() -> new UsernameNotFoundException("Mentor not found with email: " + email));

        return new User(mentor.getEmail(), mentor.getPassword(), Collections.emptyList());
    }
}

