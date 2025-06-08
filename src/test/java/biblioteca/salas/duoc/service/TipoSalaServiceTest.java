package biblioteca.salas.duoc.service;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat; // Métodos de AssertJ para validaciones
import org.junit.jupiter.api.Test;                     // Anotación para definir métodos de prueba
import org.junit.jupiter.api.extension.ExtendWith;     // Permite extender el comportamiento de JUnit
import org.mockito.InjectMocks;                        // Crea la instancia a probar e inyecta sus mocks
import org.mockito.Mock;                               // Marca campos que serán simulados
import org.mockito.junit.jupiter.MockitoExtension;     // Extensión para usar Mockito con JUnit 5

import biblioteca.salas.duoc.model.TipoSala;
import biblioteca.salas.duoc.repository.TipoSalaRepository;


/*
 * se anotan las dependencias que se van a simular con @Mock, 
 * se inyecta el objeto a probar con @InjectMocks 
 * y se inicializa el contexto con @ExtendWith(MockitoExtension.class) 
 * o MockitoAnnotations.openMocks(this).
 */

//se inicializa el contexto
@ExtendWith(MockitoExtension.class)// Habilita la inicialización automática de los mocks
public class TipoSalaServiceTest {
    @Mock // Declaración del mock del repositorio
    private TipoSalaRepository repository;

    @InjectMocks                             // Objeto bajo prueba con los mocks inyectados
    private TipoSalaService service;

    @Test                                    // Método que ejecuta la prueba
    void findAll_returnsListFromRepository() {
        List<TipoSala> mockList =             // Lista que simula la respuesta del repositorio
            Arrays.asList(new TipoSala(1L, "Auditorio"));
        when(repository.findAll())            // Define el comportamiento del mock
            .thenReturn(mockList);

        List<TipoSala> result = service.findAll(); // Llama al método a probar

        assertThat(result).isEqualTo(mockList);    // Verifica que se devuelva la lista esperada
    }


}
