package com.jpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @Column(name="last_name")
    private String lastName;
    private Integer age;
    private String nacionality;
    private String position;

    @ManyToOne(targetEntity=Club.class)
    private Club club;


}
