package com.mentor.MentorService.service;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mentor.MentorService.dto.TeamDto;



@FeignClient(url="http://localhost:8082",value="TEAM-SERVICE")
public interface APIClient {

	// Build get team by code rest api
	
	@GetMapping("/api/teams/{teamCode}")
	TeamDto getTeamByCode(@PathVariable String teamCode);
		
}
