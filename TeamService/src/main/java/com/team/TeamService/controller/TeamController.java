package com.team.TeamService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.TeamService.entity.TeamDto;
import com.team.TeamService.service.TeamService1;

@RestController
@RequestMapping("/api/teams")
public class TeamController {
	
	//inject dependency
	
	private TeamService1 teamService1;

	@Autowired
	public TeamController(TeamService1 teamService1) {
		super();
		this.teamService1 = teamService1;
	}
	//build save team rest api
	//Postmapping annotation map the http post requests on to specifice handler methods
	@PostMapping
	public ResponseEntity<TeamDto> saveTeam(@RequestBody TeamDto teamDto){ 
		//requestbody annotation internally uses http message converters 
		//and it will convert json into java object.
		TeamDto savedTeamDto=teamService1.saveTeam(teamDto);
		return new ResponseEntity<>(savedTeamDto,HttpStatus.CREATED);
		//ResponseEntity  class take two arguments javaobject and http status
	}

	
	
	
	

}
