package Aeropuerto;

import Mysql.CrudPasajero;
import javax.swing.JOptionPane;

public class Pasajero {
    
    private String nombre;
    private String Pasaporte;
    private String nacionalidad;

    public Pasajero(String nombrePasajero, String numeroPasaporte, String nacionalidad) {
        this.nombre = nombrePasajero;
        this.Pasaporte = numeroPasaporte;
        this.nacionalidad = nacionalidad;
    }
        
        public void registrarpasajero(){


        nombre = JOptionPane.showInputDialog ("nombre");
        Pasaporte = JOptionPane.showInputDialog("numero de pasaporte");
        nacionalidad = JOptionPane.showInputDialog("nacionalidad");
        
        CrudPasajero op = new CrudPasajero();
        op.insertarDatos(0, nombre, Pasaporte, nacionalidad);
        op.leerDatos();
        
        }



    public void registrarPasajero() {
        System.out.println("Registrando pasajero: " + nombre);
    }

    public String getNombrePasajero() {
        return nombre;
    }

    public void setNombrePasajero(String nombrePasajero) {
        this.nombre = nombrePasajero;
    }

    public String getNumeroPasaporte() {
        return Pasaporte;
    }

    public void setNumeroPasaporte(String numeroPasaporte) {
        this.Pasaporte = numeroPasaporte;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    
}


