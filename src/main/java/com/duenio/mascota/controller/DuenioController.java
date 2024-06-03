
package com.duenio.mascota.controller;

import com.duenio.mascota.model.Duenio;
import com.duenio.mascota.service.IDuenioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DuenioController {
    
    @Autowired
    private IDuenioService iDueSer;
    
    @GetMapping("/duenio/traerlos")
    public List<Duenio>getDuenios() {
        
        return iDueSer.getDuenios();
    }
    
    @PostMapping("/duenio/crear")
    public String saveDueni(@RequestBody Duenio duenio){
        iDueSer.saveDuenio(duenio);
        return "Creado correctamente";
    }
    
    @DeleteMapping("/duenio/eliminar/{id_duenio}")
    public String deleteDuenio(@PathVariable Long id_duenio) {
        
        iDueSer.deleteDuenio(id_duenio);
        return"Eliminado correctamente";
        
    }
    
    @GetMapping("/duenio/traer/{id_duenio}")
    public Duenio findDuenio(@PathVariable Long id_duenio){
        return iDueSer.findDuenio(id_duenio);
        
    }
    
    @PutMapping("/duenio/editar/{idOriginal}")
    public Duenio editarDuenio(@PathVariable Long idOriginal, @RequestParam(required = false) Long idNueva,
                               @RequestParam(required = false) String nuevoDni,
                               @RequestParam(required = false) String nuevoNombre,
                               @RequestParam(required = false) String nuevoApellido,
                               @RequestParam(required = false) String nuevoCelular){
        
        iDueSer.editarDuenio(idOriginal, idNueva, nuevoDni, nuevoNombre, nuevoApellido, nuevoCelular);
        
        Duenio duenio = this.findDuenio(idNueva);
        return duenio;
    }
    
    @PutMapping("/duenio/editar")
    public Duenio editDuenio(@RequestBody Duenio duenio){
        
        iDueSer.editDuenio(duenio);
        return iDueSer.findDuenio(duenio.getId_duenio());
    }
    
}
