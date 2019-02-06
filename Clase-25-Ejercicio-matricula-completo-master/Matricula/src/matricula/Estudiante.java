/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matricula;

import java.util.ArrayList;

/**
 *
 * @author chalosalvador
 */
public class Estudiante {
    
    private String nombre;
    private String apellido;
    private int Edad;
    private ArrayList<Materia> materias;

    public Estudiante(String nombre, String apellido, int Edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.Edad = Edad;
        this.materias = new ArrayList<>();
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    
    
    @Override
    public String toString() {
        return nombre + " " + apellido;
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(ArrayList<Materia> materias) {
        this.materias = materias;
    }
    
    
    
    
}
