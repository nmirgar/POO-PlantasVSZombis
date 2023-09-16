package plantasvszombies;

/**
 *
 * @author nuria
 */
public class Zombi extends Guerrero {

    private String infeccion;
    private Habilidad habilidad;

    public Zombi(String nombre, int ataque, int defensa, String infeccion, Habilidad habilidad) {
        super(nombre, ataque, defensa);
        this.infeccion = infeccion;
        this.habilidad = habilidad;

    }

    @Override
    public String toString() {

        String t = "Zombi ";
        t += super.toString();
        t += "\n\t Infeccion: " + this.infeccion;
        t += "\n\t Habilidad: " + this.habilidad;

        return t;
    }

    public String getInfeccion() {
        return this.infeccion;
    }

    public Habilidad getHabilidad() {
        return this.habilidad;
    }

}
