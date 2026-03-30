package dev.pedrohqlimass.itauDesafio.repository;

import dev.pedrohqlimass.itauDesafio.dto.EstatisticaResponse;
import dev.pedrohqlimass.itauDesafio.dto.TransacaoRequest;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoRepository{

    private final List<TransacaoRequest> listaDeTransacoes = new ArrayList<>();

    // salvar os dados em uma lista
    public void salvarTransacoes(TransacaoRequest transacaoRequest) {
        listaDeTransacoes.add(transacaoRequest);
    }

    // apagar essa lista depois de 60 segundos
    public void limparTransacoes(TransacaoRequest transacaoRequest) {

    }

    // apagar todas as transacoes da lista
    public void deletarTodasTransacoes() {
        listaDeTransacoes.clear();
    }

    public EstatisticaResponse estatistica(OffsetDateTime horaInicial) {

        if (listaDeTransacoes.isEmpty()) {
            return new EstatisticaResponse(0L, BigDecimal.ZERO,BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
        }
        // transformar a lista de transacoes em numeros para fazer uma operacao
        final var summary = listaDeTransacoes.stream()
                .filter(t ->
                        t.getDataHora().isAfter(horaInicial) || t.getDataHora().isEqual(horaInicial)
                        )
                .mapToDouble(t -> t.getValor().doubleValue())
                .summaryStatistics();

        if (summary.getCount() == 0) {
            return new EstatisticaResponse(0, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
        }
        return new EstatisticaResponse(
                summary.getCount(),
                BigDecimal.valueOf(summary.getSum()),
                BigDecimal.valueOf(summary.getAverage()),
                BigDecimal.valueOf(summary.getMin()),
                BigDecimal.valueOf(summary.getMax())
        );
    }
}
