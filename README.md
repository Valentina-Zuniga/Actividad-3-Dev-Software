# Ejemplo Básico de Clean Architecture en Java

Este repositorio contiene un proyecto base que implementa una estructura sencilla basada en los principios de **Clean Architecture**. Su propósito es servir como recurso educativo para estudiantes de desarrollo de software que estén aprendiendo sobre arquitectura de software moderna y buenas prácticas de programación en Java.

##  Objetivos del proyecto

- Explorar la organización de un proyecto en capas: **Dominio**, **Aplicación**, **Infraestructura** y **Presentación**
- Comprender el rol de cada tipo de clase:  
  - Entidades  
  - Casos de uso  
  - Interfaces tipo puerto  
  - Implementaciones tipo adaptador  
  - Controladores
- Investigar conceptos clave:
  - Arquitectura limpia y hexagonal
  - Inversión de dependencias
  - Acoplamiento vs desacoplamiento
  - Patrón Repositorio y patrón CQRS
- Aplicar funcionalidades reales (como operaciones **CRUD**) de forma estructurada
- Practicar la creación de **pruebas unitarias** usando JUnit con la metodología **AAA (Arrange, Act, Assert)**

##  Tecnologías utilizadas

- Java 17
- Maven
- SQLite (vía JDBC)
- JUnit 4
- NetBeans / VS Code / IntelliJ IDEA (compatible)

##  Cómo empezar

1. Clona este repositorio  
   ```bash
   git clone https://github.com/tuusuario/nombre-del-repo.git
   cd nombre-del-repo
