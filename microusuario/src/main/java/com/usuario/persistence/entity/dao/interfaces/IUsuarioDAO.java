package com.usuario.persistence.entity.dao.interfaces;

import com.usuario.persistence.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioDAO {

    public List<Usuario> getUsusarios();
    public Optional<Usuario> getIdUsuarios(Long id);
    public void postUsuario(Usuario usuario);
    public void putUsuario(Usuario usuario);
    public void deleteUsuario(Usuario usuario);
}
