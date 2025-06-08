package biblioteca.salas.duoc.service;
import static org.assertj.core.api.Assertions.assertThat; // Utilidades de aserción
import static org.mockito.Mockito.when;                  // Define el comportamiento del mock

import org.junit.jupiter.api.Test;                      // Indica un método de prueba
import org.junit.jupiter.api.extension.ExtendWith;      // Permite usar Mockito
import org.mockito.InjectMocks;                         // Inyecta los mocks
import org.mockito.Mock;                                // Declara un mock
import org.mockito.junit.jupiter.MockitoExtension;      // Extensión de Mockito para JUnit 5

import biblioteca.salas.duoc.model.Sala;                // Modelo utilizado en la prueba
import biblioteca.salas.duoc.model.TipoSala;            // Modelo relacionado
import biblioteca.salas.duoc.repository.SalaRepository; // Repositorio simulado

@ExtendWith(MockitoExtension.class) // Activa la extensión de Mockito
public class SalaServiceTest {
    @Mock                                     // Repositorio simulado
    private SalaRepository repository;

    @InjectMocks                               // Servicio a probar, con el mock inyectado
    private SalaService service;

    @Test                                      // Marca el método como test
    void save_returnsSavedSala() {
        Sala nuevaSala = new Sala(             // Crea un objeto de ejemplo
            10L, "Sala A", 50, 1,
            new TipoSala(1L, "Estudio"));
        when(repository.save(nuevaSala))       // Configura la respuesta del repositorio
            .thenReturn(nuevaSala);

        Sala result = service.save(nuevaSala); // Ejecuta el método de negocio

        assertThat(result).isSameAs(nuevaSala); // Comprueba que se devuelva el mismo objeto
    }

}
