package com.nttdata.ereusche.afiliaciones.service.impl;

import com.nttdata.ereusche.afiliaciones.entity.Afiliacion;
import com.nttdata.ereusche.afiliaciones.entity.Autorizado;
import com.nttdata.ereusche.afiliaciones.repository.AfiliacionRepository;
import com.nttdata.ereusche.afiliaciones.repository.AutorizadoRepository;
import com.nttdata.ereusche.afiliaciones.service.IAfiliacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AfiliacionServiceImpl implements IAfiliacionService {

    @Autowired
    AfiliacionRepository afiliacionDao;

    @Override
    public void guardarAfiliacion(Afiliacion afiliacion) {
        this.afiliacionDao.save(afiliacion);
    }

    @Override
    public List<Afiliacion> listarAfiliaciones() {
        return this.afiliacionDao.findAll();
    }

    @Override
    public Afiliacion obtenerAfiliacionPorDni(String dni) {
        return this.afiliacionDao.findByNumeroDocumento(dni);
    }

    @Override
    public Afiliacion obtenerAfiliacionPorAutorizado(Autorizado autorizado) {
        return this.afiliacionDao.findByAutorizado(autorizado);
    }

    @Override
    public boolean existeAfiliacionPorDni(String dni) {
        return this.afiliacionDao.existsByNumeroDocumento(dni);
    }
}
