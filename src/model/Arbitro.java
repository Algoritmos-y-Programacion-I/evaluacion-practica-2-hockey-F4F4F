package model;

public abstract class Arbitro extends Persona implements IDesplazarseEnPistaSinPalo {
    
    public Arbitro(String nombre, int edad) {
        super(nombre, edad);
    }


    @Override
    public String desplazarse() {
        return  "se desplaza en la pista como árbitro (Sin palo).";
    }
}
