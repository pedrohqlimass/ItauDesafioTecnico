package dev.pedrohqlimass.itauDesafio.docs;

import dev.pedrohqlimass.itauDesafio.dto.TransacaoRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name="Transações",
        description = "Endpoints responsáveis por criar, listar e limpar transações.")
public interface TransacaoControllerDoc {

    @Operation(summary = "Cria transação",
            description = "Recebe uma transação válida e adiciona em uma lista"
    )
    @ApiResponse(responseCode="201",
            description = "Transação criada com sucesso"
    )
    @ApiResponse(responseCode="422",
            description = "Erro de validação capturado"
    )
    @ApiResponse(responseCode="400",
            description = "Erro inesperado no servidor"
    )
    ResponseEntity<Void> adicionar(@RequestBody TransacaoRequest transacaoRequest);

    @Operation(summary = "Deleta transação",
            description = "Remove todas as transações adicionadas a lista"
    )
    @ApiResponse(responseCode = "200",
            description = "Todas as transações foram deletadas"
    )
    ResponseEntity<Void> deletarTodasTransacoes();
}
