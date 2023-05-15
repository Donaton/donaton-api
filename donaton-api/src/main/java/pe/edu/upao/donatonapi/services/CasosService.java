package pe.edu.upao.donatonapi.services;

import org.springframework.stereotype.Service;
import pe.edu.upao.donatonapi.model.Casos;
import pe.edu.upao.donatonapi.repository.CasosRepository;

import java.time.LocalDateTime;

@Service
public class CasosService {
    public final CasosRepository casosRepository;

    public CasosService(CasosRepository casosRepository){
        this.casosRepository = casosRepository;
    }

    public Casos addCasos(Casos casos){
        return casosRepository.save(casos);
    }
}
