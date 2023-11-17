package co.edu.uptc.Licorera.service;
import java.util.List;
import java.util.Optional;

import co.edu.uptc.Licorera.model.MetodoPago;

public interface LicoreraService {

    MetodoPago saveMetodoPago(MetodoPago metodoPago);
    List<MetodoPago> getAllMetodosPago();
    Optional<MetodoPago> getMetodoPagoById(Long id);
    MetodoPago updateMetodoPago(MetodoPago metodoPago, Long id);
    boolean deleteMetodoPago(Long id);
}
