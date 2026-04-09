package dev.pedrohqlimass.itauDesafio.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransacaoRequest {

    @NotNull(message = "O valor não deve ser nulo")
    @Positive(message = "O valor deve ser maior ou igual a 0")
    private BigDecimal valor;

    @NotNull(message = "A data não deve ser nula")
    private OffsetDateTime dataHora;

    public BigDecimal getValor() {
        return valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }
}
