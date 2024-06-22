package com.example.ProvaFinal.controller;

import com.example.ProvaFinal.model.UsuarioEntity;
import com.example.ProvaFinal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public String login(@RequestBody UsuarioEntity usuario) {
        String token = usuarioService.generateToken(usuario.getNome());
        return "Token: " + token;
    }


    @GetMapping("/usuario/{token}")
    public String extractUsername(@PathVariable String token) {
        String username = usuarioService.extractUsername(token);
        return username;
    }

    @Secured("GERENTE")
    @GetMapping(value = "/encarregado/{token}")
    public String buscaGerente(@PathVariable String token) {
        String nomeUsuario = usuarioService.extractUsername(token);
        return "Gerente: " + nomeUsuario;
    }

    @Secured("ADMIN")
    @GetMapping(value = "/admin/{token}")
    public String buscaAdmin(@PathVariable String token) {
        String nomeUsuario = usuarioService.extractUsername(token);
        return "Admin: " + nomeUsuario;
    }
}