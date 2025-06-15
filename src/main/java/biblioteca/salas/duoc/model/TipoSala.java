package biblioteca.salas.duoc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "tipo_sala")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoSala {
    @Id
    private Long idTipo;
    @Column(nullable = false)
    private String nombre;

}
