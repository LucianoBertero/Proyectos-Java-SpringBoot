package com.aplication.rest.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

//loombok
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//jpa
@Entity
@Table(name="fabricante")
public class Maker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nombre")
    private String name;
    //que papel juega el maker, el fabricante es uno y el productto es mucho
    //el orpahn remove dice que si elimino uno el producto se elimna, si eliminamos el creador el procucto tambien
    @OneToMany(mappedBy = "maker",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    @JsonIgnore
    private List<Product> products = new ArrayList<>();


}
