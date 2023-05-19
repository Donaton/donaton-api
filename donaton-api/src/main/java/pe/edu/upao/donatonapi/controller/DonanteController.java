package pe.edu.upao.donatonapi.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pe.edu.upao.donatonapi.model.Donante;
import pe.edu.upao.donatonapi.services.DonanteService;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/donante")
public class DonanteController {

    private final DonanteService donanteService;

    @Autowired
    public DonanteController(DonanteService donanteService){
        this.donanteService = donanteService;
    }
    @PostMapping // Crear Casos
    public ResponseEntity<?> addDonantes(@Valid @RequestBody Donante donante, BindingResult bindingResult) {
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

    @GetMapping // Listar Casos Existentes
    public ResponseEntity<?> listarDonantes(){
        List<Donante> donante = donanteService.listarDonantes();

        if (donante.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron Donantes existentes");
        }

        return new ResponseEntity<List<Donante>>(donante, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarDonantes(@PathVariable("id") Long idDonante, @Valid @RequestBody Donante donante,
                                            BindingResult bindingResult){
        //Verirficar si el donante existe
        Donante donanteExistente = donanteService.findById(idDonante);
        if (donanteExistente == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El Donante no ha sido encontrado");
        }

        //Validar datos del caso
        if (bindingResult.hasErrors()) {
            String errorMessage = "Error";
            List<String> errors = bindingResult.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList());

            return ResponseEntity.badRequest().body(errorMessage + "" + errors);
        }

        donanteExistente.setNombre(donante.getNombre());


        Donante donanteActualizado = donanteService.editarDonantes(donanteExistente);
        return ResponseEntity.ok("Donante Actualizado Exitosamente");

    }
    @GetMapping("/buscarPorNombre")
    public ResponseEntity<?> buscarPorNombre(@RequestParam("nombre") String nombres){
        List<Donante> donanteList = donanteService.buscarDonantesPorNombre("%" + nombres + "%");
        if (donanteList.isEmpty()){
            String errorMensaje = "No se ha econtrado donantes similares";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMensaje);

        }
        return ResponseEntity.ok(donanteList);
    }

    @DeleteMapping("/{id}") //Borrar Caso
    public ResponseEntity<?> eliminarDonantes(@PathVariable("id") Long idDonante){
        Donante donante = donanteService.findById(idDonante); // Se utiliza el metodo FindById para buscar el donante

        if (donante == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El Donante no ha sido encontrado");
        } // Retorna un mensaje si el donante no ha sido encontrado en la base de datos

        donanteService.eliminarDonantes(idDonante);
        return ResponseEntity.status(HttpStatus.OK).body("Donante eliminado correctamente");
    }


}