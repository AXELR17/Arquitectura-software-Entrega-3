package com.tienda.order_service.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrdenRequest {

    private Long clienteId;

    private List<Long> productos;

}
