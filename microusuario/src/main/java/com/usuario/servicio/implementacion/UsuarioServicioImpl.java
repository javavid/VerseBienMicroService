package com.usuario.servicio.implementacion;

import com.usuario.presentacion.dto.UsuarioDTO;
import com.usuario.servicio.interfaces.IUsuarioServicio;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioServicioImpl implements IUsuarioServicio {


    @Override
    public List<UsuarioDTO> getUsusarios() {
        return null;
    }

    @Override
    public List<UsuarioDTO> getIdUsuarios(Long id) {
        return null;
    }

    @Override
    public List<UsuarioDTO> postUsuario(UsuarioDTO usuario) {
        return null;
    }

    @Override
    public List<UsuarioDTO> putUsuario(Long id, UsuarioDTO usuarioUpDate) {
        return null;
    }

    @Override
    public List<UsuarioDTO> deleteUsuario(Long id) {
        return null;
    }
}
