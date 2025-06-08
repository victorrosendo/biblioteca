package biblioteca.salas.duoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import biblioteca.salas.duoc.model.Carrera;
import biblioteca.salas.duoc.service.CarreraService;

@RestController
@RequestMapping("/api/carreras")
public class CarreraController {
    @Autowired
    private CarreraService carreraService;

    @GetMapping
    public List<Carrera> getAllCarreras() {
        return carreraService.findAll();
    }

    @GetMapping("/{codigo}")
    public Carrera getCarreraByCodigo(@PathVariable String codigo) {
        return carreraService.findByCodigo(codigo);
    }

    @PostMapping
    public Carrera createCarrera(@RequestBody Carrera carrera) {
        return carreraService.save(carrera);
    }

    @PutMapping("/{codigo}")
    public Carrera updateCarrera(@PathVariable String codigo, @RequestBody Carrera carrera) {
        carrera.setCodigo(codigo);
        return carreraService.save(carrera);
    }

    @DeleteMapping("/{codigo}")
    public void deleteCarrera(@PathVariable String codigo) {
        carreraService.deleteByCodigo(codigo);
    }

}
