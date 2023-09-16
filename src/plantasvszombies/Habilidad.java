package plantasvszombies;

/**
 *
 * @author nuria
 */
public class Habilidad {

    private int tipo;
    private int potencia;

    public final int SIN_HABILIDAD = 0;
    public final int SALTARIN = 1;
    public final int ESQUIVADOR = 2;
    public final int HIPNOTIZADOR = 3;

    public Habilidad(int tipo) {
        this.tipo = tipo;

        switch (tipo) {
            case 1:
                this.potencia = 10;
                break;
            case 2:
                this.potencia = 25;
                break;
            case 3:
                this.potencia = 40;
                break;
            default:
                this.potencia = 0;

        }
    }

    public int getTipo() {
        return this.tipo;
    }

    public int getPotencia() {
        return this.potencia;
    }

    @Override
    public String toString() {
        String t;

        switch (this.tipo) {
            case 1:
                t = "Saltarin (" + this.potencia + ")";
                break;
            case 2:
                t = "Esquivador (" + this.potencia + ")";
                break;
            case 3:
                t = "Hipnotizador (" + this.potencia + ")";
                break;
            default:
                t = "Sin Habilidad";

        }
        return t;

    }
}
