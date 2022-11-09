package com.demo.Actividad5.RestController;


import com.demo.Actividad5.Entities.Ejercicio;
import com.demo.Actividad5.services.ejercicio.ServicioEjercicio;
import com.demo.Actividad5.services.ejercicio.ServicioEjercicioMySql;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestControllerEjercicio {
    private final ServicioEjercicio servicioEjercicio;
    public RestControllerEjercicio(){this.servicioEjercicio = new ServicioEjercicioMySql();}
    @GetMapping("/ejercicios")
    List<JSONObject> MostrarIDyTITULO() {
        return this.servicioEjercicio.MostrarIDyTITULO();
    }
    @GetMapping("/ejercicios/{id}")
    Ejercicio MostrarTODO_DE_UN_EJERCICIO(@PathVariable Integer id){
        return this.servicioEjercicio.MostrarTODO_DE_UN_EJERCICIO(id);
    }
    @PostMapping("ejercicios")
    Ejercicio AñadirEjercicio(@RequestBody Ejercicio ejercicio){
        return this.servicioEjercicio.AñadirEjercicio(ejercicio);
    }

}
