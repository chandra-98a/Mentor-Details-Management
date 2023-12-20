package com.mentor.MentorService.service;

import com.mentor.MentorService.dto.MentorDto;

public interface MentorService1 {
	
MentorDto saveMentor(MentorDto mentorDto);
MentorDto getMentorById(Long id);
}
