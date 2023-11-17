package co.edu.uptc.Licorera.service;

import co.edu.uptc.Licorera.model.MetodoPago;
import co.edu.uptc.Licorera.repository.LicoreraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LicoreraImp implements LicoreraService {

    @Autowired
    private LicoreraRepository licoreraRepository;

    @Override
    public MetodoPago saveMetodoPago(MetodoPago metodoPago) {
        return licoreraRepository.save(metodoPago);
    }

    @Override
    public List<MetodoPago> getAllMetodosPago() {
        return licoreraRepository.findAll();
    }

    @Override
    public Optional<MetodoPago> getMetodoPagoById(Long id) {
        return licoreraRepository.findById(id);
    }

    @Override
    public MetodoPago updateMetodoPago(MetodoPago metodoPago, Long id) {
        Optional<MetodoPago> existingMetodoPago = licoreraRepository.findById(id);
        if (existingMetodoPago.isPresent()) {
            metodoPago.setIdMetodoPago(id);
            return licoreraRepository.save(metodoPago);
        }
        return null;
    }

    @Override
    public boolean deleteMetodoPago(Long id) {
        Optional<MetodoPago> existingMetodoPago = licoreraRepository.findById(id);
        if (existingMetodoPago.isPresent()) {
            licoreraRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
