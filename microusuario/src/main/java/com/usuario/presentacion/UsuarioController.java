package com.usuario.presentacion;

import com.usuario.presentacion.dto.UsuarioDTO;
import com.usuario.servicio.implementacion.UsuarioServicioImpl;
import com.usuario.servicio.interfaces.IUsuarioServicio;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioServicio iUsuarioServicio;


    @CrossOrigin
    @GetMapping
    public ResponseEntity<?> getUsuario()
    {
        List<UsuarioDTO> user = iUsuarioServicio.getUsusarios();

        return ResponseEntity.ok(user);
    }


    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<?> getIdUsuario(@PathVariable Long id)
    {
        List<UsuarioDTO> user = iUsuarioServicio.getIdUsuarios(id);

        return ResponseEntity.ok(user);
    }


    @CrossOrigin
    @PostMapping
    public ResponseEntity<UsuarioDTO> postUsuario(@RequestBody UsuarioDTO usuario)
    {
        iUsuarioServicio.postUsuario(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> putUpDate(@PathVariable Long id, @RequestBody UsuarioDTO usuarioUpDate)
    {
        try {
            List<UsuarioDTO> usuarioActualizado = iUsuarioServicio.putUsuario(id, usuarioUpDate);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable Long id)
    {
        try {
            iUsuarioServicio.deleteUsuario(id);

            return ResponseEntity.status(HttpStatus.OK).body("Eliminado Correctamente");
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no Encontrado");
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
