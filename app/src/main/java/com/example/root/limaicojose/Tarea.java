package com.example.root.limaicojose;

/**
 * Created by root on 12/21/17.
 */

public class Tarea {

    int codigo;
    String tarea;
    String fechaLimite;

    public Tarea(String tarea, String fechaLimite) {
        this.tarea = tarea;
        this.fechaLimite = fechaLimite;
    }

    public Tarea(int codigo, String tarea, String fechaLimite) {

        this.codigo = codigo;
        this.tarea = tarea;
        this.fechaLimite = fechaLimite;
    }

    public Tarea() {

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public String getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(String fechaLimite) {
        this.fechaLimite = fechaLimite;
    }
}
