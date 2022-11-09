package com.demo.Actividad5.services.jugador;

import com.demo.Actividad5.Entities.Ejercicio;
import com.demo.Actividad5.Entities.Entrenamiento;
import com.demo.Actividad5.Entities.Jugador;
import org.json.simple.JSONObject;

import java.util.List;

public interface ServicioJugador {
   List <JSONObject> MostrarDNI_NOMBRE_APELLIDOS();
    Jugador MostrarTODO(String id);
    Jugador AñadirJugador(Jugador jugador);
    Jugador CambiarJugador(String id, Jugador jugador);





}
