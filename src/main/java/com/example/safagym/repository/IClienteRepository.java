package com.example.safagym.repository;

import com.example.safagym.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query(value = "select c.* from {h-schema}cliente c where c.nombre like %:nombre% " , nativeQuery = true)
    List<Cliente> buscarPorNombre(String nombre);

    @Query(value = "select c.* from {h-schema}cliente c where c.dni like %:letraDNI",nativeQuery = true)
    List<Cliente> buscarPorLetraDNI(String letraDNI);

    @Query(value = "select c.* from {h-schema}cliente c where c.nombre like %:nombre% and c.dni like %:letraDNI ",nativeQuery = true)
    List<Cliente> buscarPorLetraDNIYNombre(String letraDNI, String nombre);


}

