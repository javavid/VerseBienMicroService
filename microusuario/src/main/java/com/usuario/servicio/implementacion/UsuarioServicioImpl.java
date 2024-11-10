package com.usuario.servicio.implementacion;

import com.usuario.persistence.entity.Usuario;
import com.usuario.persistence.entity.dao.interfaces.IUsuarioDAO;
import com.usuario.presentacion.dto.UsuarioDTO;
import com.usuario.servicio.interfaces.IUsuarioServicio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServicioImpl implements IUsuarioServicio {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private IUsuarioDAO iUsuarioDAO;
    @Override
    public List<UsuarioDTO> getUsusarios() {
        ModelMapper modelMapper = new ModelMapper();
        return this.iUsuarioDAO.getUsusarios()
                .stream()
                .map(entity -> modelMapper.map(entity, UsuarioDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UsuarioDTO> getIdUsuarios(Long id) {
        Optional<Usuario> userEntity = this.iUsuarioDAO.getIdUsuarios(id);
        if (userEntity.isPresent())
        {
            ModelMapper modelMapper = new ModelMapper();
            Usuario users = userEntity.get();
            return Collections.singletonList(modelMapper.map(users, UsuarioDTO.class));
        }else
        {
            return Collections.emptyList();
        }

    }

    @Override
    @Transactional
    public List<UsuarioDTO> postUsuario(UsuarioDTO usuario) {
        try {

            ModelMapper modelMapper = new ModelMapper();
            Usuario userEntity = modelMapper.map(usuario, Usuario.class);


            entityManager.merge(userEntity);


            return Collections.singletonList(modelMapper.map(userEntity, UsuarioDTO.class));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al registrar el usuario: " + e.getMessage(), e);
        }
    }





    @Override
    public List<UsuarioDTO> putUsuario(Long id, UsuarioDTO usuarioUpDate) {
        Optional<Usuario> userEntity = this.iUsuarioDAO.getIdUsuarios(id);
        if (userEntity.isPresent())
        {
            Usuario users = userEntity.get();
            users.setNombre(usuarioUpDate.getNombre());
            users.setCorreo(usuarioUpDate.getCorreo());
            users.setCelular(usuarioUpDate.getCelular());
            users.setDireccion(usuarioUpDate.getDireccion());
            users.setTipo(usuarioUpDate.getTipo());
            users.setRol(usuarioUpDate.getRol());
            users.setActivo(usuarioUpDate.isActivo());
            this.iUsuarioDAO.putUsuario(users);
            ModelMapper modelMapper = new ModelMapper();
            return Collections.singletonList(modelMapper.map(users, UsuarioDTO.class));
        }else
        {
            throw new IllegalArgumentException("Error el usuario no existe");
        }

    }

    @Override
    public List<UsuarioDTO> deleteUsuario(Long id) {

        Optional<Usuario> userEntity = this.iUsuarioDAO.getIdUsuarios(id);
        if (userEntity.isPresent())
        {
            Usuario users = userEntity.get();
            this.iUsuarioDAO.deleteUsuario(users);
            return Collections.emptyList();
        }else
        {
            throw new IllegalArgumentException("Error el usuario no existe");
        }

    }
}
