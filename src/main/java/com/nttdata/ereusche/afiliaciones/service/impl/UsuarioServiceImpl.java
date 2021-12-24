package com.nttdata.ereusche.afiliaciones.service.impl;

import com.nttdata.ereusche.afiliaciones.repository.UsuarioRepository;
import com.nttdata.ereusche.afiliaciones.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    UsuarioRepository usuarioDao;

    @Override
    public boolean existeUsuarioPorDni(String dni) {
        return this.usuarioDao.existsByDni(dni);
    }
}
