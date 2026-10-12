package com.tienda.order_service.service;


import com.tienda.order_service.dto.OrdenRequest;
import com.tienda.order_service.event.OrdenCreadaEvent;
import com.tienda.order_service.messaging.OrdenProducer;
import com.tienda.order_service.model.Orden;

import org.springframework.stereotype.Service;

import java.util.UUID;



@Service
public class OrdenService {


    private final OrdenProducer ordenProducer;



    public OrdenService(OrdenProducer ordenProducer){

        this.ordenProducer = ordenProducer;

    }



    public Orden crearOrden(OrdenRequest request) {


        // Generar identificador único para la orden
        String idOrden = UUID.randomUUID()
                .toString()
                .substring(0,8);



        // Crear la orden inicial
        Orden orden = new Orden(
                idOrden,
                request.getClienteId(),
                request.getProductos()
        );



        // Crear evento que será enviado por RabbitMQ
        OrdenCreadaEvent evento =
                new OrdenCreadaEvent(
                        orden.getId(),
                        orden.getClienteId(),
                        orden.getProductos(),
                        orden.getEstado()
                );



        // Publicar evento asíncrono
        ordenProducer.publicarOrdenCreada(evento);



        return orden;

    }

}