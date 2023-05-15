package pe.edu.upao.donatonapi.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pe.edu.upao.donatonapi.model.Casos;
import pe.edu.upao.donatonapi.services.CasosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/casos")
public class CasosController {

    private final CasosService casosService;

    @Autowired
    public CasosController(CasosService casosService){
        this.casosService = casosService;
    }

    @PostMapping
    public ResponseEntity<?> addCasos(@Valid @RequestBody Casos casos, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessage = "Error";
            List<String> errors = bindingResult.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList());

            return ResponseEntity.badRequest().body(errorMessage + "" + errors);
        }

        Casos newCasos = casosService.addCasos(casos);
        return ResponseEntity.status(HttpStatus.CREATED).body("Caso creado exitosamente");
    }
}

