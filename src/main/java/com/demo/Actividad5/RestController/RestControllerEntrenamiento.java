package com.demo.Actividad5.RestController;

import com.demo.Actividad5.Entities.Ejercicio;
import com.demo.Actividad5.Entities.Entrenamiento;
import com.demo.Actividad5.Entities.Jugador;
import com.demo.Actividad5.services.entrenamiento.ServicioEntrenamiento;
import com.demo.Actividad5.services.entrenamiento.ServicioEntrenamientoMySql;
import org.json.simple.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestControllerEntrenamiento {
    private ServicioEntrenamiento servicioEntrenamiento;

    public RestControllerEntrenamiento() {
        this.servicioEntrenamiento = new ServicioEntrenamientoMySql();
    }
    @GetMapping("/entrenamientos")
    public List<JSONObject> MostrarENTRENAMIENTOS_IDYFECHA() {
        return this.servicioEntrenamiento.MostrarENTRENAMIENTOS_IDYFECHA();
            }

    @GetMapping("/entrenamientos/{id}")
    public Entrenamiento MostrarTODO_ENTRENAMIENTO(@PathVariable Integer id) {
        return this.servicioEntrenamiento.MostrarTODO_ENTRENAMIENTO(id);
            }

    @PostMapping(path = "/entrenamientos", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Entrenamiento AñadirEntrenamientos_SinNADA(@RequestBody Entrenamiento entrenamiento) {
        return this.servicioEntrenamiento.AñadirEntrenamientos_SinNADA(entrenamiento);
            }

    @PutMapping(path = "/entrenamientos/{id}/asistentes", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Jugador> AñadirASISTENTES(@PathVariable Integer id, @RequestBody List<Jugador> jugadores) {
        return this.servicioEntrenamiento.addAsistentes(id,jugadores);
    }

    @PutMapping(path = "/entrenamientos/{id}/ejercicios", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Ejercicio> AñadirEJERCICIO(@PathVariable Integer id, @RequestBody List<Ejercicio> ejercicios){
        return this.servicioEntrenamiento.AñadirEJERCICIOS(id, ejercicios);
    }

    @DeleteMapping("/entrenamientos/{id}")
    public List<Entrenamiento> EliminarENTRENAMIENTO(@PathVariable Integer id) {
        return this.servicioEntrenamiento.EliminarENTRENAMIENTO(id);

        };
    }



