# Pasteleria - Backend (Spring Boot)

**Integrantes:** Eliezer Carrasco Lobos, María José Velázquez

## Resumen
Backend desarrollado con Spring Boot. Este README fue generado automáticamente tras el análisis del código fuente.

## Paquetes detectados
com.pasteleria.mil_sabores, com.pasteleria.mil_sabores.controller, com.pasteleria.mil_sabores.dto, com.pasteleria.mil_sabores.model, com.pasteleria.mil_sabores.repository, com.pasteleria.mil_sabores.service

## Entidades detectadas
Contacto, Producto, Promocion, Rol, Usuario

## Repositories detectados
ContactoRepository, ProductoRepository, PromocionRepository, RolRepository, UsuarioRepository

## Services detectados
ContactoService, ProductoService, PromocionService, RolService, UsuarioService

## Controllers y endpoints detectados
- **ContactoController**: rutas/paths detectados: api/contactos, {id}, {id}, {id}
- **ProductoController**: rutas/paths detectados: api/productos, {id}, {id}, {id}
- **PromocionController**: rutas/paths detectados: api/promociones, {id}, {id}, {id}
- **RegistroController**: rutas/paths detectados: api/registro, {id}, {id}, {id}, login
- **RolController**: rutas/paths detectados: api/roles, {id}


## Mappings globales detectados
api/contactos, api/productos, api/promociones, api/registro, api/roles, login, {id}

## Build tool
gradle (build.gradle)

## application.properties/yml
Presente: True

## Tests
- Archivos de pruebas detectados: 1

## Requisitos y comprobaciones (según la rúbrica)
- Endpoints CRUD (GET, POST, PUT, DELETE) deben estar implementados.
- Base de datos configurada y migraciones/creación de tablas.
- Repositorios que extienden JpaRepository u otro.
- Documentar endpoints en el README con ejemplos de uso (curl/Postman).
- Ejecutar con `mvn spring-boot:run` o `./gradlew bootRun` según corresponda.

## Cómo ejecutar (resumen rápido)
1. Abrir el proyecto `PasteleriaSpring` en tu IDE (IntelliJ/VSCode).
2. Asegurarse de tener Java instalado (JDK 11+).
3. Ejecutar el servicio con Maven o Gradle según el build tool detectado.
4. Revisar `application.properties` o `application.yml` para la configuración de BD.

## Notas
Puedo expandir este README incluyendo: ejemplos CURL para cada endpoint, estructura de base de datos (tablas/columnas) y comandos para inicializar la BD si lo solicitas.


## Nota importante
El frontend ahora incluye persistencia local Room (paquete `com.example.pasteleriayy.data.db`). Ajustar endpoints y sincronización para la persistencia externa si corresponde.
