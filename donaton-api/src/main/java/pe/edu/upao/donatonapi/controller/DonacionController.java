package pe.edu.upao.donatonapi.controller;

import jakarta.validation.Valid;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pe.edu.upao.donatonapi.model.Donacion;
import pe.edu.upao.donatonapi.model.Donante;
import pe.edu.upao.donatonapi.services.DonacionService;
import pe.edu.upao.donatonapi.services.DonanteService;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/donacion")
public class DonacionController {

    private DonacionService donacionService;
    private DonanteService donanteService;

    @Autowired
    public DonacionController(DonacionService donacionService, DonanteService donanteService) {
        this.donacionService = donacionService;
        this.donanteService = donanteService;
    }

    @PostMapping
    public ResponseEntity<?> addDonacion(@Valid @RequestBody Donacion donacion, @NotNull BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessage = "Error";
            List<String> errors = bindingResult.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList());

            return ResponseEntity.badRequest().body(errorMessage + " " + errors);
        }

        if (donacion.getDonante().getID_donante() == null) {
            Donante donante = donanteService.addDonantes(donacion.getDonante());
            donacion.setDonante(donante);
        }

        Donacion newDonacion = donacionService.addDonacion(donacion);
        return ResponseEntity.status(HttpStatus.OK).body("Donacion exitosa");
    }

}

