package pe.edu.upao.donatonapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upao.donatonapi.model.Casos;

public interface CasosRepository extends JpaRepository<Casos, Long> {

} //* Se utiliza Spring Data para reducir codigo y tener uan libreria del crude
