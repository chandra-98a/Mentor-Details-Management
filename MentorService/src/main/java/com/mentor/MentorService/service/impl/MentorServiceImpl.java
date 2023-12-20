package com.mentor.MentorService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentor.MentorService.entity.Mentor;
import com.mentor.MentorService.dto.MentorDto;
import com.mentor.MentorService.repository.MentorRepository;
import com.mentor.MentorService.service.MentorService1;
@Service
public class MentorServiceImpl implements MentorService1{
	
	//inject  repository dependency
	private MentorRepository mentorRepository;
	
	
	//Autowiring
	
	@Autowired
	public MentorServiceImpl(MentorRepository mentorRepository) {
		super();
		this.mentorRepository = mentorRepository;
	}
	
//save method
	@Override
	public MentorDto saveMentor(MentorDto mentorDto) {
		// convert dto to entity 
		
		Mentor mentor=new Mentor(
				mentorDto.getId(),
				mentorDto.getFirstName(),
				mentorDto.getLastName(),
				mentorDto.getEmail()
				);
		Mentor savedMentor=mentorRepository.save(mentor);
		
		//convert entity to dto
		
		MentorDto savedMentorDto = new MentorDto(
				savedMentor.getId(),
				savedMentor.getFirstName(),
				savedMentor.getLastName(),
				savedMentor.getEmail()
				
				);
		return savedMentorDto;

	}

	@Override
	public MentorDto getMentorById(Long id) {
		Mentor mentor=mentorRepository.findById(id).get();
		 
		
		MentorDto mentorDto=new MentorDto(
				
				mentor.getId(),
				mentor.getFirstName(),
				mentor.getLastName(),
				mentor.getEmail()
				);
		return mentorDto;
	}
}
