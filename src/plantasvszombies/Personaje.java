package plantasvszombies;

/**
 *
 * @author nuria
 */
public interface Personaje {

    public static final int MAX_NIVEL_VIDA = 50;

    String getNombre();

    int getAtaque();

    int getDefensa();

    int getNivelVida();

    void setNivelVida(int n);

    boolean isVivo();

}
