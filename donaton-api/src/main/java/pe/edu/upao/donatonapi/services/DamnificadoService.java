package pe.edu.upao.donatonapi.services;

import org.springframework.stereotype.Service;
import pe.edu.upao.donatonapi.model.Damnificado;
import pe.edu.upao.donatonapi.repository.DamnificadoRepository;

@Service
public class DamnificadoService{

        public static DamnificadoRepository damnificadoRepository;

        public DamnificadoService(DamnificadoRepository damnificadoRepository){
            this.damnificadoRepository = damnificadoRepository;
        }

        public static Damnificado addDamnificado(Damnificado damnificado){
            return damnificadoRepository.save(damnificado);
        }



}
