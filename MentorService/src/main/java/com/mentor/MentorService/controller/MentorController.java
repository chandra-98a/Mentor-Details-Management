package com.mentor.MentorService.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.mentor.MentorService.dto.APIResponseDto;
import com.mentor.MentorService.dto.MentorDto;
import com.mentor.MentorService.service.MentorService1;

@RestController
@RequestMapping("/api/mentors")
public class MentorController {

	//inject service dependency
	private MentorService1 mentorService1;
	//Autowiring
	@Autowired
	public MentorController(MentorService1 mentorService1) {
		super();
		this.mentorService1 = mentorService1;
	}
	//build save rest api
	@PostMapping
	public ResponseEntity<MentorDto> saveMentor(@RequestBody MentorDto mentorDto){
		MentorDto savedMentor=mentorService1.saveMentor(mentorDto);
		return new ResponseEntity<>(savedMentor,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<APIResponseDto> MentorById(@PathVariable Long id){
		APIResponseDto apiResponseDto = mentorService1.getMentorById(id);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
	}
	
}
