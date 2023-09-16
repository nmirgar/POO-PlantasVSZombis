package plantasvszombies;

/**
 *
 * @author nuria
 */
public class Guerrero implements Personaje {

    protected String nombre;
    protected int ataque;

    public final int MAX_ATAQUE = 100;
    public final int MAX_DEFENSA = 100;

    protected int defensa;
    protected int nivelVida;

    public Guerrero(String nombre, int ataque, int defensa) {
        nivelVida = MAX_NIVEL_VIDA;
        this.nombre = nombre;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    @Override
    public int getDefensa() {
        return this.defensa;
    }

    @Override
    public int getAtaque() {
        return this.ataque;
    }

    @Override
    public int getNivelVida() {
        return this.nivelVida;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    private void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    private void setDefensa(int defensa) {
        this.defensa = defensa;
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

    @Override
    public String toString() {
        if (isVivo()) {
            String f = this.nombre;
            f += "\n\t Nivel de ataque: " + this.ataque;
            f += "\n\t Nivel de defensa: " + this.defensa;
            f += "\n\t Nivel de vida: " + this.nivelVida;
            return f;

        } else {
            String f = this.nombre + " esta muerto";
            return f;
        }
    }
}
