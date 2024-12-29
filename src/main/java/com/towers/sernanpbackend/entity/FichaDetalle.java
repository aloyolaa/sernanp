package com.towers.sernanpbackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "ficha_detalle")
public class FichaDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nido", nullable = false)
    private Integer nido;

    @ManyToOne(optional = false)
    @JoinColumn(name = "lugar_aprovechamiento_id", nullable = false)
    private LugarAprovechamiento lugarAprovechamiento;

    @ManyToOne(optional = false)
    @JoinColumn(name = "playa_id", nullable = false)
    private Playa playa;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tipo_orilla_id", nullable = false)
    private TipoOrilla tipoOrilla;

    @Column(name = "fecha_postura", nullable = false)
    private LocalDate fechaPostura;

    @Column(name = "fecha_recoleccion", nullable = false)
    private LocalDate fechaRecoleccion;

    @Column(name = "huevos_viables")
    private Integer huevosViables;

    @Column(name = "no_viables_recoleccion", nullable = false)
    private Integer noViablesRecoleccion;

    @Column(name = "rotos", nullable = false)
    private Integer rotos;

    @Column(name = "fecha_reanidacion", nullable = false)
    private LocalDate fechaReanidacion;

    @Column(name = "huevos_viables_reanidados", nullable = false)
    private Integer huevosViablesReanidados;

    @Column(name = "no_viables_reanidacion", nullable = false)
    private Integer noViablesReanidacion;

    @Column(name = "rotos_reanidacion")
    private Integer rotosReanidacion;

    @Column(name = "fecha_eclosion", nullable = false)
    private LocalDate fechaEclosion;

    @Column(name = "crias_vivas", nullable = false)
    private Integer criasVivas;

    @Column(name = "crias_muertas", nullable = false)
    private Integer criasMuertas;

    @Column(name = "huevos_no_eclosionados", nullable = false)
    private Integer huevosNoEclosionados;

    @Column(name = "observaciones")
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "ficha_id")
    private Ficha ficha;
}