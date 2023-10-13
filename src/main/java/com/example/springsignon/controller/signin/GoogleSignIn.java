package com.example.springsignon.controller.signin;

import com.example.springsignon.common.utils.UserGoogleMapper;
import com.example.springsignon.dto.UserGoogleSignInInfoDTO;
import com.example.springsignon.service.UserGoogleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.example.springsignon.common.constants.UserGoogleConst.*;

@RestController
@RequestMapping("/google")
public class GoogleSignIn {

    @Autowired
    private UserGoogleService googleService;

    @GetMapping("/sign-in")
    public ResponseEntity<String> SignInWithGoogleAccount(OAuth2AuthenticationToken token) {

        Map<String, Object> dataRes = token.getPrincipal().getAttributes();
        String statusMessage = pickUpEssentialsData(dataRes);
        if (statusMessage.equals(ADDING_SUCCESSFULLY)) {

            statusMessage = LOGIN_SUCCESSFULLY;
        } else {

            if (statusMessage.equals(EMAIL_NULL)) {

                statusMessage = EMAIL_NULL + LOGIN_SUCCESSFULLY;
            } else if (statusMessage.equals(EMAIL_EMPTY)) {

                statusMessage = EMAIL_EMPTY + LOGIN_SUCCESSFULLY;
            } else if (statusMessage.equals(EMAIL_EXISTED)) {

                statusMessage = EMAIL_EXISTED + LOGIN_SUCCESSFULLY;
            }
        }

        return ResponseEntity.status(HttpStatus.OK).body(statusMessage);
    }


    private String pickUpEssentialsData(Map<String, Object> data) {

        String message = null;

        UserGoogleSignInInfoDTO dto =  new UserGoogleSignInInfoDTO();

        dto.setName((String) data.get("name"));
        dto.setEmail((String) data.get("email"));
        dto.setPicture((String) data.get("picture"));

        if (!dto.getEmail().equals(NULL)
                && !dto.getEmail().equals(EMPTY)
                    && !googleService.isExistedEmail(dto.getEmail())) {

            googleService.addUser(UserGoogleMapper.dtoToEntity(dto));
            message = ADDING_SUCCESSFULLY;
        } else {

            if (dto.getEmail().equals(NULL)) {

                message = EMAIL_NULL;
            } else if (dto.getEmail().equals(EMPTY)) {

                message = EMAIL_EMPTY;
            } else if (googleService.isExistedEmail(dto.getEmail())) {

                message = EMAIL_EXISTED;
            }
        }

        return message;
    }
}
