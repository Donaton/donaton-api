package pe.edu.upao.donatonapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upao.donatonapi.model.Damnificado;

import java.util.List;

@Repository
public interface DamnificadoRepository extends JpaRepository<Damnificado, Long> {

     //Metodo de consulta Jpa, utilizando un filtro de busqueda que ignora mayusculas y minusculas.
     List<Damnificado> findByDistritoLikeIgnoreCase(String distrito) ;

}


