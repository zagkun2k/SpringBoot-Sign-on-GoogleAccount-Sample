package com.example.springsignon.common.utils;

import com.example.springsignon.dto.UserGoogleSignInInfoDTO;
import com.example.springsignon.entity.UserGoogleSignInInfoEntity;
import org.modelmapper.ModelMapper;

public class UserGoogleMapper {

    private static final ModelMapper mapper = new ModelMapper();

    public static UserGoogleSignInInfoEntity dtoToEntity (UserGoogleSignInInfoDTO dto) {

        return mapper.map(dto, UserGoogleSignInInfoEntity.class);
    }

    public static UserGoogleSignInInfoDTO entityToDTO (UserGoogleSignInInfoEntity entity) {

        return mapper.map(entity, UserGoogleSignInInfoDTO.class);
    }
}
