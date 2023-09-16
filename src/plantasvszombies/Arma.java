package plantasvszombies;

/**
 *
 * @author nuria
 */
public class Arma {

    private int tipo;
    private int potencia;

    public final int SIN_ARMA = 0;
    public final int COROLA = 1;
    public final int PISTILO = 2;
    public final int ESTAMBRE = 3;
    public final int CALIZ = 4;

    public Arma(int tipo) {
        this.tipo = tipo;

        switch (tipo) {
            case 1:
                this.potencia = 5;
                break;
            case 2:
                this.potencia = 15;
                break;
            case 3:
                this.potencia = 20;
                break;
            case 4:
                this.potencia = 30;
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
                t = "Corola (" + this.potencia + ")";
                break;
            case 2:
                t = "Pistilo (" + this.potencia + ")";
                break;
            case 3:
                t = "Estambre (" + this.potencia + ")";
                break;
            case 4:
                t = "Caliz (" + this.potencia + ")";
                break;
            default:
                t = "Sin arma";

        }
        return t;

    }
}
