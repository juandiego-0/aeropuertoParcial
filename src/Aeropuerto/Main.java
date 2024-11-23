package Aeropuerto;
import Mysql.CrudVuelos;
import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.util.ArrayList;
import java.util.List;
import Mysql.CrudPasajero;
public class Main {

    public static void main(String[] args) {
        
        CrudPasajero op = new CrudPasajero();
        op.leerDatos();
   
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        // Crear vuelos públicos
        Vuelo vuelo1 = new Vuelo("A123", "Bogotá", "Medellín", 150.0f, 100, 80);
        Vuelo vuelo2 = new Vuelo("B901", "Cali", "Barranquilla", 100.0f, 120, 100);

        List<Vuelo> vuelosPublicos1 = new ArrayList<>();
        vuelosPublicos1.add(vuelo1);

        List<Vuelo> vuelosPublicos2 = new ArrayList<>();
        vuelosPublicos2.add(vuelo2);

        AeropuertoPublico aeropuertoPublico1 = new AeropuertoPublico
        ("Aeropuerto El Dorado", "Bogotá", "Colombia", vuelosPublicos1, 500000.0f);
        AeropuertoPublico aeropuertoPublico2 = new AeropuertoPublico
        ("Aeropuerto José María Córdova", "Medellín", "Colombia", vuelosPublicos2,
            600000.0f);

        List<AeropuertoPublico> aeropuertosPublicos = List.of(aeropuertoPublico1,
                aeropuertoPublico2);

        // Crear vuelos privados
        Vuelo vueloPrivado1 = new Vuelo("P456", "Bogotá", "Cartagena", 300.0f, 50,
            30);
        Vuelo vueloPrivado2 = new Vuelo("P789", "Medellín", "Santa Marta", 400.0f,
           60, 40);

        List<Vuelo> vuelosPrivados1 = new ArrayList<>();
        vuelosPrivados1.add(vueloPrivado1);

        List<Vuelo> vuelosPrivados2 = new ArrayList<>();
        vuelosPrivados2.add(vueloPrivado2);

        List<String> empresasPrivadas1 = List.of("Avianca", "Coca-Cola");
        List<String> empresasPrivadas2 = List.of("Samsung", "LG");

        AeropuertoPrivado aeropuertoPrivado1 = new AeropuertoPrivado
        ("Aeropuerto Guaymaral", "Bogotá", "Colombia", vuelosPrivados1,
                empresasPrivadas1);
        AeropuertoPrivado aeropuertoPrivado2 = new AeropuertoPrivado
        ("Aeropuerto Olaya Herrera", "Medellín", "Colombia", vuelosPrivados2,
                empresasPrivadas2);

        List<AeropuertoPrivado> aeropuertosPrivados = List.of(aeropuertoPrivado1,
                aeropuertoPrivado2);

        // Menú principal
        while (true) {
            String[] opcionesMenu = {"Aeropuertos Públicos",
                "Aeropuertos Privados", "Salir"};
            int opcion = JOptionPane.showOptionDialog(null, 
                    "Bienvenido al sistema de gestión de aeropuertos. "
                            + "Seleccione una opción:",
                    "Menú Principal", JOptionPane.DEFAULT_OPTION, 
                    JOptionPane.INFORMATION_MESSAGE,
                    null, opcionesMenu, opcionesMenu[0]);

            if (opcion == 2 || opcion == -1) {
                JOptionPane.showMessageDialog(null, 
                        "Gracias por usar el sistema.");
                break;
            }

            if (opcion == 0) {
                mostrarMenuAeropuertosPublicos(aeropuertosPublicos);
            } else if (opcion == 1) {
                mostrarMenuAeropuertosPrivados(aeropuertosPrivados);
            }
        }
    }

    // Menú de Aeropuertos Públicos
    private static void mostrarMenuAeropuertosPublicos
        (List<AeropuertoPublico> aeropuertosPublicos) {
        while (true) {
            String[] opcionesSubMenu = {"Aeropuertos",
                "Aporte Gubernamental", "Volver"};
            int opcionSubMenu = JOptionPane.showOptionDialog
                (null, "Seleccione una opción:",
                    "Aeropuertos Públicos", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null, opcionesSubMenu, opcionesSubMenu[0]);

            if (opcionSubMenu == 2 || opcionSubMenu == -1) {
                break;
            }

            switch (opcionSubMenu) {
                case 0: // Mostrar aeropuertos y gestionar vuelos
                    mostrarListaAeropuertosPublicos(aeropuertosPublicos);
                    break;
                case 1: // Mostrar aportes gubernamentales
                    mostrarAportesGubernamentales(aeropuertosPublicos);
                    break;
            }
        }
    }

