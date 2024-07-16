# Challenge.ForoHUB
Bienvenido a mi repositorio del challenge ForoHUB, en el cual se desarrolló una API Rest en Java, utlilzando Spring Boot como framework, así como otras dependencias.
El challenge desarrollado consiste en la implementación de los métodos para agregar, consultar, modificar y eliminar datos sobre tópicos de un foro, todo ello con base en los principios y buenas prácticas propias de Java. Además, se implementó la funcionalidad para controlar los accesos por medio de Spring Security y la generación de Tokens.

Para este proyecto, se usaron las siguientes dependencias:

- Spring Boot 3.3.1
- Spring Boot DevTools
- Spring Security
- Spring Data JPA
- Spring Web
- Flyway
- MySQL para bases de datos (es posible usar otro motor de su preferencia)
- Auth.io 4.2.1
- Lombok

## Uso de la API
  
- Control de acceso mediante Spring Security: La API utiliza Spring Security para autenticar y autorizar a los usuarios. Los usuarios deben autenticarse proporcionando credenciales válidas antes de acceder a las funcionalidades
Para probar los otros métodos, es necesario conseguir el token que devolverá la API luego de ingresar las credenciales correspondientes (se debe crear un usuario manualmente)

- Crear un nuevo tópico: Los usuarios pueden enviar una solicitud POST al endpoint /topicos con los datos del nuevo tópico a crear, previamente se valida que no hayan sido ingresados previamente.

- Consultar tópicos: Los tópicos existentes pueden ser consultados mediante una solicitud GET al endpoint /topicos. Se pueden aplicar filtros o paginación.

- Modificar un tópico: Para actualizar un tópico existente, se utiliza una solicitud PUT al endpoint /topicos/{id} proporcionando los datos actualizados del tópico.
 
- Deshabilitar un tópico: Los tópicos pueden ser deshabilitados enviando una solicitud DELETE al endpoint /topicos/{id}. Esto marca el tópico como inactivo y ya no se mostrará en el listado de tópicos

Se recomienda utilizar Insomnia o Postman para probar los request a la API, los cuales tienen como URL base la clásica que incluye al localhost y su puerto, seguido de sus respectivos endpoints. Por último, es necesario crear una base de datos y añadir su nombre en el archivo application.properties, o bien application.yml, así como ajustar las variables presentadas a su propia configuración.
