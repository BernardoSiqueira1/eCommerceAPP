package com.lojaAPP.applicationAPI.Config;

import com.lojaAPP.applicationAPI.Modules.Usuarios.Repository.UsuarioRepository;
import com.lojaAPP.applicationAPI.Utils.JWTUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class TokenFilter extends OncePerRequestFilter {

    @Autowired
    JWTUtil jwtUtil;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var tokenRequisicao = recuperarToken(request);

        if (tokenRequisicao != null) {
            String usuarioToken = jwtUtil.validarTokenAutenticacao(tokenRequisicao);
            UserDetails usuario = usuarioRepository.findByEmail(usuarioToken);

            var autenticacao = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(autenticacao);
        }

        filterChain.doFilter(request, response);
    }

    private String recuperarToken(HttpServletRequest request){
        var headerAutorizacao = request.getHeader("Authorization");

        if(headerAutorizacao == null) return null;

        return headerAutorizacao;
    }
}
