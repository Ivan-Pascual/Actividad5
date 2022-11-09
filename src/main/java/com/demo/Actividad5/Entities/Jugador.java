package com.demo.Actividad5.Entities;

import java.util.Date;

public class Jugador {
    private String DNI, nombre, apellidos;
    private String fecha_nac;
    private Integer recuperacion, velocidad, resistencia;

    public Jugador(String DNI, String nombre, String apellidos, String fecha_nac, Integer recuperacion, Integer velocidad, Integer resistencia) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nac = fecha_nac;
        this.recuperacion = recuperacion;
        this.velocidad = velocidad;
        this.resistencia = resistencia;
    }

    public String getDNI() {
        return DNI;
    }


    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public Integer getResistencia() {
        return resistencia;
    }

    public Integer getVelocidad() {
        return velocidad;
    }

    public Integer getRecuperacion() {
        return recuperacion;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public void setRecuperacion(Integer recuperacion) {
        this.recuperacion = recuperacion;
    }

    public void setVelocidad(Integer velocidad) {
        this.velocidad = velocidad;
    }

    public void setResistencia(Integer resistencia) {
        this.resistencia = resistencia;
    }

    public String MostrarDNI_Nombre_Apellidos() {
        return "Jugador{" +
                "DNI='" + DNI + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "DNI='" + DNI + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fecha_nac=" + fecha_nac +
                ", resistencia=" + resistencia +
                ", velocidad=" + velocidad +
                ", recuperacion=" + recuperacion +
                '}';
    }
}

