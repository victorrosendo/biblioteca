package biblioteca.salas.duoc.service;
import static org.assertj.core.api.Assertions.assertThat; // Utilidades de AssertJ
import static org.mockito.Mockito.when;                  // Programación de mocks

import java.util.Optional; // Para representar valores opcionales
import java.util.Date;     // Clase Date usada por el modelo

import org.junit.jupiter.api.Test;                     // Marca un método como test
import org.junit.jupiter.api.extension.ExtendWith;     // Extiende la funcionalidad de JUnit
import org.mockito.InjectMocks;                        // Inyecta mocks en el objeto bajo prueba
import org.mockito.Mock;                               // Crea un mock
import org.mockito.junit.jupiter.MockitoExtension;     // Soporte de Mockito para JUnit 5

import biblioteca.salas.duoc.model.Reserva;            // Clase de dominio
import biblioteca.salas.duoc.repository.ReservaRepository; // Repositorio simulado

@ExtendWith(MockitoExtension.class) // Activa Mockito en este test
public class ReservaServiceTest {

    @Mock                                     // Repositorio simulado
    private ReservaRepository repository;

    @InjectMocks                               // Servicio que se probará, con el mock inyectado
    private ReservaService service;

    @Test                                      // Método de prueba
    void findById_returnsReservaWhenExists() {
        Reserva reserva = new Reserva(          // Crea un objeto de ejemplo
            1L, new Date(), new Date(), new Date(), 1, null, null);
        when(repository.findById(1L))           // Define la respuesta del mock
            .thenReturn(Optional.of(reserva));

        Reserva result = service.findById(1L);  // Ejecuta el método a probar

        assertThat(result).isNotNull();         // Comprueba que no sea nulo
        assertThat(result.getId()).isEqualTo(1L); // Verifica el ID devuelto
    }
}
