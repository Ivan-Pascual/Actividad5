package com.demo.Actividad5.Entities;

import java.util.ArrayList;
import java.util.List;

public class Entrenamiento {
    private Integer id;
    private String fecha;
    private List<Jugador> jugadores;
    private List<Ejercicio> ejercicios;
    public Entrenamiento(Integer id, String fecha) {
        this.id = id;
        this.fecha = fecha;
        this.ejercicios = new ArrayList<>();
        this.jugadores = new ArrayList<>();
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    public Integer getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }

    @Override
    public String toString() {
        return "Entrenamiento{" +
                "id=" + id +
                ", fecha=" + fecha +
                '}';
    }
}
