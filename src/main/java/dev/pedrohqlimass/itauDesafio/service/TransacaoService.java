package dev.pedrohqlimass.itauDesafio.service;

import com.sun.nio.sctp.IllegalReceiveException;
import dev.pedrohqlimass.itauDesafio.dto.TransacaoRequest;
import dev.pedrohqlimass.itauDesafio.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;

    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public void validarTransacao(TransacaoRequest transacaoRequest) {

        // verifica se o obj é nulo
        if (transacaoRequest == null) {
            throw new IllegalReceiveException("Transação inválida: corpo da requisição não pode ser nulo.");
        }

        // verifica se o valor é nulo
        if (transacaoRequest.getValor() == null) {
            throw new IllegalArgumentException("Transação inválida: o valor não pode ser nulo");
        }

        // verifica se a dataHora é nula
        if (transacaoRequest.getDataHora() ==  null) {
            throw new IllegalArgumentException("Transação inválida: a data/hora não pode ser nula");
        }

        // verifica se o valor é maior ou igual a 0
        if (transacaoRequest.getValor().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Transação inválida: o valor deve ser maior que zero.");
        }
        // verifica se a data é menor ou igual a data de hoje
        if (transacaoRequest.getDataHora().isAfter(OffsetDateTime.now())) {
            throw new IllegalArgumentException("Transação inválida: a data/hora não pode estar no futuro.");
        }
    }
}
