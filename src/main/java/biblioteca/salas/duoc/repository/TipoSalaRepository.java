package biblioteca.salas.duoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import biblioteca.salas.duoc.model.TipoSala;

@Repository
public interface TipoSalaRepository extends JpaRepository<TipoSala,Long> {

}
