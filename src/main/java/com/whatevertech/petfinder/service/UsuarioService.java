package com.whatevertech.petfinder.service;

import com.whatevertech.petfinder.domain.Usuario;
import com.whatevertech.petfinder.repository.UsuarioRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario criarUsuario(Usuario usuario) {

        usuario.setPassword(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(usuario.getPassword()));

        return usuarioRepository.save(usuario);
    }

    public String getToken(Usuario usuario) {
        String auth = usuario.getUsername() + ":" + usuario.getPassword();
        byte[] encodedAuth = Base64.encodeBase64(
                auth.getBytes(StandardCharsets.US_ASCII) );
        return "Basic " + new String( encodedAuth );
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return Optional.of(usuarioRepository.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));
    }
}
