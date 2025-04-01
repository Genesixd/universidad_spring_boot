package com.universidad.controller; 

import java.util.List; 

// Importaciones de Spring
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Importaciones del proyecto
import com.universidad.dto.EstudianteDTO;
import com.universidad.model.Estudiante;
import com.universidad.service.IEstudianteService;

@RestController 
@RequestMapping("/api")
public class EstudianteController {

    private final IEstudianteService estudianteService; 

    @Autowired 
    public EstudianteController(IEstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    // 1. Obtener todos los estudiantes (GET)
    @GetMapping("/estudiantes")
    public ResponseEntity<List<EstudianteDTO>> obtenerTodosLosEstudiantes() {
        List<EstudianteDTO> estudiantes = estudianteService.obtenerTodosLosEstudiantes();
        return ResponseEntity.ok(estudiantes); // Retorna 200 OK con la lista de estudiantes
    }

    // 2. Obtener un estudiante por ID (GET)
    @GetMapping("/estudiantes/{id}")
    public ResponseEntity<EstudianteDTO> obtenerEstudiantePorId(@PathVariable Long id) {
        EstudianteDTO estudiante = estudianteService.obtenerEstudiantePorId(id);
        return (estudiante != null) ? ResponseEntity.ok(estudiante) : ResponseEntity.notFound().build();
    }

    // 3. Crear un nuevo estudiante (POST)
    @PostMapping("/estudiantes")
    public ResponseEntity<EstudianteDTO> crearEstudiante(@RequestBody EstudianteDTO estudianteDTO) {
        Estudiante estudiante = estudianteService.convertToEntity(estudianteDTO); // Convertir DTO a entidad
        Estudiante estudianteGuardado = estudianteService.crearEstudiante(estudiante); // Guardar en BD
        EstudianteDTO estudianteDTOGuardado = estudianteService.convertToDTO(estudianteGuardado); // Convertir a DTO
        return ResponseEntity.status(201).body(estudianteDTOGuardado); // Retorna 201 Created
    }

    // 4. Actualizar un estudiante por su ID (PUT)
    @PutMapping("/estudiantes/{id}")
    public ResponseEntity<EstudianteDTO> actualizarEstudiante(@PathVariable Long id, @RequestBody EstudianteDTO estudianteDTO) {
        EstudianteDTO estudianteActualizado = estudianteService.actualizarEstudiante(id, estudianteDTO);
        return (estudianteActualizado != null) ? ResponseEntity.ok(estudianteActualizado) : ResponseEntity.notFound().build();
    }

    // 5. Eliminar un estudiante por su ID (DELETE)
    @DeleteMapping("/estudiantes/{id}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable Long id) {
        boolean eliminado = estudianteService.eliminarEstudiante(id);
        return (eliminado) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
