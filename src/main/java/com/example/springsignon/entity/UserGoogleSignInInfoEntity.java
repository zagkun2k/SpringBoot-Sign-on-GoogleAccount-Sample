package com.example.springsignon.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@Table(name = "GoogleUserInfo")
@AllArgsConstructor
@NoArgsConstructor
public class UserGoogleSignInInfoEntity implements Serializable {

    @Id
    @SequenceGenerator(
            name = "user_google_sequence",
            sequenceName = "user_google_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_google_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private String picture;
}
