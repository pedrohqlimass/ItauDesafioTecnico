package dev.pedrohqlimass.itauDesafio.controller;

import dev.pedrohqlimass.itauDesafio.dto.TransacaoRequest;
import dev.pedrohqlimass.itauDesafio.repository.TransacaoRepository;
import dev.pedrohqlimass.itauDesafio.service.TransacaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @PostMapping
    public ResponseEntity adicionar (@RequestBody TransacaoRequest transacaoRequest) {

        try{
            transacaoService.validarTransacao(transacaoRequest);
            transacaoRepository.salvarTransacoes(transacaoRequest);
            return ResponseEntity.status(HttpStatus.CREATED).build();

        } catch (IllegalArgumentException exception) {
            log.error("Parâmetros inválidos. Regras: valdo deve ser maior que 0 (recebido: " + transacaoRequest.getValor()
                    + "), dataHora deve ser igual ou anterior à hora atual (recebido: " + transacaoRequest.getDataHora() + ")");
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        } catch (Exception e) {
            log.error("Requisição inválida. Verifique os campos obrigatórios e o formato dos dados.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping
    public ResponseEntity deletarTodasTransacoes() {
        log.info("Iniciando deleção de todas as transações.");
        transacaoRepository.deletarTodasTransacoes();
        log.info("Todas as transações foram deletadas com sucesso.");
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
