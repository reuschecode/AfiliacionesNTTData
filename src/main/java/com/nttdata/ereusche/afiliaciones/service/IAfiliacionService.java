package com.nttdata.ereusche.afiliaciones.service;

import com.nttdata.ereusche.afiliaciones.entity.Afiliacion;
import com.nttdata.ereusche.afiliaciones.entity.Autorizado;

import java.util.List;

public interface IAfiliacionService {

    public void guardarAfiliacion(Afiliacion afiliacion);

    public List<Afiliacion> listarAfiliaciones();

    public Afiliacion obtenerAfiliacionPorDni(String dni);

    public Afiliacion obtenerAfiliacionPorAutorizado(Autorizado autorizado);

    public boolean existeAfiliacionPorDni(String dni);
}
