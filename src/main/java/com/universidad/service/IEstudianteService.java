package com.universidad.service;

import java.util.List;
import com.universidad.dto.EstudianteDTO;
import com.universidad.model.Estudiante;

public interface IEstudianteService { // Define la interfaz IEstudianteService
    
    // Método para obtener una lista de todos los estudiantes como DTO
    List<EstudianteDTO> obtenerTodosLosEstudiantes(); 
    
    // Método para obtener un estudiante por su ID
    EstudianteDTO obtenerEstudiantePorId(Long id); 

    // Método para actualizar un estudiante por su ID
    EstudianteDTO actualizarEstudiante(Long id, EstudianteDTO estudianteDTO);
    
    // Método para crear un estudiante
    Estudiante crearEstudiante(Estudiante estudiante); 
    
    // Método para convertir un DTO en una entidad Estudiante
    Estudiante convertToEntity(EstudianteDTO estudianteDTO);
    
    // Método para convertir una entidad Estudiante a DTO
    EstudianteDTO convertToDTO(Estudiante estudiante); 
    
    // Método para eliminar un estudiante por su ID
    boolean eliminarEstudiante(Long id); 
}
