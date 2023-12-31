package com.team.TeamService.service.impl;

import org.modelmapper.ModelMapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.TeamService.entity.Team;
import com.team.TeamService.entity.TeamDto;
import com.team.TeamService.mapper.AutoTeamMapper;
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
	public TeamServiceImpl(TeamRepository teamRepository,ModelMapper modelMapper) {
		super();
		this.teamRepository = teamRepository;
	}

	
    



// save method
	@Override
	public TeamDto saveTeam(TeamDto teamDto) {
		
		//convert dto to entity-->refer TeamMapper
		//Team team=TeamMapper.mapToTeam(teamDto);
		
		//using model mapper
		//Team team=modelMapper.map(teamDto,Team.class);
		
		//using MapStruct
		Team team=AutoTeamMapper.MAPPER.mapToTeam(teamDto);
		
		Team savedTeam=teamRepository.save(team);
		// save(team)= store the jpa entity obj to database
		
		
		//  convert savedTeam into savedTeamDto-->refer TeamMapper class
		//TeamDto savedTeamDto=TeamMapper.mapToTeamDto(savedTeam);
		
		
		//using modelmapper
		//TeamDto savedTeamDto=modelMapper.map(savedTeam,TeamDto.class);
		
		
		//using mapstruct
		TeamDto savedTeamDto=AutoTeamMapper.MAPPER.mapToTeamDto(savedTeam);
		return savedTeamDto;
		
		
	}

	//getTeamByCode method

@Override
public TeamDto getTeamByCode(String teamCode) {
	//team is a jpa entity
	Team team=teamRepository.findByTeamCode(teamCode);
	//convert team jpa entity into dto object
	//TeamDto teamDto=TeamMapper.mapToTeamDto(team);
	
	//using modelmapper
	//TeamDto teamDto=modelMapper.map(team, TeamDto.class);
	
	
	//using mapstruct
	
	TeamDto teamDto=AutoTeamMapper.MAPPER.mapToTeamDto(team);
	
	return teamDto;
}


	

}
