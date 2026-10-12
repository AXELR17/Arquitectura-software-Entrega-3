package com.tienda.order_service.event;


import lombok.Data;

import java.util.List;


@Data
public class OrdenCreadaEvent {


    private String ordenId;

    private Long clienteId;

    private List<Long> productos;

    private String estado;


    public OrdenCreadaEvent(
            String ordenId,
            Long clienteId,
            List<Long> productos,
            String estado
    ){

        this.ordenId = ordenId;
        this.clienteId = clienteId;
        this.productos = productos;
        this.estado = estado;

    }

}
