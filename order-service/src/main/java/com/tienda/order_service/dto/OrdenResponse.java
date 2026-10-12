package com.tienda.order_service.dto;

import lombok.Data;


@Data
public class OrdenResponse {


    private String ordenId;

    private String estado;

    private String mensaje;



    public OrdenResponse(
            String ordenId,
            String estado,
            String mensaje
    ){

        this.ordenId = ordenId;
        this.estado = estado;
        this.mensaje = mensaje;

    }

}