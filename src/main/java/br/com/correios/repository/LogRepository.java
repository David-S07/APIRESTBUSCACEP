package br.com.correios.repository;

import br.com.correios.model.LogConsulta;
import org.springframework.data.repository.CrudRepository;

public interface LogRepository extends CrudRepository<LogConsulta, String>{
}
