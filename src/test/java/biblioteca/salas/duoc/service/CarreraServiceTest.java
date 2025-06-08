package biblioteca.salas.duoc.service;

import static org.mockito.Mockito.verify;       // Método para verificar invocaciones

import org.junit.jupiter.api.Test;              // Anotación de JUnit 5
import org.junit.jupiter.api.extension.ExtendWith; // Permite usar Mockito
import org.mockito.InjectMocks;                 // Inyecta los mocks en la clase bajo prueba
import org.mockito.Mock;                        // Crea un objeto simulado
import org.mockito.junit.jupiter.MockitoExtension; // Extensión de Mockito para JUnit 5

import biblioteca.salas.duoc.repository.CarreraRepository; // Repositorio a simular

@ExtendWith(MockitoExtension.class) // Habilita el soporte de Mockito
public class CarreraServiceTest {

     @Mock                                    // Declaración del mock
    private CarreraRepository repository;

    @InjectMocks                              // Servicio que se va a probar
    private CarreraService service;

    @Test                                     // Indica que este método es una prueba
    void deleteByCodigo_invokesRepositoryDelete() {
        service.deleteByCodigo("INF");        // Llama al método del servicio

        verify(repository).deleteById("INF"); // Verifica que el repositorio recibió la llamada
    }
}
