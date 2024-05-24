package com.jap.relations.bidiretional.one_to_one;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name="bi_ParkingSpot_one_to_one")
@Table(name="bi_ParkingSpot_one_to_one")
public class ParkingSport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "parkingSport")
    private Employee employee;

}
