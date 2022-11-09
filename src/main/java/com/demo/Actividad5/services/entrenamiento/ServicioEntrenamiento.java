package com.demo.Actividad5.services.entrenamiento;

import com.demo.Actividad5.Entities.Ejercicio;
import com.demo.Actividad5.Entities.Entrenamiento;
import com.demo.Actividad5.Entities.Jugador;
import org.json.simple.JSONObject;

import java.util.List;

public interface ServicioEntrenamiento {
    List<JSONObject> MostrarENTRENAMIENTOS_IDYFECHA();
    Entrenamiento MostrarTODO_ENTRENAMIENTO(Integer id);
    Entrenamiento AñadirEntrenamientos_SinNADA(Entrenamiento entrenamiento);
    List<Jugador> addAsistentes(Integer id, List<Jugador> jugadores);

    List<Ejercicio>AñadirEJERCICIOS(Integer id, List<Ejercicio> ejercicios);

    List<Entrenamiento>EliminarENTRENAMIENTO(Integer id);



}
