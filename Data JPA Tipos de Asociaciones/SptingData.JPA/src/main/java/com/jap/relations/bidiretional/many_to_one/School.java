package com.jap.relations.bidiretional.many_to_one;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name="bi_school_many_to_one")
@Table(name="bi_school_many_to_one")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "schools",fetch = FetchType.LAZY)
    private List<Student> students;

}
