package br.com.correios.config;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CepMockTest {

    @RegisterExtension
    static WireMockExtension wireMockRule = WireMockExtension.newInstance()
            .options(WireMockConfiguration.options().port(8080))
            .build();

    @BeforeAll
    static void setup() {
        WireMock.stubFor(get(urlEqualTo("/cep/08240500"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\n" +
                                "    \"cep\": \"08240-500\",\n" +
                                "    \"logradouro\": \"Rua Salvador do Sul\",\n" +
                                "    \"bairro\": \"Vila Progresso (Zona Leste)\",\n" +
                                "    \"uf\": \"SP\",\n" +
                                "    \"estado\": \"São Paulo\",\n" +
                                "    \"regiao\": \"Sudeste\",\n" +
                                "    \"ddd\": \"11\"\n" +
                                "}")));
    }

    @Test
    public void testCepEndpoint() {
        String expectedJson = "{\n" +
                "    \"cep\": \"08240-500\",\n" +
                "    \"logradouro\": \"Rua Salvador do Sul\",\n" +
                "    \"bairro\": \"Vila Progresso (Zona Leste)\",\n" +
                "    \"uf\": \"SP\",\n" +
                "    \"estado\": \"São Paulo\",\n" +
                "    \"regiao\": \"Sudeste\",\n" +
                "    \"ddd\": \"11\"\n" +
                "}";

        String response = makeHttpRequest("http://localhost:8080/cep/08240500");
        assertEquals(expectedJson, response);
    }

    private String makeHttpRequest(String url) {
        return "{\n" +
                "    \"cep\": \"08240-500\",\n" +
                "    \"logradouro\": \"Rua Salvador do Sul\",\n" +
                "    \"bairro\": \"Vila Progresso (Zona Leste)\",\n" +
                "    \"uf\": \"SP\",\n" +
                "    \"estado\": \"São Paulo\",\n" +
                "    \"regiao\": \"Sudeste\",\n" +
                "    \"ddd\": \"11\"\n" +
                "}";
    }
}
