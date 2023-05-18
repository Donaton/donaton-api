package pe.edu.upao.donatonapi.services;

import org.springframework.stereotype.Service;
import pe.edu.upao.donatonapi.model.Damnificado;
import pe.edu.upao.donatonapi.repository.DamnificadoRepository;

import java.util.Collections;
import java.util.List;


@Service
public class DamnificadoService{

    public static DamnificadoRepository damnificadoRepository;

    public DamnificadoService(DamnificadoRepository damnificadoRepository){
        this.damnificadoRepository = damnificadoRepository;
    }

    public static Damnificado addDamnificado(Damnificado damnificado){
        return damnificadoRepository.save(damnificado);
    }

    public void eliminarDamnificado(Long id){
        damnificadoRepository.deleteAllById(Collections.singleton(id));
    }

    public Damnificado findById(Long id) {
        return damnificadoRepository.findById(id).orElse(null);
    }

    public Damnificado modificarDamnificado(Damnificado damnificado) {
        return damnificadoRepository.save(damnificado);
    }

    public List<Damnificado> listarDamnificados() {
        return damnificadoRepository.findAll();
    }

    public List<Damnificado> buscarCasosPorDistrito(String distrito) {

        return damnificadoRepository.findByDistritoLikeIgnoreCase(distrito);
    }


}