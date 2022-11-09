package com.demo.Actividad5.RestController;

import com.demo.Actividad5.services.jugador.ServicioJugadorMySql;
import com.demo.Actividad5.services.jugador.ServicioJugador;
import com.demo.Actividad5.Entities.Jugador;
import org.json.simple.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class RestControllerJugador {
    private final ServicioJugador servicioJugador;
    public RestControllerJugador() {
        this.servicioJugador = new ServicioJugadorMySql();
    }
    @GetMapping("/jugadores")
    List <JSONObject> MostrarDNI_NOMBRE_APELLIDOS(){
        return this.servicioJugador.MostrarDNI_NOMBRE_APELLIDOS();
        }

    @GetMapping("/jugadores/{id}")
    Jugador MostrarTodo (@PathVariable String id ){
        return this.servicioJugador.MostrarTODO(id);
    }

    @PostMapping (path = "/jugadores", consumes = MediaType.APPLICATION_JSON_VALUE)
    Jugador añadirJugador(@RequestBody Jugador jugador){
        return this.servicioJugador.AñadirJugador(jugador);
    }
    @PutMapping (path = "/jugadores/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    Jugador cambiarJugador(@PathVariable String id, @RequestBody Jugador jugador){
        return this.servicioJugador.CambiarJugador(id,jugador);
    }
}

