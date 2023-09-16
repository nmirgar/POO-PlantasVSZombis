package plantasvszombies;

/**
 *
 * @author nuria
 */
public class Planta extends Guerrero {

    private Arma arma;

    public Planta(String nombre, int ataque, int defensa, Arma arma) {

        super(nombre, ataque, defensa);
        this.arma = arma;

    }

    @Override
    public String toString() {
        String t = "Planta ";
        t += super.toString();
        t += "\n\t Arma: " + this.arma;

        return t;
    }

    public Arma getArma() {
        return this.arma;
    }

}
