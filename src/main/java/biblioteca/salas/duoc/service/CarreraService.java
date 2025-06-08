package biblioteca.salas.duoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblioteca.salas.duoc.model.Carrera;
import biblioteca.salas.duoc.repository.CarreraRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CarreraService {
    @Autowired
    private CarreraRepository carreraRepository;
    public List<Carrera> findAll() {
        return carreraRepository.findAll();
    }

    public Carrera findByCodigo(String codigo) {
        return carreraRepository.findById(codigo).orElse(null);
    }

    public Carrera save(Carrera carrera) {
        return carreraRepository.save(carrera);
    }

    public void deleteByCodigo(String codigo) {
        carreraRepository.deleteById(codigo);
    }
}
