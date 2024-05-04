package com.example.demo.User;
import java.time.LocalDate;
import java.time.Period;

import com.example.demo.Team.Team;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "users") // Specify the table name explicitly
public class User {
    @Id
    @SequenceGenerator(
        name = "user_sequence",
        sequenceName = "user_sequence",
        allocationSize = 1
    )
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @ManyToOne
    private Team team;
    private String category;
    private String imageUrl;
    @Transient
    private Integer age;

    public User()
    {

    }
    public User(Long id, String name, String email, LocalDate dob,String category,String imageUrl,Integer teamId)
    {
        this.name = name;
        this.id = id;
        this.dob = dob;
        this.email = email;
        this.category = category;
        this.imageUrl = imageUrl;
    }
    public User( String name, String email, LocalDate dob,String category,String imageUrl,Integer teamId)
    {
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.category = category;
        this.imageUrl = imageUrl;


    }

    public String getName()
    {
        return name;
    }
    public String getImage()
    {
        return imageUrl;
    }
    public String getcategory()
    {
        return category;
    }
    public Long getId()
    {
        return id;
    }
    public String getEmail()
    {
        return email;
    }
    public LocalDate getDob()
    {
        return dob;
    }
    public Integer getAge()
    {
        return Period.between(dob,LocalDate.now()).getYears();
    }
    public void setTeam(Team team)
    {
        this.team = team;
    }
    @Override
        public String toString(){
            return "User{ id=" + id + ", name='" + name + '\'' + ", email=" + email + ", dob=" + dob + ", age=" + age + '}'; 
        }
}