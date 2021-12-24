package com.nttdata.ereusche.afiliaciones.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "autorizado")
@Data
public class Autorizado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, columnDefinition = "CHAR(8)", name = "nroDocumento")
    private String nroDocumento;

    @Column(nullable = false, length = 50)
    private String nombres;

    @Column(nullable = false, length = 20, name = "apePaterno")
    private String apePaterno;

    @Column(nullable = false, length = 20, name = "apeMaterno")
    private String apeMaterno;

    @Column(nullable = false, length = 100)
    private String direccion;

    @Column(nullable = false, length = 50)
    private String ubigeo;
}