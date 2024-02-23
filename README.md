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
    git clone https://github.com/MartinAndresMDQ/Superheroes-API.git
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
    java -jar .\target\superheroes-api-3.2.2.war
    ```
    
### Acceso a Swagger UI

Una vez que la aplicación esté en funcionamiento, abre un navegador web y accede a la siguiente URL:

[Swagger UI](http://localhost:8080/mindata/swagger-ui.html)

Esto abrirá la interfaz de usuario de Swagger, donde podrás explorar y probar los diferentes endpoints de la API.

### Ejemplos de Uso

#### Endpoints Disponibles

- **GET /api/superheroes/todos:** Obtiene una lista de todos los superhéroes.
- **GET /api/superheroes/buscar/{nombre}:** Obtiene una lista de todos los superhéroes con el nombre buscado.
- **POST /api/superheroes/crear:** Crea un nuevo superhéroe.
- **GET /api/superheroes/traer/{id}:** Obtiene los detalles de un superhéroe específico según su ID.
- **PUT /api/superheroes/actualizar/{id}:** Actualiza la información de un superhéroe existente.
- **DELETE /api/superheroes/borrar/{id}:** Elimina un superhéroe según su ID.

Puedes utilizar herramientas como cURL, Postman o Swagger UI para interactuar con estos endpoints y probar la funcionalidad de la API.

#### Seguridad

La API utiliza Spring Security para proporcionar una capa de seguridad. Actualmente se encuentra deshabilitado, aun que se ha configurado una autenticación básica para los usuarios "user" y "admin", con la contraseña "password". Puedes acceder a los endpoints protegidos utilizando estas credenciales.
