package curso_spring_boot.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludosRestController {
    @GetMapping("/saludos/{nombre}")
    public String saludar(@PathVariable String nombre) {
        return "Hola, " + nombre + "!";
    }
}