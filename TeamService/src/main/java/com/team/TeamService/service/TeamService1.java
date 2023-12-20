package com.team.TeamService.service;

import com.team.TeamService.entity.TeamDto;

public interface TeamService1 {
	TeamDto saveTeam(TeamDto teamDto);
    TeamDto getTeamByCode(String code);
}
