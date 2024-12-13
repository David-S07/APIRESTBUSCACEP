package br.com.correios.service;

import br.com.correios.model.Address;
import br.com.correios.model.LogConsulta;
import br.com.correios.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LogService {
    private final LogRepository logRepository;

    @Autowired
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public void registrarLogConsulta(String cep) {
        LogConsulta log = new LogConsulta();
        log.setCep(cep);
        log.setDataConsulta(LocalDateTime.now());
        logRepository.save(log);
    }
}
