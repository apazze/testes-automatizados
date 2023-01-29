package com.example.testesautomatizados.repository;

import com.example.testesautomatizados.model.Carro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@DataJpaTest
class CarroRepositoryTest {

    @Autowired
    CarroRepository carroRepository;

    @Test
    void deveSalvarCarro(){
        Carro carro = carroRepository.save(Carro.builder().build());

        assertThat(carroRepository.findAll().get(0), is(carro));
    }
    // 20230129 - Necessário incluir o runtimeOnly 'com.h2database:h2' no build.gradle, mas
    // não é preciso configurar um banco.
}