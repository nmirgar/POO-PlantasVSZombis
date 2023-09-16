package plantasvszombies;

/**
 *
 * @author nuria
 */
public class PlantaRecolectora implements Personaje {

    private int nivelVida;

    public PlantaRecolectora() {
        nivelVida = MAX_NIVEL_VIDA;
    }

    @Override
    public int getAtaque() {
        return 0;
    }

    @Override
    public int getDefensa() {
        return 0;
    }

    @Override
    public int getNivelVida() {
        return nivelVida;
    }

    @Override
    public String getNombre() {
        return "Las plantas recolectoras no tienen nombre";
    }

    @Override
    public void setNivelVida(int n) {
        if (this.nivelVida > MAX_NIVEL_VIDA) {
            this.nivelVida = MAX_NIVEL_VIDA;
        } else if (this.nivelVida <= 0) {
            this.nivelVida = 0;
        } else {
            this.nivelVida = n;
        }
    }

    @Override
    public boolean isVivo() {
        if (this.nivelVida > 0) {
            return true;
        } else {
            return false;
        }
    }
}
