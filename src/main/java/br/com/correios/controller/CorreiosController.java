package br.com.correios.controller;

import br.com.correios.model.Address;
import br.com.correios.service.CorreiosService;
import br.com.correios.service.LogService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class CorreiosController {
    @Autowired
    private CorreiosService service;
    @Autowired
    private LogService logService;

    @Operation(summary = "Consulta CEP", description = "Realiza a consulta do CEP informado e retorna o endereço correspondente.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta realizada com sucesso."),
            @ApiResponse(code = 404, message = "CEP não encontrado."),
            @ApiResponse(code = 500, message = "Erro no servidor.")
    })
    @GetMapping("cep/{cep}")
    public Address getCep(
            @Parameter(description = "CEP a ser consultado")
            @PathVariable("cep") String cep) throws IOException {
        logService.registrarLogConsulta(cep);
        return this.service.getCep(cep);
    }
}


        