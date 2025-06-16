/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.taskmgr.domain.entidades;

/**
 *
 * @author REY
 */
public class Empleado {
     private int codigoEmpleado;
    private String nombre;
    private String cedula;
    private int areaId;

    public Empleado() {
    }

    public Empleado(int codigoEmpleado, String nombre, String cedula, int areaId) {
        this.codigoEmpleado = codigoEmpleado;
        this.nombre = nombre;
        this.cedula = cedula;
        this.areaId = areaId;
    }

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }
    
    
    
}
