package com.usuario.persistence.entity.dao.implementacion;

import com.usuario.persistence.entity.Usuario;
import com.usuario.persistence.entity.dao.interfaces.IUsuarioDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Repository
public class UsuarioDaoImpl implements IUsuarioDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getUsusarios() {
        return this.em.createQuery("SELECT u FROM Usuario u").getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> getIdUsuarios(Long id) {
        return Optional.ofNullable(this.em.find(Usuario.class, id));
    }

    @Override
    @Transactional
    public void postUsuario(Usuario usuario) {
        this.em.persist(usuario);
        this.em.flush();
    }

    @Override
    @Transactional
    public void putUsuario(Usuario usuario) {
        this.em.merge(usuario);
    }

    @Override
    @Transactional
    public void deleteUsuario(Usuario usuario) {
        this.em.remove(usuario);
    }
}