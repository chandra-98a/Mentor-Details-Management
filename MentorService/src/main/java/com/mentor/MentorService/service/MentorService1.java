package com.mentor.MentorService.service;

import com.mentor.MentorService.dto.APIResponseDto;
import com.mentor.MentorService.dto.MentorDto;

public interface MentorService1 {
	
MentorDto saveMentor(MentorDto mentorDto);
APIResponseDto getMentorById(Long id);
}
