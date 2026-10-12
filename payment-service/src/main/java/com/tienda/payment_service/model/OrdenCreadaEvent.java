package com.tienda.payment_service.model;

import lombok.Data;
import java.util.List;


@Data
public class OrdenCreadaEvent {


    private String ordenId;

    private Long clienteId;

    private List<Long> productos;

    private String estado;


}
