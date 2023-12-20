package com.member.MemberService.services;

import com.member.MemberService.dto.SignupRequest;
import com.member.MemberService.entities.Mentor;

public interface AuthService {


	

	Mentor createMentor(SignupRequest signupRequest);
	

}
