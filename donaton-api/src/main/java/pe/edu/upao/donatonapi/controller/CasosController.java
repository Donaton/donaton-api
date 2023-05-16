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

    @PostMapping // Crear Casos
    public ResponseEntity<?> addCasos(@Valid @RequestBody Casos casos, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessage = "Error";
            List<String> errors = bindingResult.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList());

            return ResponseEntity.badRequest().body(errorMessage + "" + errors);
        }

        Casos newCasos = casosService.addCasos(casos);
        return ResponseEntity.status(HttpStatus.OK).body("Caso creado exitosamente");
    }

    @GetMapping // Listar Casos Existentes
    public ResponseEntity<?> listarCasos(){
        List<Casos> casos = casosService.listarCasos();

        if (casos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron Casos existentes");
        }

        return new ResponseEntity<List<Casos>>(casos, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarCasos(@PathVariable("id") Long idCasos, @Valid @RequestBody Casos casos,
                                             BindingResult bindingResult){
        //Verirficar si el caso existe
        Casos casoExistente = casosService.findById(idCasos);
        if (casoExistente == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El Caso no ha sido encontrado");
        }

        //Validar datos del caso
        if (bindingResult.hasErrors()) {
            String errorMessage = "Error";
            List<String> errors = bindingResult.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList());

            return ResponseEntity.badRequest().body(errorMessage + "" + errors);
        }

        casoExistente.setNombres(casos.getNombres());
        casoExistente.setDescripcion(casos.getDescripcion());

        Casos casoActualizado = casosService.editarCasos(casoExistente);
        return ResponseEntity.ok("Caso Actualizado Exitosamente");

    }

    @DeleteMapping("/{id}") //Borrar Caso
    public ResponseEntity<?> eliminarCasos(@PathVariable("id") Long idCasos){
            Casos caso = casosService.findById(idCasos); // Se utiliza el metodo FindById para buscar el caso

            if (caso == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El Caso no ha sido encontrado");
            } // Retorna un mensaje si el caso no ha sido encontrado en la base de datos

            casosService.eliminarCasos(idCasos);
        return ResponseEntity.status(HttpStatus.OK).body("Caso eliminado correctamente");
    }
}

