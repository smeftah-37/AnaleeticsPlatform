package com.example.demo.User;
import com.example.demo.Team.Team;
import com.example.demo.User.UserRepository;

import com.example.demo.Team.TeamRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService{
    private final UserRepository UserRepository;
    private final TeamRepository TeamRepository;
    @Autowired
    public UserService(UserRepository UserRepository,TeamRepository TeamRepository)
    {
        this.UserRepository = UserRepository;
        this.TeamRepository = TeamRepository;
    }
    public List<User> getUser() {
        return UserRepository.findAll();
    }
    public void addNewUser(User User,Long teamId)
    {
        Optional<User> UserByEmail = UserRepository.findUserByEmail(User.getEmail());
        if(UserByEmail.isPresent())
        {
            throw new IllegalStateException("email taken");
        }
        Optional<Team> teamOptional = TeamRepository.findById(teamId);
        if(!teamOptional.isPresent())
        {
            System.out.println("there is any team with this id"
            );
            return;
        }
        Team team = teamOptional.get();
        User.setTeam(team);
        UserRepository.save(User);
    }
    public User checkLogin(UserCredentials userCred)
    {

        Optional<User> user = this.UserRepository.findUserByUsername(userCred.getUsername());
        if(user.isPresent() && user.get().getPassword().equals(userCred.getPassword()))
            return user.get();
        else
            return null;
    }
    public void deleteUser(Long id)
    {
        boolean exists = UserRepository.existsById(id);

        if(!exists)
        {
            throw new IllegalStateException("User with id " + id + " does not exist");
        }
        UserRepository.deleteById(id);

    }
    public User findUserById(Long id)
    {
       return  UserRepository.findUserById(id).orElseThrow(() -> new UserNotFoundException ("the user you looking for is not found"));
    }
    public User updateUser(User User)
    {
        return UserRepository.save(User);
    }
}