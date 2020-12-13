package com.whatevertech.petfinder.controller;

import com.whatevertech.petfinder.domain.Usuario;
import com.whatevertech.petfinder.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("login")
    public ResponseEntity<String> getTokenUsuario(@RequestBody Usuario usuario) {

        return ResponseEntity.ok(usuarioService.getToken(usuario));
    }

    @PostMapping("register")
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {

        return ResponseEntity.ok(usuarioService.criarUsuario(usuario));
    }
}
