
package com.duenio.mascota.service;

import com.duenio.mascota.dto.MascotaDTO;
import com.duenio.mascota.model.Mascota;
import java.util.List;


public interface IMascotaService {
    
    //traer todas las mascotas
    public List<Mascota> getMascotas();
    
    //crear mascota
    public void saveMascota(Mascota masco);
    
    //eliminar mascota
    public void deleteMascota(Long id_mascota);
    
    //buscar mascota en cuestion
    public Mascota findMascota(Long id_masco);
    
    //editar mascota con id
    public Mascota editarMascota(Long idOriginal, Long idNueva, String nuevoNombre, String nuevaEspecie, String nuevaRaza, String nuevoColor);
    
    //editar mascota sin id
    public Mascota editMascota(Mascota masco);

    public List<Mascota> getEspePeRaCani();

    public MascotaDTO getMascoDto(Long id_masco);
}
