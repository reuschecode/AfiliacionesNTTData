package com.nttdata.ereusche.afiliaciones.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Data
public class AfiliacionDto implements Serializable {

    @NotEmpty
    private final String numeroDocumento;

    @NotEmpty
    private final String nombres;

    @NotEmpty
    private final String apePaterno;

    @NotEmpty
    private final String apeMaterno;

    @NotEmpty
    private final String direccion;

    @NotEmpty
    private final String ubigeo;
}
