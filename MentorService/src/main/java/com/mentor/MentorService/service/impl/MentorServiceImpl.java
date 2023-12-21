package com.mentor.MentorService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mentor.MentorService.entity.Mentor;
import com.mentor.MentorService.dto.APIResponseDto;

import com.mentor.MentorService.dto.MentorDto;
import com.mentor.MentorService.dto.TeamDto;
import com.mentor.MentorService.repository.MentorRepository;
import com.mentor.MentorService.service.MentorService1;
@Service
public class MentorServiceImpl implements MentorService1{
	
	//inject  repository dependency
	private MentorRepository mentorRepository;
	
	//inject rest template dependency step3
	private RestTemplate restTemplate;

	
	//Autowiring
	
	@Autowired
	public MentorServiceImpl(MentorRepository mentorRepository,RestTemplate restTemplate) {
		super();
		this.mentorRepository = mentorRepository;
		this.restTemplate=restTemplate;
	}
	
//save method
	@Override
	public MentorDto saveMentor(MentorDto mentorDto) {
		// convert dto to entity 
		
		Mentor mentor=new Mentor(
				mentorDto.getId(),
				mentorDto.getFirstName(),
				mentorDto.getLastName(),
				mentorDto.getEmail(),
				mentorDto.getTeamCode()
				);
		Mentor savedMentor=mentorRepository.save(mentor);
		
		//convert entity to dto
		
		MentorDto savedMentorDto = new MentorDto(
				savedMentor.getId(),
				savedMentor.getFirstName(),
				savedMentor.getLastName(),
				savedMentor.getEmail(),
				savedMentor.getTeamCode()
				
				);
		return savedMentorDto;

	}
//get method
	@Override
	public APIResponseDto getMentorById(Long id) {
		Mentor mentor=mentorRepository.findById(id).get();
		 //step3
		 ResponseEntity<TeamDto> responseEntity = restTemplate.getForEntity("http://localhost:8082/api/teams/" + mentor.getTeamCode(),
               TeamDto.class);

	    TeamDto teamDto=responseEntity.getBody();
		
		MentorDto mentorDto=new MentorDto(
				
				mentor.getId(),
				mentor.getFirstName(),
				mentor.getLastName(),
				mentor.getEmail(),
				mentor.getTeamCode()
				);
		//step3
		APIResponseDto apiResponseDto=new APIResponseDto();
		apiResponseDto.setMentor(mentorDto);
		apiResponseDto.setTeam(teamDto);
		return apiResponseDto;
	}
}
