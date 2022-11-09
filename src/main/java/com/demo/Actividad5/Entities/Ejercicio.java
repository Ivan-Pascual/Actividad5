package com.demo.Actividad5.Entities;

import java.util.Arrays;

public class Ejercicio {
    private Integer id, duracion;
    private String titulo, descripcion;
    private String etiquetas;
    private Integer dureza;
    private String  materiales_necesarios;
    private String  recursos_multimedia;

    public Ejercicio(Integer id, Integer duracion, String titulo, String descripcion, String etiquetas, Integer dureza, String materiales_necesarios, String recursos_multimedia) {
        this.id = id;
        this.duracion = duracion;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.etiquetas = etiquetas;
        this.dureza = dureza;
        this.materiales_necesarios = materiales_necesarios;
        this.recursos_multimedia = recursos_multimedia;
    }

    public Integer getId() {
        return id;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEtiquetas() {
        return etiquetas;
    }

    public Integer getDureza() {
        return dureza;
    }

    public String getMateriales_necesarios() {
        return materiales_necesarios;
    }

    public String getRecursos_multimedia() {
        return recursos_multimedia;
    }

    @Override
    public String toString() {
        return "Ejericico{" +
                "id=" + id +
                ", duracion=" + duracion +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", etiquetas=" + (etiquetas) +
                ", dureza=" + dureza +
                ", materiales_necesarios=" + (materiales_necesarios) +
                ", recursos_multimedia=" + (recursos_multimedia) +
                '}';
    }
}
