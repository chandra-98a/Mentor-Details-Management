package com.team.TeamService.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamDto {
	
	private Long id;
	private String teamName;
	private String teamDescription;
	private String teamCode;
	
	//getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamDescription() {
		return teamDescription;
	}
	public void setTeamDescription(String teamDescription) {
		this.teamDescription = teamDescription;
	}
	public String getTeamCode() {
		return teamCode;
	}
	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}
	//parameterized constructor
	public TeamDto(Long id, String teamName, String teamDescription, String teamCode) {
		super();
		this.id = id;
		this.teamName = teamName;
		this.teamDescription = teamDescription;
		this.teamCode = teamCode;
	}
	public TeamDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
