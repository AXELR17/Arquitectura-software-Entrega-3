package com.tienda.order_service.messaging;


import com.tienda.order_service.config.RabbitMQConfig;
import com.tienda.order_service.event.OrdenCreadaEvent;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;



@Component
public class OrdenProducer {


    private final RabbitTemplate rabbitTemplate;



    public OrdenProducer(
            RabbitTemplate rabbitTemplate
    ){

        this.rabbitTemplate = rabbitTemplate;

    }



    public void publicarOrdenCreada(
            OrdenCreadaEvent evento
    ){


        rabbitTemplate.convertAndSend(
                RabbitMQConfig.QUEUE_NAME,
                evento
        );


        System.out.println(
                "Evento enviado: "
                + evento
        );


    }


}