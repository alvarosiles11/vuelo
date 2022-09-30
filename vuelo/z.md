# Arquitectura de Software
Codigo Fuente - Login SOLID
La aplicación debe cumplir con los principios S.O.L.I.D y de ser favorable aplicar los patrones de diseño necesarios

# Diseño Dirigido por el Dominio y Arquitectura Limpia
Presentar un documento que describa las historias de usuario o funcionalidades de la aplicación, la arquitectura de cada microservicio desarrollado junto con el repositorio de código de cada uno
Cada microservicio debe estar desarrollado aplicando Domain Driven Design, Arquitectura Limpia, y CQRS.
Cada microservicio deberá exponer una API

# Testin

# Arquitectura de Software
.



# CONTENERIZACIÓN DE APLICACIONES
Dockerización de Microservicios
Agregar un archivo Dockerfile a su repositorio con las instrucciones para levantar su entorno de trabajo.
Crear una imagen a partir de dicho archivo
Publicar la imagen en el registry oficial.
---
Agregar un archivo docker-compose.yml a su repositorio con las instrucciones para levantar su entorno de trabajo.
Publicar la imagen en el registry oficial.



# INTEGRACIÓN CONTÍNUA

El ciclo de CI/CD minimamente debe de contar con lo siguiente:

## Antes del commit

Hooks para pre-commit que realicen el formateo del código
Hooks para pre-commit que ejecuten los unit tests
## Después del commit un flujo de CI con lo siguiente:
Compilación del código fuente
Ejecución de los unit tests
Análisis de código mediante sonarcloud
Reporte de code coverage para el código en sonarcloud.
## Cuando se decida hacer el release:
Ciclo con 2 jobs, compilación y release
Job de compilación debe ejecutar compilación y tests
Job de release debe ejecutar los comandos necesarios para realizar un release del código dentro de una máquina virtual en internet. Se sugiere digitalocean por la capa gratuita que tiene pero puede ser cualquier otra que permita su ejecución.
El release puede hacerse mediante conexión a SSH o docker. Se deja a su elección.
## Consideraciones del repositorio en general.
Las ramas principales (main y develop) deben estar bloqueadas para commit directo
El action de Build solo debería ejecutarse cuando abran un pull request o cuando se solicite un review.
El action de Release solo debería ejecutarse cuando se está haciendo un push a master.


# COMUNICACION ENTRE MICROSERVICIOS
La tabla actualizada que se solicitó en la Actividad 2.
Nombre del evento
Descripcion del evento
Microservicio Producto
Microservicio Consumidor
-----
API Gateway para exposicion de los endpoints de los distintos microservicios en un solo sitio
Aplicar al menos un agregación de  servicios que sea coherente.
Aplicar la comunicación interna de los microservicios de manera asincrona haciendo uso de un Broker
Un diagrama del despliegue de todo el sistema, mostrando los microservicios que lo componen. 
