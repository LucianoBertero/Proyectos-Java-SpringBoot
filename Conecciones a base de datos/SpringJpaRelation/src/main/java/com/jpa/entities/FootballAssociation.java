package com.jpa.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FootballAssociation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String country;
    private String president;

    @OneToMany(targetEntity = Club.class,fetch = FetchType.LAZY,mappedBy = "clubs")
    private List<Club> clubs;

}
