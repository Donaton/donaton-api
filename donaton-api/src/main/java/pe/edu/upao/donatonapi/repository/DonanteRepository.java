package pe.edu.upao.donatonapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upao.donatonapi.model.Donante;


@Repository

public interface DonanteRepository extends JpaRepository<Donante, Long> {

}
