package dev.pedrohqlimass.itauDesafio.controller;

import dev.pedrohqlimass.itauDesafio.config.EstatisticaProperties;
import dev.pedrohqlimass.itauDesafio.repository.TransacaoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@Slf4j
@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    @Autowired
    private EstatisticaProperties estatisticaProperties;

    @Autowired
    private TransacaoRepository transacaoRepository;

    // criar rota de estatistica e uma lógica para trabalhar com os dados

    @GetMapping
    public ResponseEntity estatistica() {

    //log de requisicao criado via lombok
        log.info("Calculando estatísticas e transções dos últimos " + estatisticaProperties.segundos() + " segundos.");

    //calcular quantas transações acontecem em N segundos
        final var horaInicial = OffsetDateTime
                .now()
                .minusSeconds(estatisticaProperties.segundos());

        return ResponseEntity.ok(transacaoRepository.estatistica(horaInicial));
    }
}
