# Proyecto: OrderApp

## Descripción

OrderApp es una API desarrollada con Spring Boot para gestionar pedidos de manera eficiente. Proporciona endpoints para la creación, actualización, eliminación y consulta de pedidos.

## Tecnologías utilizadas

Java 17: Lenguaje de programación principal.

Spring Boot: Framework para desarrollo de aplicaciones backend.

Spring Data JPA: Manejo de persistencia con bases de datos relacionales.

H2 Database / MySQL: Base de datos en memoria para pruebas o MySQL para producción.

Spring Web: Para la creación de endpoints REST.

## Características principales

✅ Gestión completa de pedidos (CRUD).
✅ Endpoints RESTful.
✅ Uso de Spring Data JPA para persistencia.
✅ Base de datos configurable (H2 para pruebas, MySQL para producción).


## Instalación y uso
1. Clonar el repositorio:
git clone https://github.com/carlosfranco97/OrderApp.git

2. Acceder al directorio del proyecto:
cd OrderApp

3. Configurar la base de datos en application.properties o application.yml

4. Ejecutar la aplicación con Maven:
mvn spring-boot:run
