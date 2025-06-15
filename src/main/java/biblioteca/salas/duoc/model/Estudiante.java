package biblioteca.salas.duoc.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estudiante")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante {
    @Id
    private Long id;
    @Column(nullable = false)
    private String run;
    @Column(nullable = false)
    private String nombres;
    @Column(nullable = false)
    private String correo;
    @Column(nullable = false)
    private char jornada;
    @Column(nullable = false)
    private String telefono;
    
    @ManyToOne
    @JoinColumn(name = "codigo", nullable = false)
    private Carrera carrera;

}
