package com.mentor.MentorService.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.mentor.MentorService.entity.Mentor;
import com.mentor.MentorService.mapper.MentorMapper;
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
	//private RestTemplate restTemplate;

	private WebClient webClient;
	
	//Autowiring
	
	@Autowired
	public MentorServiceImpl(MentorRepository mentorRepository,WebClient webClient) {
		super();
		this.mentorRepository = mentorRepository;
		//this.restTemplate=restTemplate;
		this.webClient=webClient;
	}
	
//save method
	@Override
	public MentorDto saveMentor(MentorDto mentorDto) {
		// convert dto to entity 
		
		Mentor mentor=MentorMapper.mapToMentor(mentorDto);
		Mentor savedMentor=mentorRepository.save(mentor);
		
		//convert entity to dto
		
		MentorDto savedMentorDto = MentorMapper.mapToMentorDto(savedMentor);
		return savedMentorDto;

	}
//get-by-id method
	@Override
	public APIResponseDto getMentorById(Long id) {
		Mentor mentor=mentorRepository.findById(id).get();
		 //step3
			/*
			 * ResponseEntity<TeamDto> responseEntity =
			 * restTemplate.getForEntity("http://localhost:8082/api/teams/" +
			 * mentor.getTeamCode(), TeamDto.class);
			 * 
			 * TeamDto teamDto=responseEntity.getBody();
			 */
		TeamDto teamDto=webClient.get()
				.uri("http://localhost:8082/api/teams/" + mentor.getTeamCode())
				.retrieve()
				.bodyToMono(TeamDto.class)
				.block();
		
		MentorDto mentorDto=MentorMapper.mapToMentorDto(mentor);
		//step3
		APIResponseDto apiResponseDto=new APIResponseDto();
		apiResponseDto.setMentor(mentorDto);
		apiResponseDto.setTeam(teamDto);
		return apiResponseDto;
	}
//put method

	@Override
	public MentorDto updateMentor(MentorDto mentorDto) {
	    // Convert DTO to entity
		Mentor mentor=MentorMapper.mapToMentor(mentorDto);
	    Mentor existingMentor = mentorRepository.findById(mentor.getId()).get();
	        
	        // Update the fields
	    existingMentor.setFirstName(mentorDto.getFirstName());
	        existingMentor.setLastName(mentorDto.getLastName());
	        existingMentor.setEmail(mentorDto.getEmail());
	        existingMentor.setTeamCode(mentorDto.getTeamCode());

	        // Save the changes to the database
	        Mentor updatedMentor = mentorRepository.save(existingMentor);

	        // Convert the updated entity to DTO
	        MentorDto updatedMentorDto = MentorMapper.mapToMentorDto(updatedMentor);

	        // Return the updated DTO object
	        return updatedMentorDto;
	  
	}
//get all mentors
	@Override
	public List<MentorDto> getAllMentors() {
	    List<Mentor> allMentors = mentorRepository.findAll();
	    List<MentorDto> allMentorDtos = new ArrayList<>();

	    // Mapping Mentor entities to MentorDto objects
	    for (Mentor mentor : allMentors) {
	        MentorDto mentorDto = MentorMapper.mapToMentorDto(mentor);
	        allMentorDtos.add(mentorDto);
	    }

	    return allMentorDtos;
	}
//delete method
	@Override
	public void deleteMentor(Long id) {
	mentorRepository.deleteById(id);
	}
}