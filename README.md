# Superheroes API

Esta es una API RESTful que gestiona información sobre superhéroes. Permite realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre los datos de los superhéroes.

## Tecnologías Utilizadas

- Java 17
- Spring Boot 3.2
- Maven
- H2 Database
- Swagger
- Spring Security

## Configuración

### Requisitos Previos

- Java JDK 17 instalado
- Maven instalado

### Pasos para Ejecutar

1. Clona el repositorio desde GitHub:

	```bash
    git clone https://github.com/tu-usuario/superheroes-api.git
    ```
2. Navega al directorio del proyecto:

    ```bash
    cd superheroes-api
    ```

3. Construye el proyecto con Maven:

    ```bash
    mvn clean package
    ```
4. Ejecuta la aplicación:

    ```bash
    java -jar target/superheroes-api.war
    ```
    
### Acceso a Swagger UI

Una vez que la aplicación esté en funcionamiento, abre un navegador web y accede a la siguiente URL:

[Swagger UI](http://localhost:8080/mindata/swagger-ui.html)

Esto abrirá la interfaz de usuario de Swagger, donde podrás explorar y probar los diferentes endpoints de la API.
