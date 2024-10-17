package com.lojaAPP.applicationAPI.Modules.Security.DTO;

import jakarta.validation.constraints.NotNull;

public record UserDetailsDTO(
        @NotNull
        String email,
        @NotNull
        String password
){}
