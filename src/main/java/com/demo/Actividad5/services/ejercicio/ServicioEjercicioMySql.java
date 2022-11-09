package com.demo.Actividad5.services.ejercicio;

import com.demo.Actividad5.Entities.Ejercicio;
import com.demo.Actividad5.Entities.Jugador;
import com.demo.Actividad5.Mysql.DBMySQLConnection;
import org.json.simple.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicioEjercicioMySql implements ServicioEjercicio{
List<Ejercicio> ejercicios = new ArrayList<>();
    @Override
    public List<JSONObject> MostrarIDyTITULO() {
        List<JSONObject> ejerciciosPersonalizados = new ArrayList<>();
        try {
            ResultSet rs = DBMySQLConnection.getConnection().createStatement().executeQuery("select id, titulo FROM ejercicios");
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                Ejercicio ejercicio = new Ejercicio(id,null,titulo,null,null,null,null,null);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id",ejercicio.getId());
                jsonObject.put("titulo", ejercicio.getTitulo());
                ejerciciosPersonalizados.add(jsonObject);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return ejerciciosPersonalizados;
    }


    @Override
    public Ejercicio MostrarTODO_DE_UN_EJERCICIO(Integer id) {
        try {
            ResultSet rs = DBMySQLConnection.getConnection().createStatement().executeQuery("select titulo, descripcion, duracion, etiquetas, dureza, materiales_necesarios, recursos_multimedia FROM ejercicios WHERE id= " + id);
            while (rs.next()) {
                String titulo = rs.getString("titulo");
                String descripcion = rs.getString("descripcion");
                String etiquetas = rs.getString("etiquetas");
                String materiales_necesarios = rs.getString("materiales_necesarios");
                String recursos_multimedia = rs.getString("recursos_multimedia");
                Integer duracion = rs.getInt("duracion");
                Integer dureza = rs.getInt("dureza");
                Ejercicio ejercicio = new Ejercicio(id, duracion,titulo,descripcion,etiquetas,dureza,materiales_necesarios,recursos_multimedia);
                ejercicios.add(ejercicio);
                return ejercicio;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }


    @Override
    public Ejercicio AñadirEjercicio(Ejercicio ejercicio) {
        try {
            String sql = "INSERT INTO ejercicios (id,duracion,titulo,descripcion,etiquetas,dureza,materiales_necesarios,recursos_multimedia) VALUES ('"
                    + ejercicio.getId() + "','" + ejercicio.getDuracion() + "','" + ejercicio.getTitulo() + "','" + ejercicio.getDescripcion()
                    + "','" + ejercicio.getEtiquetas() + "','" + ejercicio.getDureza() + "','" + ejercicio.getMateriales_necesarios() + "', '" + ejercicio.getRecursos_multimedia() + "')";
            DBMySQLConnection.getConnection().createStatement().execute(sql);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return ejercicio;
    }
}