    // Menú de Aeropuertos Privados
    private static void mostrarMenuAeropuertosPrivados(List<AeropuertoPrivado> 
            aeropuertosPrivados) {
        while (true) {
            String[] opcionesSubMenu = {"Aeropuertos", "Compañías Patrocinadoras", 
                "Volver"};
            int opcionSubMenu = JOptionPane.showOptionDialog
                    (null, "Seleccione una opción:",
                    "Aeropuertos Privados", JOptionPane.DEFAULT_OPTION, 
                    JOptionPane.INFORMATION_MESSAGE,
                    null, opcionesSubMenu, opcionesSubMenu[0]);

            if (opcionSubMenu == 2 || opcionSubMenu == -1) {
                break;
            }

            switch (opcionSubMenu) {
                case 0: // Mostrar aeropuertos y gestionar vuelos
                    mostrarListaAeropuertosPrivados(aeropuertosPrivados);
                    break;
                case 1: // Mostrar compañías patrocinadoras
                    mostrarCompaniasPatrocinadoras(aeropuertosPrivados);
                    break;
            }
        }
    }

    // Mostrar lista de aeropuertos públicos
    private static void mostrarListaAeropuertosPublicos(List<AeropuertoPublico>
            aeropuertosPublicos) {
        String[] opcionesAeropuertos = new String[aeropuertosPublicos.size()];
        for (int i = 0; i < aeropuertosPublicos.size(); i++) {
            opcionesAeropuertos[i] = aeropuertosPublicos.get(i).getNombre();
        }

        int aeropuertoSeleccionadoIndex = JOptionPane.showOptionDialog
        (null, "Seleccione un aeropuerto público:",
                "Aeropuertos Públicos", JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE,
                null, opcionesAeropuertos, opcionesAeropuertos[0]);

        if (aeropuertoSeleccionadoIndex != -1) {
            AeropuertoPublico aeropuertoSeleccionado = aeropuertosPublicos.get
        (aeropuertoSeleccionadoIndex);
            gestionarVuelos(aeropuertoSeleccionado.getVuelos(), aeropuertoSeleccionado);
        }
    }

    // Mostrar lista de aeropuertos privados
    private static void mostrarListaAeropuertosPrivados(List<AeropuertoPrivado> 
            aeropuertosPrivados) {
        String[] opcionesAeropuertos = new String[aeropuertosPrivados.size()];
        for (int i = 0; i < aeropuertosPrivados.size(); i++) {
            opcionesAeropuertos[i] = aeropuertosPrivados.get(i).getNombre();
        }

        int aeropuertoSeleccionadoIndex = JOptionPane.showOptionDialog
        (null, "Seleccione un aeropuerto privado:",
                "Aeropuertos Privados", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null, opcionesAeropuertos, opcionesAeropuertos[0]);

        if (aeropuertoSeleccionadoIndex != -1) {
            AeropuertoPrivado aeropuertoSeleccionado = aeropuertosPrivados.get
        (aeropuertoSeleccionadoIndex);
            gestionarVuelos(aeropuertoSeleccionado.getVuelos(), aeropuertoSeleccionado);
        }
    }

    // Mostrar aportes gubernamentales
    private static void mostrarAportesGubernamentales(List<AeropuertoPublico> 
            aeropuertosPublicos) {
        StringBuilder aportes = new StringBuilder("Aportes Gubernamentales:\n");
        for (AeropuertoPublico aeropuerto : aeropuertosPublicos) {
            aportes.append(aeropuerto.getNombre()).append(": $").append(aeropuerto.
                    getAporteGubernamental()).append("\n");
        }
        JOptionPane.showMessageDialog(null, aportes.toString(), 
                "Aportes Gubernamentales", JOptionPane.INFORMATION_MESSAGE);
    }

