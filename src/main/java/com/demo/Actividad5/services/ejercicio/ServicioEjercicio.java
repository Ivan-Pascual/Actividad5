package com.demo.Actividad5.services.ejercicio;

import com.demo.Actividad5.Entities.Ejercicio;
import org.json.simple.JSONObject;

import java.util.List;

public interface ServicioEjercicio {
    List<JSONObject> MostrarIDyTITULO();
    Ejercicio MostrarTODO_DE_UN_EJERCICIO(Integer id);
    Ejercicio AñadirEjercicio(Ejercicio ejercicio);

}
