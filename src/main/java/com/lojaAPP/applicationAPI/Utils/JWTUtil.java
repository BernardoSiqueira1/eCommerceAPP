package com.lojaAPP.applicationAPI.Utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class JWTUtil {

    @Value("{spring.api.secret.key}")
    private String chaveSecreta;

    public static final int TEMPO_EXPIRACAO = 86400000;

    public String gerarTokenAutenticacao(String username){
        Algorithm algorithm = Algorithm.HMAC256(chaveSecreta);
        return JWT.create()
                .withIssuer("eCommerce")
                .withSubject(username)
                .withExpiresAt(Instant.now().plusMillis(TEMPO_EXPIRACAO))
                .sign(algorithm);
    }

    public String validarTokenAutenticacao(String token){
        Algorithm algorithm = Algorithm.HMAC256(chaveSecreta);

        return JWT.require(algorithm)
                .withIssuer("eCommerce")
                .build()
                .verify(token)
                .getSubject();
    }

}
