package plantasvszombies;

/**
 *
 * @author nuria
 */
import java.util.Random;
import poo.io.IO;

public class PartidaTipo2 extends Partida {

    public PartidaTipo2(String[] tablero) {
        super(tablero);
    }

    public void jugar() {

        System.out.println("⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘");
        System.out.println("⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘ INICIO DE PARTIDA TIPO 2 ⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘");
        System.out.println("⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘ POR NURIA MIR ♡ ⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘\n");

        do {

            System.out.println("⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘  PERSONAJES EN JUEGO ⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘");

            imprimeZombisVivos();
            imprimePlantasGuerrerasVivas();

            System.out.println("⁘⁘⁘⁘⁘⁘ Selecciona tu plantita para combatir: ");
            int plant = (int) IO.readNumber();
            System.out.println("\n");

            Random rand = new Random();

            int zomb = rand.nextInt(zombis.length);

            while (plantasGuerreras[plant].isVivo() && zombis[zomb].isVivo()) {
                if (rand.nextBoolean()) {

                    System.out.println("\n｡･:*:･ﾟ★,｡･:*:･ﾟ☆ Una plantita recolectora te va a hacer un regalo: ");
                    
                    switch (rand.nextInt(3)) {
                        case 0:
                            System.out.println("\t\tEnhorabuena!! La planta " + plantasGuerreras[plant].getNombre() + " ha ganado +5 puntos de vida.");
                            plantasGuerreras[plant].setNivelVida(plantasGuerreras[plant].getNivelVida() + 5);
                            break;
                        case 1:
                            System.out.println("\t\tEnhorabuena!! La planta " + plantasGuerreras[plant].getNombre() + " ha ganado +3 puntos de ataque.");
                            plantasGuerreras[plant].ataque += 3;
                            break;
                        case 2:
                            System.out.println("\t\tEnhorabuena!! La planta " + plantasGuerreras[plant].getNombre() + " ha ganado +1 punto de defensa.");
                            plantasGuerreras[plant].defensa += 1;
                            break;
                        default:
                            System.out.println("\t\tOhhh mala suerte, no has obtenido nada (*llora*)");
                    }

                    combate(plantasRecolectoras[rand.nextInt(plantasRecolectoras.length)], zombis[zomb]);

                    System.out.println("⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘");
                    System.out.println("\n ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀  Introduce un intro para continuar");
                    IO.readLine();

                } else {

                    combate(plantasGuerreras[plant], zombis[zomb]);

                    System.out.println("⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘");

                    System.out.println("\n ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀ ❀  Introduce un intro para continuar");
                    IO.readLine();

                }

            }
        } while (plantasGuerreras_vivas > 0 && zombis_vivos > 0);

        System.out.println("⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘");
        System.out.println("⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘ FINAL DE PARTIDA ⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘");
        System.out.println("⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘\n");

        imprimeEstadoPartida();

        System.out.println("⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘");
        System.out.println("⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘ GAME OVER ⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘");
        System.out.println("⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘⁘");
    }

}
