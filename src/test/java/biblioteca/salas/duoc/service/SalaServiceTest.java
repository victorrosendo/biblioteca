package biblioteca.salas.duoc.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import biblioteca.salas.duoc.model.Sala;
import biblioteca.salas.duoc.model.TipoSala;
import biblioteca.salas.duoc.repository.SalaRepository;

@ExtendWith(MockitoExtension.class)
public class SalaServiceTest {
    @Mock
    private SalaRepository repository;

    @InjectMocks
    private SalaService service;

    @Test
    void save_returnsSavedSala(){
        //creamos un objeto de prueba para el insert
        Sala nuevaSala = new Sala(10L,"Sala 1",7,1,new TipoSala(1L,"Estudio"));

        //configuramos la respuesta del repositorio
        when(repository.save(nuevaSala)).thenReturn(nuevaSala);

        //ejecutamos el metodo del servicio a comprobar
        Sala result = service.save(nuevaSala);

        //comprobamos que el servicio devuelva lo mismo que el repositorio
        assertThat(result).isSameAs(nuevaSala); //el mismo objeto
    }

}
