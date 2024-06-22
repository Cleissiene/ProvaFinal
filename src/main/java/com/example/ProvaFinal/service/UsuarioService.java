package com.example.ProvaFinal.service;

import com.example.ProvaFinal.security.JwtUtil;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    public String generateToken(String nomeUsuario) {
        String token = JwtUtil.generateToken(nomeUsuario);
        return token;
    }

    public String extractUsername(String token) {
        String username = JwtUtil.extractUsername(token);
        return username;
    }
}