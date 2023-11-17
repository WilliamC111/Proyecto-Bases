package co.edu.uptc.Licorera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uptc.Licorera.model.MetodoPago;


public interface LicoreraRepository extends JpaRepository<MetodoPago, Long> {
   
}
