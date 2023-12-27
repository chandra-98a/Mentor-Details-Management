package com.mentor.MentorService.mapper;

import com.mentor.MentorService.dto.MentorDto;
import com.mentor.MentorService.entity.Mentor;

public class MentorMapper {
	
	//mapping mentor entity to mentor dto object
	public static MentorDto mapToMentorDto(Mentor mentor) {
		MentorDto mentorDto=new MentorDto(
				mentor.getId(),
				mentor.getFirstName(),
				mentor.getLastName(),
				mentor.getEmail(),
				mentor.getTeamCode()
				);
		
		return mentorDto;
		
	}
	//mapping  mentor dto object to mentor entity
	
	public static Mentor mapToMentor(MentorDto mentorDto) {
		
		Mentor mentor=new Mentor(
				mentorDto.getId(),
				mentorDto.getFirstName(),
				mentorDto.getLastName(),
				mentorDto.getEmail(),
				mentorDto.getTeamCode()
				);
		return mentor;
		
	}
}
