package biblioteca.salas.duoc.controller;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import biblioteca.salas.duoc.model.Reserva;
import biblioteca.salas.duoc.service.ReservaService;

//cargamos el controlador que vamos a probar
@WebMvcTest(ReservaController.class)
public class ReservaControllerTest {

    //inyectamos un mock de ReservaService para manipular nuestro contexto
    @MockBean
    private ReservaService reservaService;

    //se inyecta un mock proporcionado por spring para simular la llamada a la api
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllReservas_returnsOKAndJson(){
        //creamos una reserva de ejemplo
        List<Reserva> reserva = Arrays.asList(new Reserva(1L,new Date(),new Date(),new Date(),1,null,null));

        //configuro el comportamiento del servicio simulado
        when(reservaService.findAll()).thenReturn(reserva);

        //ejecutar el endpoint del controlador a probar
        //mandar a ejecutar le metodo get con la url
        //verificar que retorna el codigo 200
        try {
            mockMvc.perform(get("api/reservas")).andExpect(status().isOk()).andExpect(jsonPath("$[0].id").value(1L));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
