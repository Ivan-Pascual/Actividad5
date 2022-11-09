package com.demo.Actividad5.services.entrenamiento;

import com.demo.Actividad5.Entities.Ejercicio;
import com.demo.Actividad5.Entities.Entrenamiento;
import com.demo.Actividad5.Entities.Jugador;
import com.demo.Actividad5.Mysql.DBMySQLConnection;
import org.json.simple.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicioEntrenamientoMySql implements ServicioEntrenamiento{
    List<Entrenamiento>entrenamientos = new ArrayList<>();
    @Override
    public List<JSONObject> MostrarENTRENAMIENTOS_IDYFECHA() {
        List<JSONObject> entrenamientoPersonalizados = new ArrayList<>();
        try {
            ResultSet rs = DBMySQLConnection.getConnection().createStatement().executeQuery("select id, fecha FROM entrenamientos");
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String fecha = rs.getString("fecha");
                Entrenamiento entrenamiento = new Entrenamiento(id,fecha);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("fecha", entrenamiento.getFecha());
                jsonObject.put("id",entrenamiento.getId());
                entrenamientoPersonalizados.add(jsonObject);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return entrenamientoPersonalizados;
    }

    @Override
    public Entrenamiento MostrarTODO_ENTRENAMIENTO(Integer id) {
        Entrenamiento entrenamiento = null;
    try {

            String sqlEjercicio = "select * FROM ejercicios WHERE id in (select id_ejercicio from Ejercicio_entrenamiento where id_entrenamiento in (select id from entrenamientos where id="+id+"))";
            ResultSet rs_ejercicio = DBMySQLConnection.getConnection().createStatement().executeQuery(sqlEjercicio);
            List<Ejercicio> ejercicios = new ArrayList<>();
            while (rs_ejercicio.next()) {
                Integer idEjercicio = rs_ejercicio.getInt("id");
                String titulo = rs_ejercicio.getString("titulo");
                String descripcion = rs_ejercicio.getString("descripcion");
                String etiquetas = rs_ejercicio.getString("etiquetas");
                String materiales_necesarios = rs_ejercicio.getString("materiales_necesarios");
                String recursos_multimedia = rs_ejercicio.getString("recursos_multimedia");
                Integer duracion = rs_ejercicio.getInt("duracion");
                Integer dureza = rs_ejercicio.getInt("dureza");
                Ejercicio ejercicio = new Ejercicio(idEjercicio, duracion,titulo,descripcion,etiquetas,dureza,materiales_necesarios,recursos_multimedia);
                ejercicios.add(ejercicio);
            }

            String sql = "select * FROM jugadores WHERE DNI in" +
                    " (select DNI from Entrenamiento_jugador where id_entrenamiento in (select id from entrenamientos where id=" +id+"))";
            ResultSet rs_jugador = DBMySQLConnection.getConnection().createStatement().executeQuery(sql);
            List<Jugador> jugadores = new ArrayList<>();
            while (rs_jugador.next()) {
                String DNI = rs_jugador.getString("DNI");
                String nombre = rs_jugador.getString("nombre");
                String apellidos = rs_jugador.getString("apellidos");
                String fecha = rs_jugador.getString("Fecha");
                Integer velocidad = rs_jugador.getInt("velocidad");
                Integer resistencia = rs_jugador.getInt("velocidad");
                Integer recuperacion = rs_jugador.getInt("velocidad");
                Jugador jugador = new Jugador(DNI,nombre,apellidos,fecha,velocidad,resistencia,recuperacion);
                jugadores.add(jugador);
            }
        ResultSet rs = DBMySQLConnection.getConnection().createStatement().executeQuery("select * FROM entrenamientos WHERE id= " + id);
        while (rs.next()) {
            String fecha = rs.getString("fecha");
            entrenamiento = new Entrenamiento(id, fecha);
            entrenamiento.setEjercicios(ejercicios);
            entrenamiento.setJugadores(jugadores);

        }
        } catch (SQLException e) {
            System.err.println(e);
        }
     return entrenamiento;
    }
    @Override
    public Entrenamiento AñadirEntrenamientos_SinNADA(Entrenamiento entrenamiento) {
        try {
            String sql = "INSERT INTO entrenamientos (id, fecha) VALUES ('"
                    + entrenamiento.getId() + "','" + entrenamiento.getFecha() + "')";
            DBMySQLConnection.getConnection().createStatement().execute(sql);
            entrenamientos.add(entrenamiento);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return entrenamiento;
    }

    @Override
    public List<Jugador> addAsistentes(Integer id, List<Jugador> jugadores) {
        try {
                for (Integer i = 0; i < jugadores.size(); i++) {
                    Jugador Jnuevo = jugadores.get(i);
                    jugadores.add(Jnuevo);
                    String sql = "INSERT INTO Entrenamiento_jugador (id_entrenamiento, DNI) VALUES (" + id + ",'" + Jnuevo.getDNI() + "')";
                    DBMySQLConnection.getConnection().createStatement().execute(sql);
                }
            }
        catch (SQLException e) {
            System.err.println(e);
        }
        return jugadores;
    }

    @Override
    public List<Ejercicio> AñadirEJERCICIOS(Integer id, List<Ejercicio> ejercicios) {
        try {
            for (Integer i = 0; i < ejercicios.size(); i++) {
                Ejercicio Enuevo = ejercicios.get(i);
                ejercicios.add(Enuevo);
                String sql = "INSERT INTO Ejercicio_entrenamiento (id_entrenamiento, id_ejercicio) VALUES (" + id + ",'" + Enuevo.getId() + "')";
                DBMySQLConnection.getConnection().createStatement().execute(sql);
            }
        }
        catch (SQLException e) {
            System.err.println(e);
        }
        return ejercicios;
    }



    @Override
    public List<Entrenamiento> EliminarENTRENAMIENTO(Integer id) {
        try{
            String sql = "DELETE FROM entrenamientos WHERE id="+id;
        DBMySQLConnection.getConnection().createStatement().execute(sql);
        }catch (SQLException e){
            System.err.println(e);
        }
        return entrenamientos;
    }
}
//PARA PROBAR RAPIDO
/* ENTRENAMIENTOS
 "id": "1"
 "fecha": "06-11-2003"
 */
        /* JUGADORES
[
    {
        "nombre": "Sergio",
        "apellidos": "Javierre",
        "fecha_nac": "2000-01-01",
        "recuperacion": 3,
        "velocidad": 3,
        "resistencia": 3,
        "dni": "18035798C"
    },
    {
        "nombre": "Ivan",
        "apellidos": "Pascual Lopez",
        "fecha_nac": "2003-11-06",
        "recuperacion": 3,
        "velocidad": 3,
        "resistencia": 3,
        "dni": "18094198Y"
    }
]

         */
/* EJERCICIOS
[
        {
            "id": 1,
            "duracion": 10,
            "titulo": "Posesion",
            "descripcion": "Posesion con comodines",
            "etiquetas": "...",
            "dureza": 3,
            "materiales_necesarios": "...",
            "recursos_multimedia": "..."
        },
        {
            "id": 2,
            "duracion": 5,
            "titulo": "Rondo",
            "descripcion": "Rondo",
            "etiquetas": "...",
            "dureza": 3,
            "materiales_necesarios": "...",
            "recursos_multimedia": "..."
        }
 ]
 */