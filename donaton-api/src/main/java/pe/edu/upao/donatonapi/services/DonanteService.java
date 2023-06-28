package pe.edu.upao.donatonapi.services;

import org.springframework.stereotype.Service;
import pe.edu.upao.donatonapi.model.Donante;
import pe.edu.upao.donatonapi.repository.DonanteRepository;

@Service
public class DonanteService {

    public final DonanteRepository donanteRepository;
    public DonanteService(DonanteRepository donanteRepository){
        this.donanteRepository = donanteRepository;
    }

    public Donante addDonantes(Donante donante){
        return donanteRepository.save(donante);
    }

}
