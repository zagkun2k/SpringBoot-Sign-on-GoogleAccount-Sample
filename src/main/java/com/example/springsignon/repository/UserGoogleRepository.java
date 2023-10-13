package com.example.springsignon.repository;

import com.example.springsignon.entity.UserGoogleSignInInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGoogleRepository extends JpaRepository<UserGoogleSignInInfoEntity, Long> {

}
