package biblioteca.salas.duoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import biblioteca.salas.duoc.model.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>{

}
