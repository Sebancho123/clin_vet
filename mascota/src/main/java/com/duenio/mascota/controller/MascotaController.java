
package com.duenio.mascota.controller;

import com.duenio.mascota.dto.MascotaDTO;
import com.duenio.mascota.model.Mascota;
import com.duenio.mascota.service.IMascotaService;
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
public class MascotaController {
    
    @Autowired
    private IMascotaService iMascoSer;
    
    @GetMapping("/mascota/traerlas")
    public List<Mascota>getMascotas() {
        return iMascoSer.getMascotas();
    }
    
    @PostMapping("/mascota/crear")
    public String saveMascotas(@RequestBody Mascota masco) {
        iMascoSer.saveMascota(masco);
        return "Creada correctamente";
    }
    
    @DeleteMapping("/mascota/eliminar/{id_mascota}")
    public String deleteMascota(@PathVariable Long id_mascota) {
        iMascoSer.deleteMascota(id_mascota);
        return "Eliminada correctamente";
    }
    
    @GetMapping("/mascota/traer/{id_mascota}")
    public Mascota findMascota(@PathVariable Long id_mascota) {
        return iMascoSer.findMascota(id_mascota);
    }
    
    @PutMapping("/mascota/editar/{idOriginal}")
    public Mascota editarMascota(@PathVariable Long idOriginal, @RequestParam(required = false)Long idnueva,
                                 @RequestParam(required = false)String nuevoNombre,
                                 @RequestParam(required = false)String nuevaEspecie,
                                 @RequestParam(required = false)String nuevaRaza,
                                 @RequestParam(required = false)String nuevoColor) {
        
        iMascoSer.editarMascota(idOriginal, idnueva, nuevoNombre, nuevaEspecie, nuevaRaza, nuevoColor);
        
        Mascota masco = this.findMascota(idnueva);
        return masco;
        
    }
    
    @PutMapping("/mascota/editar")
    public Mascota editMascota (@RequestBody Mascota masco) {
        
        iMascoSer.editMascota(masco);
        return masco;
    }
    
    @GetMapping("/traer/especificas")
    public List<Mascota> getEspePeRaCani() {
        return iMascoSer.getEspePeRaCani();
    }
    
    @GetMapping("/devolver/{id_masco}")
    public MascotaDTO getMascoDTO(@PathVariable Long id_masco) {
        return iMascoSer.getMascoDto(id_masco);
    } 
    
    
}
