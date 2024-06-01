
package com.duenio.mascota.service;

import com.duenio.mascota.model.Duenio;
import java.util.List;


public interface IDuenioService {
    
    //traer duenio
    public List<Duenio> getDuenios();
    
    //crear duenioo
    public void saveDuenio(Duenio duenio);
    
    //eliminar duenio
    public void deleteDuenio(Long id_duenio);
    
    //encontrar un duenio
    public Duenio findDuenio(Long id_duenio);
    
    //editar un duenio con su id
    public Duenio editarDuenio (Long idoriginal, Long idNueva, String nuevoDni, String nuevoNombre, String nuevoApellido, String nuevoCelular);
    
    //editar sin id
    public Duenio editDuenio(Duenio duenio);
}