    // Mostrar compañías patrocinadoras
    private static void mostrarCompaniasPatrocinadoras(List<AeropuertoPrivado>
            aeropuertosPrivados) {
        StringBuilder patrocinadoras = new StringBuilder("Compañías Patrocinadoras:\n");
        for (AeropuertoPrivado aeropuerto : aeropuertosPrivados) {
            patrocinadoras.append(aeropuerto.getNombre()).append(": ").
             append(String.join(", ", aeropuerto.getEmpresasPatrocinadoras())).append("\n");
        }
        JOptionPane.showMessageDialog(null, patrocinadoras.toString(),
                "Compañías Patrocinadoras", JOptionPane.INFORMATION_MESSAGE);
    }

    // Gestionar vuelos
    private static void gestionarVuelos(List<Vuelo> vuelosDisponibles, 
            Aeropuerto aeropuertoSeleccionado) {
        if (vuelosDisponibles == null || vuelosDisponibles.isEmpty()) {
            JOptionPane.showMessageDialog
                (null, "No hay vuelos disponibles para este aeropuerto.",
                    "Vuelos No Disponibles", JOptionPane.WARNING_MESSAGE);
            return;
        }

        StringBuilder vuelosMenu = new StringBuilder
        ("Vuelos disponibles para el aeropuerto " + aeropuertoSeleccionado.
                getNombre() + ":\n");
        for (int i = 0; i < vuelosDisponibles.size(); i++) {
            Vuelo vuelo = vuelosDisponibles.get(i);
            vuelosMenu.append((i + 1)).append(". Vuelo ").append(vuelo.getIdentificador())
                    .append(" - Sale de: ").append(vuelo.getCiudadOrigen())
                    .append(" - Destino: ").append(vuelo.getCiudadDestino())
                    .append(" - Precio: $").append(vuelo.getPrecioPorAsiento()).append("\n");
        }

        JOptionPane.showMessageDialog(null, vuelosMenu.toString(), 
              "Vuelos Disponibles", JOptionPane.INFORMATION_MESSAGE);

        String nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
        String numeroPasaporte = JOptionPane.showInputDialog("Ingrese su número de pasaporte:");
        String nacionalidad = JOptionPane.showInputDialog("Ingrese su nacionalidad:");

        String[] opcionesVuelos = new String[vuelosDisponibles.size()];
        for (int i = 0; i < vuelosDisponibles.size(); i++) {
            Vuelo vuelo = vuelosDisponibles.get(i);
            opcionesVuelos[i] = vuelo.getIdentificador() + " - " +
               vuelo.getCiudadOrigen() + " a " + vuelo.getCiudadDestino();
        }

        int vueloSeleccionadoIndex = JOptionPane.showOptionDialog(null, "Seleccione un vuelo:",
                "Selección de Vuelo", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, opcionesVuelos, opcionesVuelos[0]);

        if (vueloSeleccionadoIndex != -1) {
            Vuelo vueloSeleccionado = vuelosDisponibles.get(vueloSeleccionadoIndex);
            Pasajero pasajero = new Pasajero(nombre, numeroPasaporte, nacionalidad);
            vueloSeleccionado.agregarPasajero(pasajero);

            int numeroAsiento = vueloSeleccionado.getPasajeros().indexOf(pasajero) + 1;

            float montoIngresado;
            while (true) {
                float precioVuelo = vueloSeleccionado.getPrecioPorAsiento();
                montoIngresado = Float.parseFloat(JOptionPane.showInputDialog
                    ("El precio del vuelo es: $" + precioVuelo + 
                            "\nIngrese el monto a pagar:"));

                if (montoIngresado >= precioVuelo) {
                    float excedente = montoIngresado - precioVuelo;
                    String mensajePago = "Pago exitoso. ";
                    if (excedente > 0) {
                        mensajePago += "Su cambio es: $" + excedente;
                    } else {
                        mensajePago += "No tiene cambio.";
                    }
                    JOptionPane.showMessageDialog(null, mensajePago + 
                            "\nReservación completada para el vuelo " +
                                    vueloSeleccionado.getIdentificador() + 
                            " hacia " + vueloSeleccionado.getCiudadDestino() +
                                    ". Número de asiento asignado: " + numeroAsiento +
                                    ". Cupos restantes: " + 
                            (vueloSeleccionado.getNumPasajerosMaximos() - 
                             vueloSeleccionado.getNumPasajerosReales()),
                            "Confirmación de Reserva", JOptionPane.INFORMATION_MESSAGE);
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Monto insuficiente. Intente de nuevo.");
                }
            }
        }
    }
}




