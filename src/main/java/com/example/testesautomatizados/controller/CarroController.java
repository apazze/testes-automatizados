package com.example.testesautomatizados.controller;

import com.example.testesautomatizados.model.Carro;
import com.example.testesautomatizados.service.CarroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CarroController {

    private final CarroService carroService;

    @PostMapping("/cadastrar")
    public void cadastrar(){
        carroService.inserir(Carro.builder().build());
    }
}
