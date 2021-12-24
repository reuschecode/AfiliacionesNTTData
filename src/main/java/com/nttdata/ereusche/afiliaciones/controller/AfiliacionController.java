package com.nttdata.ereusche.afiliaciones.controller;

import com.nttdata.ereusche.afiliaciones.dto.AfiliacionDto;
import com.nttdata.ereusche.afiliaciones.dto.JsonMessageResponse;
import com.nttdata.ereusche.afiliaciones.entity.Afiliacion;
import com.nttdata.ereusche.afiliaciones.entity.Autorizado;
import com.nttdata.ereusche.afiliaciones.service.IAfiliacionService;
import com.nttdata.ereusche.afiliaciones.service.IAutorizadoService;
import com.nttdata.ereusche.afiliaciones.service.IUsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/afiliacion")
@CrossOrigin("**")
public class AfiliacionController {

    @Autowired
    IAfiliacionService afiliacionService;

    @Autowired
    IUsuarioService usuarioService;

    @Autowired
    IAutorizadoService autorizadoService;

    ModelMapper modelMapper = new ModelMapper();

    @PostMapping
    public ResponseEntity<?> nuevo(@Valid @RequestBody AfiliacionDto afiliacionDto, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity<>(new JsonMessageResponse("Faltan datos del afiliador.", "ERROR"), HttpStatus.BAD_REQUEST);
        if(this.afiliacionService.existeAfiliacionPorDni(afiliacionDto.getNumeroDocumento()))
            return new ResponseEntity<>(new JsonMessageResponse("Ya existe un afiliador con ese número de documento.", "ERROR"), HttpStatus.BAD_REQUEST);
        if(this.autorizadoService.existeAutorizadoPorNroDocumento(afiliacionDto.getNumeroDocumento()))
            return new ResponseEntity<>(new JsonMessageResponse("Ya existe un autorizado con ese número de documento.", "ERROR"), HttpStatus.BAD_REQUEST);
        if(this.usuarioService.existeUsuarioPorDni(afiliacionDto.getNumeroDocumento()))
            return new ResponseEntity<>(new JsonMessageResponse("Ya existe un usuario con ese número de documento.", "ERROR"), HttpStatus.BAD_REQUEST);

        Autorizado autorizado = this.autorizadoService.encontrarAutorizadoPorUbigeo(afiliacionDto.getUbigeo());
        if(autorizado == null)
            return new ResponseEntity<>(new JsonMessageResponse("No existe un autorizado con ese número de ubigeo.", "ERROR"), HttpStatus.BAD_REQUEST);

        Afiliacion nuevaAfiliacion = modelMapper.map(afiliacionDto, Afiliacion.class);
        nuevaAfiliacion.setAutorizado(autorizado);

        this.afiliacionService.guardarAfiliacion(nuevaAfiliacion);

        return new ResponseEntity<>(new JsonMessageResponse("El afiliado con el DNI: '"+afiliacionDto.getNumeroDocumento()+"' se creó correctamente.", "SUCCESS"), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> listarAfiliaciones(){
        return new ResponseEntity<>(this.afiliacionService.listarAfiliaciones(), HttpStatus.OK);
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<?> encontrarAfiliacionPorDni(@PathVariable("dni") String dni){
        Afiliacion afiliacion = this.afiliacionService.obtenerAfiliacionPorDni(dni);
        if(afiliacion == null)
            return new ResponseEntity<>(new JsonMessageResponse("No se encontró la afiliación con ese DNI.", "ERROR"), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(afiliacion, HttpStatus.OK);
    }

    @GetMapping("/autorizado/{idAutorizado}")
    public ResponseEntity<?> encontarPorAutorizado(@PathVariable("idAutorizado") Long idAutorizado){
        Autorizado autorizado = this.autorizadoService.encontrarAutorizadoPorId(idAutorizado);
        if(autorizado == null)
            return new ResponseEntity<>(new JsonMessageResponse("No se encontró un autorizado con ese ID.", "ERROR"), HttpStatus.NOT_FOUND);
        Afiliacion afiliacion = this.afiliacionService.obtenerAfiliacionPorAutorizado(autorizado);
        if(afiliacion == null)
            return new ResponseEntity<>(new JsonMessageResponse("No se encontró afiliaciones con este autorizado.", "ERROR"), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(afiliacion, HttpStatus.OK);
    }
}
