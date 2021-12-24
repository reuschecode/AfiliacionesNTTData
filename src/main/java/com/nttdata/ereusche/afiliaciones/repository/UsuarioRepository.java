package com.nttdata.ereusche.afiliaciones.repository;

import com.nttdata.ereusche.afiliaciones.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByDni(String dni);
}