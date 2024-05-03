package pe.todotic.agenda.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "contacto")
@Getter
@Setter
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idcontacto")
    private Integer idContacto;

    private String nombre;

    @Column(name="fechanac")
    private LocalDate fechaNacimiento;

    private String email;

    private String celular;
}
