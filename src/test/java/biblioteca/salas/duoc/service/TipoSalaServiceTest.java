package biblioteca.salas.duoc.service;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import biblioteca.salas.duoc.model.TipoSala;
import biblioteca.salas.duoc.repository.TipoSalaRepository;

@ExtendWith(MockitoExtension.class) //habilitar la inicialización automatica de los mocks
public class TipoSalaServiceTest {
    @Mock // declaro el mock para que se cree el repositorio fictisio
    private TipoSalaRepository repository;

    @InjectMocks // objeto de prueba los mocks inyectados
    private TipoSalaService service;

    @Test //identificamos que la funcion es un test o prueba unitaria
    void findAll_returnsListFromRepository(){
        //crear un elemento que simule la respuesta del repositorio
        //lista simulada de la respuesta del repositorio
        List<TipoSala> mockList = Arrays.asList(new TipoSala(1L,"Auditorio"));

        //definir el comportamiento del mock
        when(repository.findAll()).thenReturn(mockList);

        //llamar al método que se pretende probar
        List<TipoSala> result = service.findAll();

        //verificar que coincida (validar sus criterios de aceptación)
        assertThat(result).isEqualTo(mockList);


    }

}
