package com.nttdata.ereusche.afiliaciones.service;

import com.nttdata.ereusche.afiliaciones.entity.Autorizado;

public interface IAutorizadoService {

    public boolean existeAutorizadoPorNroDocumento(String nroDocumento);

    public Autorizado encontrarAutorizadoPorUbigeo(String ubigeo);

    public Autorizado encontrarAutorizadoPorId(Long id);
}
