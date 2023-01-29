package com.example.testesautomatizados.service;

import com.example.testesautomatizados.model.Carro;
import com.example.testesautomatizados.repository.CarroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarroService {

    private final CarroRepository carroRepository;

    public void inserir(Carro carro) {
        carroRepository.save(carro);
    }
}
