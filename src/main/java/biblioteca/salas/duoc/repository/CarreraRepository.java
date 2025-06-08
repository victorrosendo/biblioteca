package biblioteca.salas.duoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import biblioteca.salas.duoc.model.Carrera;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, String>{

}
