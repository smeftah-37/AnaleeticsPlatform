package com.example.demo.Team;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping(path = "api/Team")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService)
    {
        this.teamService = teamService;
    }

    @GetMapping
    public List<Team> getAll() {
        return this.teamService.getAllTeams();
    }
    @PostMapping("/add")
    public void addTeam(@RequestBody Team team) {
        System.out.println("in the controller ============>" + team + "---------------");
        this.teamService.addNewTeam(team);        
    }
    
}
