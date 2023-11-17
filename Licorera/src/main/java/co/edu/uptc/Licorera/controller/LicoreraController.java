package co.edu.uptc.Licorera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.uptc.Licorera.model.MetodoPago;
import co.edu.uptc.Licorera.service.LicoreraService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/metodo_pago")
public class LicoreraController {

    @Autowired
    private LicoreraService licoreraService;

    @PostMapping
    public ResponseEntity<String> createMetodoPago(@RequestBody MetodoPago metodoPago) {
        MetodoPago createdMetodoPago = licoreraService.saveMetodoPago(metodoPago);
        if (createdMetodoPago != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Método de pago creado exitosamente");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fallo al crear método de pago");
        }
    }

    @GetMapping
    public ResponseEntity<List<MetodoPago>> getAllMetodosPago() {
        List<MetodoPago> metodosPago = licoreraService.getAllMetodosPago();
        if (!metodosPago.isEmpty()) {
            return ResponseEntity.ok(metodosPago);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateMetodoPago(@PathVariable Long id, @RequestBody MetodoPago metodoPago) {
        Optional<MetodoPago> existingMetodoPago = licoreraService.getMetodoPagoById(id);
        if (existingMetodoPago.isPresent()) {
            MetodoPago updatedMetodoPago = licoreraService.updateMetodoPago(metodoPago, id);
            if (updatedMetodoPago != null) {
                return ResponseEntity.ok("Método de pago actualizado exitosamente");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fallo al actualizar método de pago");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Método de pago no encontrado");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMetodoPago(@PathVariable Long id) {
        if (licoreraService.deleteMetodoPago(id)) {
            return ResponseEntity.ok("Método de pago eliminado exitosamente");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Falló al eliminar método de pago");
        }
    }
}
