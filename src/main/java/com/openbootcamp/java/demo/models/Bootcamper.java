package com.openbootcamp.java.demo.models;

// POJO: Plain old Java object
public class Bootcamper {

    private String nombre;
    private double valor;

    public Bootcamper() {
    }

    public Bootcamper(String nombre, double valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
