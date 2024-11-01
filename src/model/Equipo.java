package model;

public class Equipo {
    private String nombre;
    private JugadorHockey[] jugadores;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.jugadores = new JugadorHockey[6];
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarJugador(JugadorHockey jugador) {
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i] == null) {
                jugadores[i] = jugador;
                return;
            }
        }
        System.out.println("No se pueden agregar más jugadores a este equipo.");
    }

    public JugadorHockey[] getJugadores() {
        return jugadores;
    }
}
