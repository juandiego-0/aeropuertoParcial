package Aeropuerto;

import java.util.List;

public class CompaniasDeVuelo {
    private String nombreComp;
    private List<Vuelo> vuelos;

    public CompaniasDeVuelo(String nombreComp, List<Vuelo> vuelos) {
        this.nombreComp = nombreComp;
        this.vuelos = vuelos;
    }

    public void listarVuelos() {
        System.out.println("Listando vuelos de la compañía " + nombreComp);
        for (Vuelo vuelo : vuelos) {
            vuelo.consultarInformacionVuelo();
        }
    }

    public String getNombreComp() {
        return nombreComp;
    }

    public void setNombreComp(String nombreComp) {
        this.nombreComp = nombreComp;
    }

    public List<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(List<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }

    
}

