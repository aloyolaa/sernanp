package com.towers.sernanpbackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ficha")
public class Ficha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "codigo", nullable = false)
    private String codigo;

    @Column(name = "numero_ficha", nullable = false)
    private String numeroFicha;

    @Column(name = "anio", nullable = false)
    private Integer anio;

    @ManyToOne(optional = false)
    @JoinColumn(name = "especie_id", nullable = false)
    private Especie especie;

    @ManyToOne(optional = false)
    @JoinColumn(name = "asociacion_id", nullable = false)
    private Asociacion asociacion;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cuenca_id", nullable = false)
    private Cuenca cuenca;

    @ManyToOne(optional = false)
    @JoinColumn(name = "digitador_id", nullable = false)
    private Digitador digitador;

    @ManyToOne(optional = false)
    @JoinColumn(name = "comunidad_id", nullable = false)
    private Comunidad comunidad;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sector_aprovechamiento_id", nullable = false)
    private SectorAprovechamiento sectorAprovechamiento;

    @OneToMany(mappedBy = "ficha", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FichaDetalle> fichaDetalles = new ArrayList<>();
}