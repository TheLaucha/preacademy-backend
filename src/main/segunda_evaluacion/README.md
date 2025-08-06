# API de Turnos Médicos

Esta es una API REST simple para gestionar turnos médicos entre pacientes y profesionales de la salud.

## Descripción

La API permite:

- Crear y gestionar pacientes
- Crear y gestionar profesionales médicos
- Crear, listar y eliminar turnos médicos
- Buscar turnos por fecha

## Tecnologías

- Java 21
- Spring Boot 3.5.4
- Spring Data JPA
- H2 Database (en memoria)
- Lombok
- Maven

## Cómo ejecutar

1. Clona el repositorio
2. Asegúrate de tener Java 21 instalado
3. Ejecuta: `mvn spring-boot:run`
4. La API estará disponible en: `http://localhost:8080`

## Endpoints principales

### Turnos

- `GET /turnos` - Listar todos los turnos
- `POST /turnos` - Crear un nuevo turno
- `GET /turnos/fecha/{fecha}` - Buscar turnos por fecha
- `DELETE /turnos/{id}` - Eliminar un turno

### Pacientes

- `GET /pacientes` - Listar todos los pacientes
- `POST /pacientes` - Crear un nuevo paciente
- `GET /pacientes/{id}` - Obtener un paciente por ID
- `DELETE /pacientes/{id}` - Eliminar un paciente

### Profesionales

- `GET /profesionales` - Listar todos los profesionales
- `POST /profesionales` - Crear un nuevo profesional
- `GET /profesionales/{id}` - Obtener un profesional por ID
- `DELETE /profesionales/{id}` - Eliminar un profesional

## Ejemplo de uso

Para crear un turno:

```json
POST /turnos
{
  "patientId": 1,
  "professionalId": 2,
  "date": "2025-01-15"
}
```

## Testing con Postman

Puedes importar el archivo `Turnos API.postman_collection.json` en Postman para probar todos los endpoints de la API de manera fácil.

## Base de datos

La aplicación usa H2 en memoria, por lo que los datos se pierden al reiniciar.

## Estructura del proyecto

```
src/main/java/com/segunda_evaluacion/segunda_evaluacion/
├── controller/     # Controladores REST
├── service/        # Lógica de negocio
├── repository/     # Acceso a datos
├── model/          # Entidades JPA
├── dto/           # Objetos de transferencia
└── exception/     # Manejo de excepciones
```

## Autor

Desrrollado por Lautaro Espinillo para la evaluacion N°2 de Moby Digital PreAcademy
