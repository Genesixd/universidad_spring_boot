package com.universidad.service.impl; 

import java.util.ArrayList; 
import java.util.List; 
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import com.universidad.dto.EstudianteDTO; 
import com.universidad.model.Estudiante; 
import com.universidad.repository.EstudianteRepository; 
import com.universidad.service.IEstudianteService;
import jakarta.annotation.PostConstruct; 

@Service 
public class EstudianteServiceImpl implements IEstudianteService {
    
    private final EstudianteRepository estudianteRepository; 
    
    @Autowired 
    public EstudianteServiceImpl(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }
    
    @PostConstruct 
    public void init() {
        estudianteRepository.init(); // Inicializa datos de prueba
    }
    
    @Override
    public List<EstudianteDTO> obtenerTodosLosEstudiantes() {
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        List<EstudianteDTO> estudiantesDTO = new ArrayList<>();
        
        for (Estudiante estudiante : estudiantes) {
            estudiantesDTO.add(convertToDTO(estudiante)); 
        }
        return estudiantesDTO;
    }
    
    @Override
    public EstudianteDTO obtenerEstudiantePorId(Long id) {
        Estudiante estudiante = estudianteRepository.findById(id).orElse(null);
        return (estudiante != null) ? convertToDTO(estudiante) : null;
    }
    
    @Override
    public EstudianteDTO actualizarEstudiante(Long id, EstudianteDTO estudianteDTO) {
        Estudiante estudianteExistente = estudianteRepository.findById(id).orElse(null);
        
        if (estudianteExistente != null) {
            // Actualizar datos del estudiante
            estudianteExistente.setNombre(estudianteDTO.getNombre());
            estudianteExistente.setApellido(estudianteDTO.getApellido());
            estudianteExistente.setEmail(estudianteDTO.getEmail());
            estudianteExistente.setFechaNacimiento(estudianteDTO.getFechaNacimiento());
            estudianteExistente.setNumeroInscripcion(estudianteDTO.getNumeroInscripcion());
            
            estudianteRepository.save(estudianteExistente);
            return convertToDTO(estudianteExistente);
        }
        return null;
    }
    
    @Override
    public Estudiante crearEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }
    
    @Override
    public boolean eliminarEstudiante(Long id) {
        Optional<Estudiante> estudianteOptional = estudianteRepository.findById(id);
        if (estudianteOptional.isPresent()) {
            estudianteRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    // Método auxiliar para convertir una entidad a DTO
    public EstudianteDTO convertToDTO(Estudiante estudiante) {
        return EstudianteDTO.builder()
                .id(estudiante.getId())
                .nombre(estudiante.getNombre())
                .apellido(estudiante.getApellido())
                .email(estudiante.getEmail())
                .fechaNacimiento(estudiante.getFechaNacimiento())
                .numeroInscripcion(estudiante.getNumeroInscripcion())
                .build();
    }
    
    // Método auxiliar para convertir un DTO a entidad
    public Estudiante convertToEntity(EstudianteDTO estudianteDTO) {
        return Estudiante.builder()
                .id(estudianteDTO.getId())
                .nombre(estudianteDTO.getNombre())
                .apellido(estudianteDTO.getApellido())
                .email(estudianteDTO.getEmail())
                .fechaNacimiento(estudianteDTO.getFechaNacimiento())
                .numeroInscripcion(estudianteDTO.getNumeroInscripcion())
                .build();
    }
}