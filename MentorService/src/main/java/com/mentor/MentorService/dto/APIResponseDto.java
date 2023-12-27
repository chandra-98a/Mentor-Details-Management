package com.mentor.MentorService.dto;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class APIResponseDto {
	
	private MentorDto mentor;
	
	private TeamDto team;

	public APIResponseDto(MentorDto mentor, TeamDto team) {
		super();
		this.mentor = mentor;
		this.team = team;
	}

	public APIResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MentorDto getMentor() {
		return mentor;
	}

	public void setMentor(MentorDto mentor) {
		this.mentor = mentor;
	}

	public TeamDto getTeam() {
		return team;
	}

	public void setTeam(TeamDto team) {
		this.team = team;
	}
	
	
	

}
