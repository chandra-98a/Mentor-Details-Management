package com.team.TeamService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team.TeamService.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long>{

}
