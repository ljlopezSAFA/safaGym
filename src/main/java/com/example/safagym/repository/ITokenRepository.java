package com.example.safagym.repository;

import com.example.safagym.model.Token;
import com.example.safagym.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITokenRepository extends JpaRepository<Token, Integer> {

    Token findTopByUsuario(Usuario usuario);

}
