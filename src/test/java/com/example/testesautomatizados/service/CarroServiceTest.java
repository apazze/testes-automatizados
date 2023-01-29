package com.example.testesautomatizados.service;

import com.example.testesautomatizados.model.Carro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@DataJpaTest
@Import(CarroService.class)
class CarroServiceTest {

    @Autowired
    CarroService carroService;

    @Test
    void deveInserirUmCarro(){
        carroService.inserir(Carro.builder().build());
    }
    //20230129 - Necessário @DataJpaTest para não dar NullPointer e
    //@Import da classe para não dar Unsatisfied dependency
}