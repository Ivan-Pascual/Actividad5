package com.demo.Actividad5.services.jugador;

import com.demo.Actividad5.Entities.Jugador;
import com.demo.Actividad5.Mysql.DBMySQLConnection;
import com.demo.Actividad5.services.jugador.ServicioJugador;
import org.json.simple.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicioJugadorMySql implements ServicioJugador {
    List<Jugador> jugadores = new ArrayList<>();

    @Override
    public List<JSONObject> MostrarDNI_NOMBRE_APELLIDOS() {
        List<JSONObject> jugadoresPersonalizados = new ArrayList<>();
        try {
            ResultSet rs = DBMySQLConnection.getConnection().createStatement().executeQuery("select DNI, nombre, apellidos FROM jugadores");
            while (rs.next()) {
                String DNI = rs.getString("DNI");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                Jugador jugador = new Jugador(DNI, nombre, apellidos, null, null,null,null);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("DNI",jugador.getDNI());
                jsonObject.put("nombre", jugador.getNombre());
                jsonObject.put("apellidos",jugador.getApellidos());
                jugadoresPersonalizados.add(jsonObject);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return jugadoresPersonalizados;
    }


    @Override
    public Jugador MostrarTODO(String id) {
        Jugador jugador = null;
        try {
            ResultSet rs = DBMySQLConnection.getConnection().createStatement().executeQuery("select DNI, nombre, apellidos, Fecha, resistencia, velocidad, recuperacion FROM jugadores WHERE DNI = " + id);
            while (rs.next()) {
                String DNI = rs.getString("DNI");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String fecha = rs.getString("Fecha");
                Integer resistencia = rs.getInt("resistencia");
                Integer velocidad = rs.getInt("velocidad");
                Integer recuperacion = rs.getInt("recuperacion");
                jugador = new Jugador(DNI, nombre, apellidos, fecha, resistencia, velocidad, recuperacion);
                jugadores.add(jugador);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return jugador;
    }




    @Override
    public Jugador AñadirJugador(Jugador jugador) {
        try {
            String sql = "INSERT INTO jugadores (DNI, nombre, apellidos, Fecha, resistencia, velocidad, recuperacion) VALUES ('"
                    + jugador.getDNI() + "','" + jugador.getNombre() + "','" + jugador.getApellidos() + "','" + jugador.getFecha_nac()
                    + "','" + jugador.getResistencia() + "','" + jugador.getVelocidad() + "','" + jugador.getRecuperacion() + "')";
            DBMySQLConnection.getConnection().createStatement().execute(sql);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return jugador;
    }

    @Override
    public Jugador CambiarJugador(String id, Jugador jugador) {
        try {
            String sql = "UPDATE jugadores SET nombre= '"+jugador.getNombre()+"', apellidos= '"+jugador.getApellidos()+"' , Fecha= '"+jugador.getFecha_nac()+"'" +
                    ", resistencia= '"+jugador.getResistencia()+"', velocidad= '"+jugador.getVelocidad()+"', recuperacion= '"+jugador.getRecuperacion()+"' WHERE DNI="+id;
            System.out.println(sql);
            DBMySQLConnection.getConnection().createStatement().execute(sql);
        }
        catch (Exception e){
            System.err.println(e);
        }

        return jugador;
    }
}
