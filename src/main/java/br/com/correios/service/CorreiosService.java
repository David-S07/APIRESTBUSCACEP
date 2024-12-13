package br.com.correios.service;

import br.com.correios.model.Address;
import com.nimbusds.jose.shaded.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CorreiosService {
    private static Logger logger = LoggerFactory.getLogger(CorreiosService.class);

    public Address getCep(String cep) throws IOException {
        Address address = null;

        logger.info(" ===  ====  =====||");
        logger.info("||    ||=   ||===||");
        logger.info(" ===  ====  ||      ");
        HttpGet request = new HttpGet("https://viacep.com.br/ws/" + cep + "/json/");

        try (CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();
             CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String result = EntityUtils.toString(entity);

                Gson gson = new Gson();
                address = gson.fromJson(result, Address.class);
            }
        }
        return address;
    }
}