package com.example.springsignon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserGoogleSignInInfoDTO implements Serializable {

    private Long id;
    private String name;
    private String email;
    private String picture;
}
