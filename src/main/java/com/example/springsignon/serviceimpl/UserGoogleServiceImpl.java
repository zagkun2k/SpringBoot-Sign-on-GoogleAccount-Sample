package com.example.springsignon.serviceimpl;

import com.example.springsignon.entity.UserGoogleSignInInfoEntity;
import com.example.springsignon.repository.UserGoogleRepository;
import com.example.springsignon.service.UserGoogleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserGoogleServiceImpl implements UserGoogleService {

    @Autowired
    private UserGoogleRepository repository;
    @Override
    public void addUser(UserGoogleSignInInfoEntity entity) {

        repository.save(entity);
    }

    @Override
    public boolean isExistedEmail(String email) {

        if (repository.findByEmail(email).equals(null)) {

            return false;
        }

        return true;
    }
}
