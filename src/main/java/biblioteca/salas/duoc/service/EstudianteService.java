package biblioteca.salas.duoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblioteca.salas.duoc.model.Estudiante;
import biblioteca.salas.duoc.repository.EstudianteRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class EstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepository;

    public List<Estudiante> findAll(){
        return estudianteRepository.findAll();
    }

    public Estudiante findById(Long id){
        return estudianteRepository.findById(id).orElse(null);
    }

    public Estudiante save(Estudiante estudiante){
        return estudianteRepository.save(estudiante);
    }

    public void deleteById(Long id){
        estudianteRepository.deleteById(id);
    }

}
