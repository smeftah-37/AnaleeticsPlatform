package com.example.demo.Team;
import java.util.List;

import com.example.demo.User.User;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "teams")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer typeAbonnement;
    @OneToMany(mappedBy = "team")
    private List<User> users;

    


    public Team(){};
    public Team(String name, Integer type) {
        this.name = name;
        this.typeAbonnement = type;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter for typeAbonnement
    public Integer getTypeAbonnement() {
        return typeAbonnement;
    }
    public Long getId(){
        return id;
    }
    public void setTypeAbonnement(Integer typeAbonnement) {
        this.typeAbonnement = typeAbonnement;
    }
    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeAbonnement=" + typeAbonnement +
                '}';
    }
    
}
// {
//     "name" : "ayoub adila",
//     "dob": "1996-03-21",
//     "email": "ayoub.adila@gmail.com",
//     "category": "joueur",
//     "imageUrl": "image.png"

// }