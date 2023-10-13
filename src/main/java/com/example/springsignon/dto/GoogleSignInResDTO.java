package com.example.springsignon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoogleSignInResDTO implements Serializable {

    public String atHash;
    public String sub;
    public boolean emailVerified;
    public String iss;
    public String givenName;
    public String locale;
    public String nonce;
    public String picture;
    public List<String> aud;
    public String azp;

    public String name;
    public Date exp;
    public String familyName;
    public Date iat;
    public String email;
}
