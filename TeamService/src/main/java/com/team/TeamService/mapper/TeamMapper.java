package com.team.TeamService.mapper;

import com.team.TeamService.entity.Team;
import com.team.TeamService.entity.TeamDto;

public class TeamMapper {
	
	//Mapper entity manually maps the objects from one model to another, thus reducing the need for manual mapping code. 
	//This can save a lot of time and effort, and can also help to reduce the risk of errors.
	
	
	//converting Team entity into TeamDto object
	public static TeamDto mapToTeamDto(Team team) {
		TeamDto teamDto=new TeamDto(
				team.getId(),
				team.getTeamName(),
				team.getTeamDescription(),
				team.getTeamCode()
				);
		return teamDto;
	}
	//converting TeamDto into Team Entity object
	public static Team mapToTeam(TeamDto teamDto) {
        Team team=new Team(
        	teamDto.getId(),
        	teamDto.getTeamName(),
        	teamDto.getTeamDescription(),
        	teamDto.getTeamCode()
        	);
        return team;
        }
}
