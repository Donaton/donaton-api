package pe.edu.upao.donatonapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upao.donatonapi.model.Damnificado;

import java.util.Optional;


public interface DamnificadoRepository extends JpaRepository<Damnificado, Long> {

}


