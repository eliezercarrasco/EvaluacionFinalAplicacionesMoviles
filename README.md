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

# Pasteleria - Frontend (Android Kotlin)

**Integrantes:** Eliezer Carrasco Lobos, María José Velázquez

## Resumen
Proyecto móvil Android desarrollado con Jetpack Compose y arquitectura MVVM. 
Este README fue generado automáticamente tras el análisis del código fuente.

## Paquetes detectados
com.example.pasteleriayy, com.example.pasteleriayy.data, com.example.pasteleriayy.model, com.example.pasteleriayy.navigation, com.example.pasteleriayy.ui.components, com.example.pasteleriayy.ui.screens, com.example.pasteleriayy.ui.theme, com.example.pasteleriayy.viewmodel

## Screens / Composables detectados
AppNavigation, ContactoScreen, FormularioValidacion, InicioScreen, LoginScreen, MainActivity, MainAppStructure, MenuProductosScreen, PantallaCrud, PantallaEditarUsuario, PasteleriaYYTheme, ProductoItem, PromocionItem, PromocionesScreen, RecetasScreen, TopAppBarMenu, UsuarioCard

## ViewModels detectados
MenuProductosViewModel, PromocionesViewModel, RecetaViewModel, RegistroViewModel

## Repositories detectados
RecetaRepository, UsuarioRepository

## Entidades y DAOs (Room)
- Room detectado: False
- Entidades: No detectadas
- DAOs: No detectados

## Retrofit / API externa
- Retrofit detectado: True
- Recursos nativos detectados: Camera

## Tests
- Archivos de pruebas detectados: 3

## APK / JKS
- APKs detectados: /mnt/data/kotlin/PasteleriaKotlin/PasteleriaKotlin/app/build/intermediates/apk/androidTest/debug/app-debug-androidTest.apk, /mnt/data/kotlin/PasteleriaKotlin/PasteleriaKotlin/app/build/intermediates/apk/debug/app-debug.apk
- JKS detectados: /mnt/data/kotlin/PasteleriaKotlin/keystore/app-release.jks

## Estructura recomendada (según la rúbrica)
- MVVM: View / ViewModel / Repository / Model
- Persistencia local: Room o DataStore
- Validaciones: lógico (ViewModel) separadas de la UI
- Pruebas unitarias: en ViewModel/Repository con JUnit/MockK
- Firma: .jks y build.gradle configurado

## Cómo ejecutar (resumen rápido)
1. Abrir el proyecto `PasteleriaKotlin` en Android Studio.
2. Sincronizar Gradle.
3. Ejecutar en emulador o dispositivo.
4. Asegurarse de tener variables/archivos necesarios (.jks) en la ruta indicada.

## Notas
Este README será personalizado con más detalle (pantallas, ejemplo de ejecución, comandos) si lo deseas.


## Módulo Room (implementación agregada por solicitud)
He agregado un módulo Room listo para integrar al proyecto. Archivos creados (paquete `com.example.pasteleriayy.data.db` y `com.example.pasteleriayy.repository`):

- `BakeryItem.kt` (Entidad)
- `BakeryItemDao.kt` (DAO)
- `AppDatabase.kt` (RoomDatabase)
- `BakeryRepository.kt` (Repositorio)
- `BakeryViewModel.kt` (ViewModel ejemplo)

### Dependencias necesarias (agregar en build.gradle)
```gradle
implementation "androidx.room:room-runtime:2.5.2"
kapt "androidx.room:room-compiler:2.5.2"
implementation "androidx.room:room-ktx:2.5.2"
```
Si usas Kotlin Kapt, activa `kapt` en el build.gradle (plugin).

### Inicialización del AppDatabase (ejemplo en Application)
```kotlin
val db = Room.databaseBuilder(
    applicationContext,
    com.example.pasteleriayy.data.db.AppDatabase::class.java,
    "pasteleria-db"
).build()
val repo = com.example.pasteleriayy.repository.BakeryRepository(db.bakeryItemDao())
```

