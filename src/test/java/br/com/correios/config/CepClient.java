package br.com.correios.config;

import org.springframework.web.client.RestTemplate;

public class CepClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public String getCepInfo(String cep) {
        String url = "http://localhost:8080/cep/" + cep;
        return restTemplate.getForObject(url, String.class);
    }
}
