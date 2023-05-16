package pe.edu.upao.donatonapi.services;

import org.springframework.stereotype.Service;
import pe.edu.upao.donatonapi.model.Casos;
import pe.edu.upao.donatonapi.repository.CasosRepository;

import java.util.List;

@Service
public class CasosService {
    public final CasosRepository casosRepository;

    public CasosService(CasosRepository casosRepository){
        this.casosRepository = casosRepository;
    }

    public Casos addCasos(Casos casos){
        return casosRepository.save(casos);
    }

    public List<Casos> listarCasos(){
        return casosRepository.findAll();
    }

    public Casos findById(Long idCasos){
        return casosRepository.findById(idCasos).orElse(null);
    }

    public Casos editarCasos(Casos casos){
        return casosRepository.save(casos);
    }

    public void eliminarCasos(Long idCasos){

        casosRepository.deleteById(idCasos);
    }
}
