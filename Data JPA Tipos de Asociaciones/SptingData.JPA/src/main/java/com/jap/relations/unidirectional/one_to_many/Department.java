package com.jap.relations.unidirectional.one_to_many;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name="uni_department_one_to_many")
@Table(name="uni_department_one_to_many")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //un departamento muchos empleadors
    @OneToMany
    @JoinColumn(name="department_id") //nombre del id que se va a crear
    private List<Employee> employees;
}
