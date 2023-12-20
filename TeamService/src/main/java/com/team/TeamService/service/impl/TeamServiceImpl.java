package com.team.TeamService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.TeamService.entity.Team;
import com.team.TeamService.entity.TeamDto;
import com.team.TeamService.repository.TeamRepository;
import com.team.TeamService.service.TeamService1;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class TeamServiceImpl implements TeamService1{
	
	//inject team repository dependency
	private TeamRepository teamRepository;
	
// A class with single argument provide  autowire automatically. So, no need to write the below code.	
//we can use AlArgsConstructor instead of writing parameterized constructor manually
	
	@Autowired
	public TeamServiceImpl(TeamRepository teamRepository) {
		super();
		this.teamRepository = teamRepository;
	}



	@Override
	public TeamDto saveTeam(TeamDto teamDto) {
		//convert team dto to team jpa entity
		
		Team team=new Team(
				teamDto.getId(),
				teamDto.getTeamName(),
				teamDto.getTeamDescription(),
				teamDto.getTeamCode()
				);
		
		Team savedTeam=teamRepository.save(team);
		// save(team)= store the jpa entity obj to database
		
		
		//savedTeam obj is in the form of jpa entity 
		// need to convert it into dto object savedTeamDtoh
		TeamDto savedTeamDto=new TeamDto(
				savedTeam.getId(),
				savedTeam.getTeamName(),
				savedTeam.getTeamDescription(),
				savedTeam.getTeamCode()
				);
		return savedTeamDto;
		
		
		
		
	}

}
