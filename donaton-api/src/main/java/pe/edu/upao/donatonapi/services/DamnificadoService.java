package pe.edu.upao.donatonapi.services;

import org.springframework.stereotype.Service;
import pe.edu.upao.donatonapi.model.Damnificado;
import pe.edu.upao.donatonapi.repository.DamnificadoRepository;

import java.util.Collections;
import java.util.List;


@Service
public class DamnificadoService{

    //variable que representa a repositorio
    public static DamnificadoRepository damnificadoRepository;

    public DamnificadoService(DamnificadoRepository damnificadoRepository){
        this.damnificadoRepository = damnificadoRepository;
    }

    //Metodo para agregar damnificado
    public static Damnificado addDamnificado(Damnificado damnificado){
        return damnificadoRepository.save(damnificado);
    }

    //Metodo para eliminar damnificado
    public void eliminarDamnificado(Long id){
        damnificadoRepository.deleteAllById(Collections.singleton(id));
    }

    //Metodo para buscar damnificado por id
    public Damnificado findById(Long id) {
        return damnificadoRepository.findById(id).orElse(null);
    }

    //Metodo para modificar damnificado
    public Damnificado modificarDamnificado(Damnificado damnificado) {
        return damnificadoRepository.save(damnificado);
    }

    //Metodo para listar damnificados
    public List<Damnificado> listarDamnificados() {
        return damnificadoRepository.findAll();
    }

    //Metodo para buscar damnificado por distrito
    public List<Damnificado> buscarCasosPorDistrito(String distrito) {

        return damnificadoRepository.findByDistritoLikeIgnoreCase(distrito);
    }


}