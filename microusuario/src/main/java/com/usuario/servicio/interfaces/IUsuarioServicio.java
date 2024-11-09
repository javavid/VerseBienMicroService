package com.usuario.servicio.interfaces;

import com.usuario.presentacion.dto.UsuarioDTO;

import java.util.List;

public interface IUsuarioServicio {

    public List<UsuarioDTO> getUsusarios();
    public List<UsuarioDTO> getIdUsuarios(Long id);
    public List<UsuarioDTO> postUsuario(UsuarioDTO usuario);
    public List<UsuarioDTO> putUsuario(Long id, UsuarioDTO usuarioUpDate);
    public List<UsuarioDTO> deleteUsuario(Long id);
}
