package com.member.MemberService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.member.MemberService.dto.SignupRequest;
import com.member.MemberService.entities.Mentor;
import com.member.MemberService.services.AuthService;

@RestController
@RequestMapping("/signup")
public class SignupController {

	  private final AuthService authService;

	    @Autowired
	    public SignupController(AuthService authService) {
	        this.authService = authService;
	    }

	    @PostMapping
	    public ResponseEntity<?> signupMentor(@RequestBody SignupRequest signupRequest) {
	        Mentor createdMentor = authService.createMentor(signupRequest);
	        if (createdMentor != null) {
	            return ResponseEntity.status(HttpStatus.CREATED).body(createdMentor);
	        } else {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create Mentor");
	        }
	    }
		
		

	}



