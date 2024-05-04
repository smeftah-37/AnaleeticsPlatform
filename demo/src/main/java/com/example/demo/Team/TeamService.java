package com.example.demo.Team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.User.UserRepository;

@Service
public class TeamService {
    private final UserRepository userRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(UserRepository userRepository, TeamRepository teamRepository)
    {
        this.userRepository = userRepository;
        this.teamRepository = teamRepository;
    }
    public List<Team> getAllTeams()
    {
        return teamRepository.findAll();
    }

    public void addNewTeam(Team team){
        System.out.println("team ===================>"+team);
        teamRepository.save(team);
    }

    
}
