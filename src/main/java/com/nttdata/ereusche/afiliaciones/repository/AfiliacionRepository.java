package com.nttdata.ereusche.afiliaciones.repository;

import com.nttdata.ereusche.afiliaciones.entity.Afiliacion;
import com.nttdata.ereusche.afiliaciones.entity.Autorizado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AfiliacionRepository extends JpaRepository<Afiliacion, Long> {

    boolean existsByNumeroDocumento(String numeroDocumento);

    Afiliacion findByNumeroDocumento(String numeroDocumento);

    Afiliacion findByAutorizado(Autorizado autorizado);
}