package pe.edu.upao.donatonapi.controller;


import jakarta.validation.Valid;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pe.edu.upao.donatonapi.model.Donante;
import pe.edu.upao.donatonapi.services.DonanteService;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping("/donante")
public class DonanteController {

    private DonanteService donanteService;

    @Autowired
    public DonanteController(DonanteService donanteService){
        this.donanteService = donanteService;
    }
    @PostMapping // Crear Donante
    public ResponseEntity<?> addDonantes(@Valid @RequestBody Donante donante, @NotNull BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessage = "Error";
            List<String> errors = bindingResult.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList());

            return ResponseEntity.badRequest().body(errorMessage + "" + errors);
        }

        Donante newDonante = donanteService.addDonantes(donante);
        return ResponseEntity.status(HttpStatus.OK).body("Donante creado exitosamente");
    }

}
