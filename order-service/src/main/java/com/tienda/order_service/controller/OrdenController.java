package com.tienda.order_service.controller;

import com.tienda.order_service.dto.OrdenRequest;
import com.tienda.order_service.dto.OrdenResponse;
import com.tienda.order_service.model.Orden;
import com.tienda.order_service.service.OrdenService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1/ordenes")
public class OrdenController {


    private final OrdenService ordenService;


    public OrdenController(OrdenService ordenService){

        this.ordenService = ordenService;

    }



    @PostMapping
    public ResponseEntity<OrdenResponse> crearOrden(
            @RequestBody OrdenRequest request){


        Orden orden = ordenService.crearOrden(request);


        OrdenResponse response =
                new OrdenResponse(
                        orden.getId(),
                        orden.getEstado(),
                        "Orden recibida y enviada a procesamiento"
                );


        return ResponseEntity
                .accepted()
                .body(response);

    }

}