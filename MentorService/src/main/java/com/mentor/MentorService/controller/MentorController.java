package com.mentor.MentorService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.mentor.MentorService.dto.APIResponseDto;
import com.mentor.MentorService.dto.MentorDto;
import com.mentor.MentorService.service.MentorService1;
@CrossOrigin(origins="http://localhost:4200")
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
	public ResponseEntity<APIResponseDto> mentorById(@PathVariable Long id){
		APIResponseDto apiResponseDto = mentorService1.getMentorById(id);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
	}
	
	@GetMapping("/mentorslist")
	public ResponseEntity<List<MentorDto>> getAllMentors(){
		List<MentorDto> mentorDto=mentorService1.getAllMentors();
		return new ResponseEntity<>(mentorDto, HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<MentorDto> updateMentor(
			@RequestBody MentorDto mentorDto,@PathVariable Long id){
		mentorDto.setId(id);
		MentorDto updatedMentor=mentorService1.updateMentor(mentorDto);
		
		return new ResponseEntity<>(updatedMentor, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteMentor(@PathVariable Long id){
		mentorService1.deleteMentor(id);
		return new ResponseEntity<>("Mentor Deleted successfully",HttpStatus.OK);
		
	}
	
}
