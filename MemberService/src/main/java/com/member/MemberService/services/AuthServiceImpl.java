package com.member.MemberService.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.member.MemberService.dto.SignupRequest;
import com.member.MemberService.entities.Mentor;
import com.member.MemberService.repository.MentorRepository;

@Service
public class AuthServiceImpl implements AuthService {
	

    private final MentorRepository mentorRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(MentorRepository mentorRepository, PasswordEncoder passwordEncoder) {
        this.mentorRepository = mentorRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Mentor createMentor(SignupRequest signupRequest) {
        //Check if mentor already exist
        if (mentorRepository.existsByEmail(signupRequest.getEmail())) {
            return null;
        }

        Mentor mentor = new Mentor();
        BeanUtils.copyProperties(signupRequest,mentor);

        //Hash the password before saving
        String hashPassword = passwordEncoder.encode(signupRequest.getPassword());
        mentor.setPassword(hashPassword);
        Mentor createdMentor= mentorRepository.save(mentor);
        mentor.setId(createdMentor.getId());
        return mentor;
    }

}
