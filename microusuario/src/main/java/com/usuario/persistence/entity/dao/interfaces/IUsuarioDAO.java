package com.usuario.persistence.entity.dao.interfaces;

import com.usuario.persistence.entity.Usuario;

import java.util.List;

public interface IUsuarioDAO {

    public List<Usuario> getUsusarios();
    public List<Usuario> getIdUsuarios(Long id);
    public List<Usuario> postUsuario(Usuario usuario);
    public List<Usuario> putUsuario(Usuario usuario);
    public List<Usuario> deleteUsuario(Usuario usuario);
}
