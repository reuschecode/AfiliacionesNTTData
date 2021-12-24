package com.nttdata.ereusche.afiliaciones.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuario")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombres;

    @Column(nullable = false, columnDefinition = "CHAR(8)")
    private String dni;

    @Column(nullable = false, length = 20, name = "apePaterno")
    private String apePaterno;

    @Column(nullable = false, length = 20, name = "apeMaterno")
    private String apeMaterno;

    @CreationTimestamp
    @Column(name = "fechaCreacion")
    private LocalDateTime fechaCreacion;
}