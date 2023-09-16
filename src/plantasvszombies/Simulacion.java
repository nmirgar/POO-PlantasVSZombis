package plantasvszombies;

/**
 *
 * @author nuria
 */
import poo.io.IO;

public class Simulacion {

    public static void main(String[] args) {

        String[] disposicionTablero = {
            "Plantas:2",
            "Zombis:3",
            "Recolectores:6",
            "P;Repetidora;10;7;1",
            "Z;Zombistein;15;20;PolimÃ³rfico;1",
            "P;Iris;28;21;3",
            "Z;Zombot;18;25;Influenza;1",
            "Z;Zombidito;21;8;Adenovirus;0",};

        System.out.println("**** Introduce 1 para PartidaTipo1 ");
        System.out.println("**** Introduce 2 para partidaTipo2 ");
        
        switch ((int) IO.readNumber()) {
            case 1:
                PartidaTipo1 p = new PartidaTipo1(disposicionTablero);
                p.jugar();
                break;

            case 2:
                PartidaTipo2 n = new PartidaTipo2(disposicionTablero);
                n.jugar();
                break;

            default:
                System.out.println("**** Debe introducir 1 o 2.");
                break;
        }
    }
}
