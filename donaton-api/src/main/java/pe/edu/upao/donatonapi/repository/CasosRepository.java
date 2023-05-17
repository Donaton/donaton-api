package pe.edu.upao.donatonapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upao.donatonapi.model.Casos;

import java.util.List;

@Repository
public interface CasosRepository extends JpaRepository<Casos, Long> {
    List<Casos> findByNombresLikeIgnoreCase(String nombres);

} //* Se utiliza Spring Data para reducir codigo y tener uan libreria del crude
