package com.nttdata.ereusche.afiliaciones.repository;

import com.nttdata.ereusche.afiliaciones.entity.Autorizado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorizadoRepository extends JpaRepository<Autorizado, Long> {

    boolean existsByNroDocumento(String nroDocumento);

    Autorizado findByUbigeo(String ubigeo);
}