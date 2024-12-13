package br.com.correios.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Schema(description = "Modelo de Endereço")
public class Address {
    @Id
    @Schema(description = "Logradouro do endereço", example = "04661-200")
    private String cep;
    @Schema(description = "Logradouro do endereço", example = "Av. Interlagos,")
    private String logradouro;
    @Schema(description = "Bairro do endereço", example = "Vila Arriete")
    private String bairro;
    @Schema(description = "UF do endereço", example = "SP")
    private String uf;
    @Schema(description = "Localidade do endereço", example = "São Paulo")
    private String estado;
    @Schema(description = "Região do endereço", example = "Sudeste")
    private String regiao;
    @Schema(description = "DDD", example = "11")
    private String ddd;

}
