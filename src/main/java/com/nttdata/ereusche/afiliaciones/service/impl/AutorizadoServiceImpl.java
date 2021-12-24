package com.nttdata.ereusche.afiliaciones.service.impl;

import com.nttdata.ereusche.afiliaciones.entity.Autorizado;
import com.nttdata.ereusche.afiliaciones.repository.AutorizadoRepository;
import com.nttdata.ereusche.afiliaciones.service.IAutorizadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AutorizadoServiceImpl implements IAutorizadoService {

    @Autowired
    AutorizadoRepository autorizadoDao;

    @Override
    public boolean existeAutorizadoPorNroDocumento(String nroDocumento) {
        return this.autorizadoDao.existsByNroDocumento(nroDocumento);
    }

    @Override
    public Autorizado encontrarAutorizadoPorUbigeo(String ubigeo) {
        return this.autorizadoDao.findByUbigeo(ubigeo);
    }

    @Override
    public Autorizado encontrarAutorizadoPorId(Long id) {
        return this.autorizadoDao.findById(id).orElse(null);
    }
}
