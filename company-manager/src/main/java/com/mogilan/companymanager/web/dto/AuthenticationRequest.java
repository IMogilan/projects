package com.mogilan.companymanager.web.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;

@Data
@NoArgsConstructor
public class AuthenticationRequest {

    private String email;
    private String password;
}
