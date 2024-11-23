package Aeropuerto;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Vuelo {
    private String identificador;
    private String ciudadOrigen;
    private String ciudadDestino;
    private float precioPorAsiento;
    private int numPasajerosMaximos;
    private int numPasajerosPermitidos;
    private int numPasajerosReales;
    private List<Pasajero> pasajeros;

    public Vuelo(String identificador, String ciudadOrigen, String ciudadDestino, float precioPorAsiento, int numPasajerosMaximos, int numPasajerosPermitidos) {
        this.identificador = identificador;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.precioPorAsiento = precioPorAsiento;
        this.numPasajerosMaximos = numPasajerosMaximos;
        this.numPasajerosPermitidos = numPasajerosPermitidos;
        this.pasajeros = new ArrayList<>();
        this.numPasajerosReales = 0;
    }

    public void agregarPasajero(Pasajero pasajero) {
        if (numPasajerosReales < numPasajerosPermitidos) {
            // Asignar número de asiento automáticamente
            int numeroAsiento = numPasajerosReales + 1;  // El número de asiento es el siguiente disponible
            pasajeros.add(pasajero);
            numPasajerosReales++;

            // Imprimir la información relevante
            System.out.println("Pasajero agregado al vuelo " + identificador);
            System.out.println("Número de asiento asignado: " + numeroAsiento);
            System.out.println("Cupos restantes: " + (numPasajerosPermitidos - numPasajerosReales));
        } else {
            System.out.println("No se pueden agregar más pasajeros al vuelo " + identificador);
        }
    }

    public void consultarInformacionVuelo() {
        System.out.println("Información del vuelo " + identificador);
        System.out.println("Origen: " + ciudadOrigen);
        System.out.println("Destino: " + ciudadDestino);
        System.out.println("Precio por asiento: " + precioPorAsiento);
        System.out.println("Pasajeros actuales: " + numPasajerosReales + "/" + numPasajerosPermitidos);
        System.out.println("Cupos restantes: " + (numPasajerosPermitidos - numPasajerosReales));
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public float getPrecioPorAsiento() {
        return precioPorAsiento;
    }

    public void setPrecioPorAsiento(float precioPorAsiento) {
        this.precioPorAsiento = precioPorAsiento;
    }

    public int getNumPasajerosMaximos() {
        return numPasajerosMaximos;
    }

    public void setNumPasajerosMaximos(int numPasajerosMaximos) {
        this.numPasajerosMaximos = numPasajerosMaximos;
    }

    public int getNumPasajerosPermitidos() {
        return numPasajerosPermitidos;
    }

    public void setNumPasajerosPermitidos(int numPasajerosPermitidos) {
        this.numPasajerosPermitidos = numPasajerosPermitidos;
    }

    public int getNumPasajerosReales() {
        return numPasajerosReales;
    }

    public void setNumPasajerosReales(int numPasajerosReales) {
        this.numPasajerosReales = numPasajerosReales;
    }

    public List<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(List<Pasajero> pasajeros) {
        this.pasajeros = pasajeros;
    }
}




