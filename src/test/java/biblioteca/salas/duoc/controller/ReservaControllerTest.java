package biblioteca.salas.duoc.controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get; // Construye peticiones GET
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status; // Verifica el estado HTTP
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath; // Evalúa contenido JSON
import static org.mockito.Mockito.when;           // Programa el comportamiento del mock

import java.util.Date;                             // Utiliza la clase Date del modelo
import java.util.Collections;                     // Para crear listas inmutables

import org.junit.jupiter.api.Test;                 // Marca métodos de prueba
import org.springframework.beans.factory.annotation.Autowired; // Inyección de dependencias en tests
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest; // Configura Spring MVC en pruebas
import org.springframework.boot.test.mock.mockito.MockBean;  // Crea un bean simulado en el contexto
import org.springframework.test.web.servlet.MockMvc;         // Permite enviar peticiones HTTP simuladas

import biblioteca.salas.duoc.model.Reserva;        // Clase que se devolverá en la respuesta
import biblioteca.salas.duoc.service.ReservaService; // Servicio que se va a simular

@WebMvcTest(ReservaController.class) // Carga únicamente el controlador a probar
public class ReservaControllerTest {
    @Autowired                                  // Se inyecta el MockMvc proporcionado por Spring
    private MockMvc mockMvc;

    @MockBean                                   // Se inyecta un mock de ReservaService en el contexto
    private ReservaService reservaService;

    @Test                                       // Método de prueba
    void getAllReservas_returnsOkAndJson() throws Exception {
        Reserva reserva = new Reserva(           // Reserva de ejemplo para la respuesta
            1L, new Date(), new Date(), new Date(), 1, null, null);
        when(reservaService.findAll())           // Configura el servicio simulado
            .thenReturn(Collections.singletonList(reserva));

        mockMvc.perform(get("/api/reservas"))    // Ejecuta una petición GET al endpoint
               .andExpect(status().isOk())       // Verifica que la respuesta sea 200 OK
               .andExpect(jsonPath("$[0].id")    // Valida que el JSON contenga el ID
                          .value(1L));
    }

}
