package com.tienda.order_service.model;

import lombok.Data;
import java.util.List;

@Data
public class Orden {

    private String id;

    private Long clienteId;

    private List<Long> productos;

    private String estado;


    public Orden(String id, Long clienteId, List<Long> productos) {

        this.id = id;
        this.clienteId = clienteId;
        this.productos = productos;
        this.estado = "PENDIENTE_PAGO";

    }

}