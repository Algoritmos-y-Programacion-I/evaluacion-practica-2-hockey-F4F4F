package model;

import java.util.Random;

public class Controller {

    private Equipo[] equipos;
    private Arbitro[] arbitros;
    private JuezDeLinea[] jueces;
    private final int CANTIDAD_EQUIPOS = 4;
    private final int CANTIDAD_ARBITROS = 4;


    private int contadorEquipos = 0;

    /**
     * Constructor de la clase Controller para inicializar variables globales.
     *
     * @pre No se requieren precondiciones específicas.
     * @post Se crea una instancia de Controller con un arreglo de personas vacío.
     */
    public Controller() {
        equipos = new Equipo[CANTIDAD_EQUIPOS];
        arbitros = new Arbitro[CANTIDAD_ARBITROS];
    }

    public String fixture() {
        String fixture = "";
        Random random = new Random();
        int equipo1 = random.nextInt(4);
        int equipo2;
        do {
            equipo2 = random.nextInt(4);
        } while (equipo2 == equipo1);

        fixture += "Partido 1: Equipo " + equipo1 + " vs Equipo " + equipo2;
        fixture += "\n";

        do {
            equipo1 = random.nextInt(4);
            equipo2 = random.nextInt(4);
        } while (equipo2 == equipo1);

        fixture += "Partido 2: Equipo " + equipo1 + " vs Equipo " + equipo2;
        return fixture;
    }
   
    public void ejecutarSimulacion() {
        testObjects();
        simularPartido();
    }
    


    public void simularPartido() {
        Equipo equipo1 = equipos[0]; 
        Equipo equipo2 = equipos[1]; 
    
        System.out.println("Simulando partido");
    
        simularAtaque(equipo1);
        simularAtaque(equipo2);
    }
    
    private void simularAtaque(Equipo equipo) {
        int numeroDePases = 0; 
        JugadorHockey ultimoPasador = null;
    
        System.out.println("inica el ataque");
    
        while (numeroDePases < 4) { 
            JugadorHockey jugadorActual = equipo.getJugadores()[numeroDePases % equipo.getJugadores().length];
            
            if (ultimoPasador != null) {
                System.out.println( ultimoPasador.getNombre() + " se la pasa  " + jugadorActual.getNombre());
            } else {
                System.out.println( jugadorActual.getNombre() + " inicia el ataque");
            }
            
            desplazarArbitros(numeroDePases); 
    
            ultimoPasador = jugadorActual; 
            numeroDePases++; 
        }
    
        System.out.println( ultimoPasador.getNombre() + " entra el disco gol");
    }
    
    private void desplazarArbitros(int numeroDePases) {
        Arbitro arbitroPrincipal = null;
        JuezDeLinea juezDeLinea = null;
    
        for (Arbitro arbitro : arbitros) {
            if (arbitro instanceof ArbitroPrincipal) {
                arbitroPrincipal = arbitro;
            } else if (arbitro instanceof JuezDeLinea) {
                juezDeLinea = (JuezDeLinea) arbitro;
            }
        }
    
        if (numeroDePases % 2 == 0) {
            System.out.println(arbitroPrincipal.getNombre() + " se desplaza sobre el hielo");
        } else {
            System.out.println(juezDeLinea.getNombre() + " se desplaza sobre el hielo");
        }
    }
    
    
    
    public void testObjects() {
        Equipo icesi = new Equipo("Icesi");
        equipos[0] = icesi;

        Equipo marcosTeam = new Equipo("MarcosTeam");
        equipos[1] = marcosTeam;

        icesi.agregarJugador(new JugadorHockey("Jugador 1", 30, Posicion.PORTERO));
        icesi.agregarJugador(new JugadorHockey("Jugador 2", 30, Posicion.ALA));
        icesi.agregarJugador(new JugadorHockey("Jugador 3", 30, Posicion.CENTRO));
        icesi.agregarJugador(new JugadorHockey("Jugador 4", 30, Posicion.ALA));
        icesi.agregarJugador(new JugadorHockey("Jugador 5", 30, Posicion.DEFENSA));
        icesi.agregarJugador(new JugadorHockey("Jugador 6", 30, Posicion.DEFENSA));

        marcosTeam.agregarJugador(new JugadorHockey("Jugador 7", 30, Posicion.PORTERO));
        marcosTeam.agregarJugador(new JugadorHockey("Jugador 8", 30, Posicion.CENTRO));
        marcosTeam.agregarJugador(new JugadorHockey("Jugador 9", 30, Posicion.ALA));
        marcosTeam.agregarJugador(new JugadorHockey("Jugador 10", 30, Posicion.ALA));
        marcosTeam.agregarJugador(new JugadorHockey("Jugador 11", 30, Posicion.DEFENSA));
        marcosTeam.agregarJugador(new JugadorHockey("Jugador 12", 30, Posicion.DEFENSA));

        arbitros[0] = new ArbitroPrincipal("sambelococo", 20);
        arbitros[1] = new ArbitroPrincipal("Perengoneco", 20);
        arbitros[2] = new JuezDeLinea("camilo", 30);
        arbitros[3] = new JuezDeLinea("Yeis", 80);
    }
}



