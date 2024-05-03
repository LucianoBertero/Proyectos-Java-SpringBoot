package com.stc.ec.model.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Cliente implements Serializable {
    private Integer idClient;
    private String nombre;
    private String apellido;
    private String correo;
    private Date fechaRegistro;
}
