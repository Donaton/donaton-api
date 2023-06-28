package pe.edu.upao.donatonapi.services;

import org.springframework.stereotype.Service;
import pe.edu.upao.donatonapi.model.Casos;
import pe.edu.upao.donatonapi.repository.CasosRepository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class CasosService {
    public final CasosRepository casosRepository;

    public CasosService(CasosRepository casosRepository){
        this.casosRepository = casosRepository;
    }

    public Casos addCaso(Casos casos){
        return casosRepository.save(casos);
    }

    public List<Casos> listarCasos(){
        return casosRepository.findAll();
    }

    public void eliminarCasos(Long idCasos){
        casosRepository.deleteAllById(Collections.singleton(idCasos));
    }
}
