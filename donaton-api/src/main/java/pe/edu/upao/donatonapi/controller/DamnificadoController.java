package pe.edu.upao.donatonapi.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pe.edu.upao.donatonapi.model.Damnificado;
import pe.edu.upao.donatonapi.services.DamnificadoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/damnificado")
public class DamnificadoController {


    private final DamnificadoService damnificadoService;

    @Autowired
    public DamnificadoController(DamnificadoService damnificadoService){
        this.damnificadoService = damnificadoService;
    }

    @PostMapping // registrar damnificado
    public ResponseEntity<?> addDamnificado(@Valid @RequestBody Damnificado damnificado, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessage = "Error";
            List<String> errors = bindingResult.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList());

            return ResponseEntity.badRequest().body(errorMessage + "" + errors);
        }

        Damnificado newDamnificado = DamnificadoService.addDamnificado(damnificado);
        return ResponseEntity.status(HttpStatus.CREATED).body("Registro exitoso");
    }
}





