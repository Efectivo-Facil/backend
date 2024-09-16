package com.Backend.Inmobiliaria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "producto_movimientos")
public class ProductoMovimientos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto_movimientos")
    private int idProductoMovimientos;

    @ManyToOne
    @JoinColumn(name = "id_pro")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_mov")
    private Movimientos movimientos;
}