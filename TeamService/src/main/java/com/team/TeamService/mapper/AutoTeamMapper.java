package com.team.TeamService.mapper;

import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;

import com.team.TeamService.entity.Team;
import com.team.TeamService.entity.TeamDto;

@Mapper
public interface AutoTeamMapper {
	//CREATE AN INSTANCE USING MAPPER utility class
	
	 AutoTeamMapper MAPPER = Mappers.getMapper(AutoTeamMapper.class);
	
	
	//convert entity to dto object
      TeamDto mapToTeamDto (Team team);
      
      //convert dto to entity
      Team mapToTeam(TeamDto teamDto);
      
}
