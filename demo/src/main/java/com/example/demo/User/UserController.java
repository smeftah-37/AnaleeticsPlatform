package com.example.demo.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;



/**
 *
 * @author smeftah-
 */
@RestController
@RequestMapping(path = "api/User")
public class UserController{


    private final UserService UserService;
    @Autowired
    public UserController(UserService UserService)
    {
        this.UserService = UserService;
    }
    @GetMapping
    public List<User> index() {
        return UserService.getUser();
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<User>  getSudentById(@PathVariable("id") Long id) {
        User User = UserService.findUserById(id);
        return new ResponseEntity<>(User,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<User>  updateStuent(@RequestBody User User) {
        User updateUser = UserService.updateUser(User);
        return new ResponseEntity<>(updateUser,HttpStatus.OK);

        //TODO: process PUT request
        
    }
    @PostMapping("/add/{id}")
    public void regiserNewUser(@PathVariable("id") Long id ,@RequestBody User User)
    {
        this.UserService.addNewUser(User,id);
    }

    @DeleteMapping(path = "/{UserId}")
    public void deleteUser(@PathVariable("UserId") Long id)
    {
        this.UserService.deleteUser(id);
    }
   


}