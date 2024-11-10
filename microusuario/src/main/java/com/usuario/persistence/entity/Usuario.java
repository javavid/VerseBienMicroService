package com.usuario.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;
    @Column(name = "correo", length = 200, nullable = false)
    private String correo;
    @Column(name = "celular", nullable = false)
    private String celular;
    @Column(name = "direccion", length = 55, nullable = false)
    private String direccion;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    @Column(name = "rol", length = 15, nullable = false)
    private String rol;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_registro")
    private Date fechaRegistro;
    private boolean activo;
    public enum Tipo
    {
        cliente, empleado, administrador

    }
}
