package com.universidad.repository; 

import java.time.LocalDate; 
import java.util.ArrayList; 
import java.util.List;
import java.util.Map; 
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap; 
import java.util.concurrent.atomic.AtomicLong; 
import org.springframework.stereotype.Repository; 
import com.universidad.model.Estudiante; 

@Repository 
public class EstudianteRepository {
    
    private final Map<Long, Estudiante> estudiantes = new ConcurrentHashMap<>();
    private final AtomicLong idContador = new AtomicLong(1);
    
    
    //Guarda un estudiante en el repositorio. Si el estudiante no tiene ID, se le asigna uno.
    public Estudiante save(Estudiante estudiante) {
        if (estudiante.getId() == null) { 
            estudiante.setId(idContador.getAndIncrement());
        }
        estudiantes.put(estudiante.getId(), estudiante); 
        return estudiante; 
    }
    
    
    //Obtiene la lista de todos los estudiantes almacenados.  
    public List<Estudiante> findAll() {
        return new ArrayList<>(estudiantes.values()); // Retorna una lista con todos los estudiantes
    }
    
    
    //Busca un estudiante por su ID.  
    public Optional<Estudiante> findById(Long id) {
        return Optional.ofNullable(estudiantes.get(id));
    }
    
    //Elimina un estudiante por su ID.
    public void deleteById(Long id) {
        estudiantes.remove(id); 
    }
    
    
    //Método para inicializar algunos datos de ejemplo en el repositorio.
    public void init() {
        Estudiante estudiante1 = Estudiante.builder()
                .nombre("Juan")
                .apellido("Pérez")
                .email("juan.perez@example.com")
                .fechaNacimiento(LocalDate.of(2000, 5, 15))
                .numeroInscripcion("S001")
                .build();
                
        Estudiante estudiante2 = Estudiante.builder()
                .nombre("María")
                .apellido("González")
                .email("maria.gonzalez@example.com")
                .fechaNacimiento(LocalDate.of(2001, 8, 22))
                .numeroInscripcion("S002")
                .build();
                
        save(estudiante1); 
        save(estudiante2); 
    }
}
