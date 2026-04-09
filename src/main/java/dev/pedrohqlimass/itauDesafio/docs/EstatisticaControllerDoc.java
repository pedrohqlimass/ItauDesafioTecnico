package dev.pedrohqlimass.itauDesafio.docs;

import dev.pedrohqlimass.itauDesafio.dto.EstatisticaResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name="Estatísticas",
        description = "Endpoint responsável por calcular estatísticas das transações")
public interface EstatisticaControllerDoc {

    @Operation(summary = "Calcula estatísticas das transações",
            description = "Retorna dados estatísticos com base nas transações registradas"
    )
    @ApiResponse(responseCode = "200",
            description = "Estatísticas calculadas com sucesso"
    )
    ResponseEntity<EstatisticaResponse> estatistica();

}
