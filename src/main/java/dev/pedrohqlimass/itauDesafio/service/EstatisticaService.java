package dev.pedrohqlimass.itauDesafio.service;

import dev.pedrohqlimass.itauDesafio.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class EstatisticaService {

    private final TransacaoRepository transacaoRepository;

    public EstatisticaService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

}
