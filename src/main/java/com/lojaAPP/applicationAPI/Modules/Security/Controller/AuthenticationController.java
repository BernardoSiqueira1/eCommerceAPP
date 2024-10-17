package com.lojaAPP.applicationAPI.Modules.Security.Controller;

import com.lojaAPP.applicationAPI.Modules.Security.DTO.UserDetailsDTO;
import com.lojaAPP.applicationAPI.Modules.Security.Service.AuthService;
import com.lojaAPP.applicationAPI.Utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/web")
public class AuthenticationController {
    @Autowired
    AuthService authService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTUtil jwtUtil;

    @PostMapping(value = "/auth")
    public ResponseEntity<?> authenticateUser(@RequestBody UserDetailsDTO userDetailsDTO) {
        var userCredentials = new UsernamePasswordAuthenticationToken(userDetailsDTO.email(),userDetailsDTO.password());
        var authentication = authenticationManager.authenticate(userCredentials);

        String token = jwtUtil.gerarTokenAutenticacao(authentication.getName());

        return ResponseEntity.status(200).body(token);
    }
}
