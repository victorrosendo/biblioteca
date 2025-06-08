package biblioteca.salas.duoc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "carrera")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carrera {
    @Id
    private String codigo;
    @Column(nullable = false)
    private String nombre;
}
