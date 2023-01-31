package com.example.testesautomatizados.controller;

import com.example.testesautomatizados.model.Carro;
import com.example.testesautomatizados.service.CarroService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CarroController.class)
class CarroControllerTest {

    @MockBean
    CarroService carroService;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveCadastrarUmCarro() throws Exception {

        Carro carro = Carro.builder().id(1L).marca("Volks").build();

        mvc.perform(post("/cadastrar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(carro)))
                .andExpect(status().isOk());

        verify(carroService).inserir(Carro.builder().build());
    }

    @Test
    void notNull(){
        assertNotNull(carroService);
    }
    //20230130 - Necessario @Getter na model para fazer o mapper p/ Json e EqualsAndHashCode para o verify
    //WebMvcTest para injetar a dependência no MockMvc
}