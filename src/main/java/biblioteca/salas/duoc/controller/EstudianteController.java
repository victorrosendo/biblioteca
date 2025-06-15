package biblioteca.salas.duoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import biblioteca.salas.duoc.model.Estudiante;
import biblioteca.salas.duoc.service.EstudianteService;

@RestController
@RequestMapping("api/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public List<Estudiante> getAllEstudiantes(){
        return estudianteService.findAll();
    }

    @GetMapping("/{id}")
    public Estudiante getEstudianteById(@PathVariable Long id){
        return estudianteService.findById(id);
    }

    @PostMapping
    public Estudiante createEstudiante(@RequestBody Estudiante estudiante){
        return estudianteService.save(estudiante);
    }

    @DeleteMapping("/{id}")
    public void deleteEstudiante(@PathVariable Long id){
        estudianteService.deleteById(id);
    }
}
