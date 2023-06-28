package pe.edu.upao.donatonapi.services;

import org.springframework.stereotype.Service;
import pe.edu.upao.donatonapi.model.Donacion;
import pe.edu.upao.donatonapi.model.Donante;
import pe.edu.upao.donatonapi.repository.DonacionRepository;
import pe.edu.upao.donatonapi.repository.DonanteRepository;
@Service
public class DonacionService {

    public final DonacionRepository donacionRepository;

    public DonacionService(DonacionRepository donacionRepository){
        this.donacionRepository = donacionRepository;
    }

    public Donacion addDonacion(Donacion donacion){
        return donacionRepository.save(donacion);
    }
}
