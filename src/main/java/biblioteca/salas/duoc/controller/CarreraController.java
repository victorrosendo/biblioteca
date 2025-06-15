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

import biblioteca.salas.duoc.model.Carrera;
import biblioteca.salas.duoc.service.CarreraService;

@RestController
@RequestMapping("api/carreras")
public class CarreraController {
    @Autowired
    private CarreraService carreraService;

    @GetMapping
    public List<Carrera> getAllCarreras(){
        return carreraService.findAll();
    }

    @GetMapping("/{id}")
    public Carrera getCarreraById(@PathVariable String id){
        return carreraService.findByCodigo(id);
    }

    @PostMapping
    public Carrera createCarrera(@RequestBody Carrera carrera){
        return carreraService.save(carrera);
    }

    @DeleteMapping("/{id}")
    public void deleteCarrera(@PathVariable String id){
        carreraService.deleteByCodigo(id);
    }

}
