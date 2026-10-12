package com.tienda.payment_service.listener;


import com.tienda.payment_service.config.RabbitMQConfig;
import com.tienda.payment_service.model.OrdenCreadaEvent;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;



@Component
public class PagoConsumer {


    @RabbitListener(
            queues = RabbitMQConfig.QUEUE_NAME
    )
    public void recibirOrden(
            OrdenCreadaEvent evento
    ){


        System.out.println("==============================");
        System.out.println("Evento recibido en Payment Service");


        System.out.println(
                "Orden ID: "
                + evento.getOrdenId()
        );


        System.out.println(
                "Cliente ID: "
                + evento.getClienteId()
        );


        System.out.println(
                "Productos: "
                + evento.getProductos()
        );


        System.out.println(
                "Estado: "
                + evento.getEstado()
        );


        System.out.println("Procesando pago...");


        System.out.println(
                "Pago aprobado correctamente"
        );


        System.out.println("==============================");


    }

}