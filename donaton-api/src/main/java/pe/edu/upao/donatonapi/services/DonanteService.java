package pe.edu.upao.donatonapi.services;
import org.springframework.stereotype.Service;
import pe.edu.upao.donatonapi.model.Donante;
import pe.edu.upao.donatonapi.repository.DonanteRepository;

import java.util.List;
@Service
public class DonanteService {
    public final DonanteRepository donanteRepository;

    public DonanteService(DonanteRepository donanteRepository){
        this.donanteRepository = donanteRepository;
    }
    public Donante addDonantes(Donante donante){
        return donanteRepository.save(donante);
    }

    public List<Donante> listarDonantes(){
        return donanteRepository.findAll();
    }
    public Donante findById(Long idDonante){
        return donanteRepository.findById(idDonante).orElse(null);
    }

    public Donante editarDonantes(Donante donante){
        return donanteRepository.save(donante);
    }

    public List<Donante> buscarDonantesPorNombre(String nombre) {

        return donanteRepository.findByNombresLikeIgnoreCase( nombre);
    }

    public void eliminarDonantes(Long idDonante){

        donanteRepository.deleteById(idDonante);
    }
}