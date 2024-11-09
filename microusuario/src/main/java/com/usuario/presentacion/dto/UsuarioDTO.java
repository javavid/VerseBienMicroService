package com.usuario.presentacion.dto;

import com.usuario.persistence.entity.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {


    private long idUsuario;

    private String nombre;

    private String correo;

    private String celular;

    private String direccion;

    private Usuario.Tipo tipo;

    private String rol;

    private Date fechaRegistro;
    private boolean activo;
    public enum Tipo
    {
        cliente, empleado, administrador

    }
}
