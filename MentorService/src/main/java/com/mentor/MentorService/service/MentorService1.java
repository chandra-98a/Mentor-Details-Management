package com.mentor.MentorService.service;

import java.util.List;

import com.mentor.MentorService.dto.APIResponseDto;

import com.mentor.MentorService.dto.MentorDto;
public interface MentorService1 {
	
MentorDto saveMentor(MentorDto mentorDto);
APIResponseDto getMentorById(Long id);
MentorDto updateMentor(MentorDto mentorDto);

List<MentorDto> getAllMentors();

void deleteMentor(Long id);
}
