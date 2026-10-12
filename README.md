# Arquitectura de Software - Entrega 3

## Implementación de microservicios con comunicación asíncrona mediante RabbitMQ

Este proyecto corresponde a la implementación realizada para la asignatura de Arquitectura de Software.

El objetivo es demostrar la comunicación entre dos servicios independientes utilizando Spring Boot, una API REST y RabbitMQ como sistema de mensajería asíncrona.

---

# Descripción del proyecto

La solución está compuesta por dos servicios:

## Order Service

Servicio encargado de recibir solicitudes para crear órdenes.

Funciones principales:

- Exponer un servicio REST para crear órdenes.
- Generar el evento de creación de orden.
- Enviar el evento hacia RabbitMQ.

---

## Payment Service

Servicio encargado de recibir los eventos enviados desde Order Service.

Funciones principales:

- Escuchar la cola de mensajes.
- Recibir la información de la orden.
- Simular el procesamiento del pago.

---

# Flujo de comunicación

La comunicación implementada funciona de la siguiente manera:

```text
Cliente
   |
   ↓
Order Service
   |
   ↓
RabbitMQ
   |
   ↓
Payment Service