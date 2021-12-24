package com.nttdata.ereusche.afiliaciones.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JsonMessageResponse {
    private String message;
    private String status;

}
