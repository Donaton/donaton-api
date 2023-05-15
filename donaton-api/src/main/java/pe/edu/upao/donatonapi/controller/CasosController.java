package pe.edu.upao.donatonapi.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upao.donatonapi.model.Casos;
import pe.edu.upao.donatonapi.services.CasosService;

@RestController
@RequestMapping("/casos")
public class CasosController {

    @Autowired
    public final CasosService casosService;

    public CasosController(CasosService casosService){
        this.casosService = casosService;
    }

    @PostMapping
    public ResponseEntity<Casos> addCasos(@Valid @RequestBody Casos casos){
        Casos newCasos = casosService.addCasos(casos);
    return new ResponseEntity<Casos>(newCasos, HttpStatus.CREATED);
    }
}
