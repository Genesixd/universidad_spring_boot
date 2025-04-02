"# Universidad Spring Boot" 
# Universidad Spring Boot

## 📌 Descripción
Este proyecto es una API REST desarrollada con **Spring Boot**, que gestiona información sobre estudiantes de una universidad.


## 📂 Estructura del Proyecto
```
universidad_spring_boot/
│── src/main/java/com/universidad/
│   ├── controller/                  # Controladores REST
│   ├── dto/                         # Objetos de transferencia de datos (DTOs)
│   ├── model/                        # Entidades JPA 
│   ├── repository/                   # Repositorios para acceso a datos
│   ├── service/                      # Lógica de negocio y servicios
│   ├── MiProyectoSpringBootApplication.java  # Clase principal de Spring Boot
│── src/main/resources/
│   ├── application.properties        # Configuración de la aplicación
│── pom.xml                           # Archivo de configuración de Maven
│── README.md                         # Documentación del proyecto
│── .gitignore                        # Archivos ignorados por Git

```
## 🔧 Configuración del Proyecto
### 1️⃣ Clonar el Repositorio
```bash
git clone https://github.com/Genesixd/universidad_spring_boot.git
cd universidad_spring_boot
```
### 2️⃣ Ejecutar la Aplicación
Usa Maven para correr el proyecto:
```bash
mvn spring-boot:run
```

## 📡 Endpoints Disponibles
Una vez en ejecución, los siguientes endpoints estarán disponibles:

| Método | Endpoint                 | Descripción |
|--------|--------------------------|-------------|
| GET    | `/api/estudiantes`       | Listar estudiantes |
| POST   | `/api/estudiantes`       | Crear estudiante  |
| GET    | `/api/estudiantes/{id}`  | Obtener estudiante por ID |
| PUT    | `/api/estudiantes/{id}`  | Actualizar estudiante |
| DELETE | `/api/estudiantes/{id}`  | Eliminar estudiante |

📌 Puedes probar los endpoints con **Postman** o **cURL**:
```bash
curl -X GET http://localhost:8080/api/estudiantes -H "Accept: application/json"
```

📌 **Nota**: El puerto predeterminado es `8082`. Si el puerto está en uso, puedes cambiarlo en el archivo `application.properties`:

```properties
server.port=8082

---
✍️ **Autor:** Genesixd

