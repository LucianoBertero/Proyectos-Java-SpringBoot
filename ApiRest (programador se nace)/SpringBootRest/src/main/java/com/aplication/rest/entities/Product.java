package com.aplication.rest.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

//loombok
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//jpa
@Entity
@Table(name="producto")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nombre")
    private String name;
    @Column(name="precio")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name="id_fabricante",nullable = false) //como se mostraria en la base de datos
    @JsonIgnore
    private Maker maker;

}
