package plantasvszombies;

/**
 *
 * @author nuria
 */
public abstract class Partida {

    protected Planta plantasGuerreras[];
    protected Zombi zombis[];
    protected PlantaRecolectora plantasRecolectoras[];

    protected int plantasGuerreras_vivas;
    protected int zombis_vivos;
    protected int plantasRecolectoras_vivas;

    protected int num_combates;

    public Partida(String disposicionTablero[]) {

        num_combates = 0;

        plantasGuerreras_vivas = Integer.parseInt(disposicionTablero[0].substring(disposicionTablero[0].indexOf(':') + 1));
        zombis_vivos = Integer.parseInt(disposicionTablero[1].substring(disposicionTablero[1].indexOf(':') + 1));
        plantasRecolectoras_vivas = Integer.parseInt(disposicionTablero[2].substring(disposicionTablero[2].indexOf(':') + 1));

        plantasRecolectoras = new PlantaRecolectora[plantasRecolectoras_vivas];

        for (int i = 0; i < plantasRecolectoras.length; i++) {
            plantasRecolectoras[i] = new PlantaRecolectora();
        }

        plantasGuerreras = new Planta[plantasGuerreras_vivas];
        zombis = new Zombi[zombis_vivos];

        int planta_insertada = 0;
        int zombi_insertado = 0;

        for (int i = 3; i < disposicionTablero.length; i++) {

            if (disposicionTablero[i].charAt(0) == 'P') {

                Guerrero g = trataLinea(disposicionTablero[i]);
                plantasGuerreras[planta_insertada] = (Planta) g;
                planta_insertada++;

            } else {

                Guerrero g = trataLinea(disposicionTablero[i]);
                zombis[zombi_insertado] = (Zombi) g;
                zombi_insertado++;
            }
        }
    }

    private Guerrero trataLinea(String l) {

        String parts[] = l.split(";");

        Guerrero g;

        if (parts[0].equals("P")) {

            String nombre = parts[1];
            int ataque = Integer.parseInt(parts[2]);
            int defensa = Integer.parseInt(parts[3]);
            Arma a = new Arma(Integer.parseInt(parts[4]));

            g = new Planta(nombre, ataque, defensa, a);

        } else if (parts[0].equals("Z")) {
            String nombre = parts[1];
            int ataque = Integer.parseInt(parts[2]);
            int defensa = Integer.parseInt(parts[3]);
            String infeccion = parts[4];
            Habilidad h = new Habilidad(Integer.parseInt(parts[5]));

            g = new Zombi(nombre, ataque, defensa, infeccion, h);

        } else {
            g = null;
        }

        return g;
    }

    public void imprimeEstadoPartida() {

        String s = "******** ESTADO GLOBAL DE LA PARTIDA ********\n";
        s += "\n - PLANTAS GUERRERAS:";
        s += "\n\t - Numero inicial de planta de tipo guerrera: " + plantasGuerreras.length;
        s += "\n\t - Numero planta de tipo guerrera vivas: " + this.plantasGuerreras_vivas;
        s += "\n\t - Numero de planta de tipo guerrera muertas: " + (plantasGuerreras.length - this.plantasGuerreras_vivas);

        s += "\n - ZOMBIS:";
        s += "\n\t - Numero inicial de zombis: " + zombis.length;
        s += "\n\t - Numero de Zombis vivos: " + this.zombis_vivos;
        s += "\n\t - Numero de Zombis muertos: " + (zombis.length - this.zombis_vivos);

        s += "\n - RECOLECTORAS:";
        s += "\n\t - Numero inicial de planta de tipo recolectoras: " + plantasRecolectoras.length;
        s += "\n\t - Numero de planta de tipo planta recolectora viva: " + plantasRecolectoras_vivas;
        s += "\n\t - Numero de planta de tipo planta recolectora muertas: " + (plantasRecolectoras.length - plantasRecolectoras_vivas);

        if ((plantasGuerreras_vivas) < (zombis_vivos)) {
            s += "\n\n --> PARTIDA EN JUEGO: Los Zombis van ganando";
        } else {
            s += "\n\n --> PARTIDA EN JUEGO: Las Plantas van ganando";
        }

        s += "\n --> Combates hasta el momento: " + num_combates + "\n";

        System.out.println(s);
    }

    protected int combate(Personaje p1, Personaje p2) {
        int resultadocombate = 0;

        if (p1.getClass().equals(p2.getClass()) && !p1.getClass().equals(Zombi.class)) {
            resultadocombate = -1;
        }
        if (!p1.isVivo() || !p2.isVivo()) {
            resultadocombate = -1;
        }

        if (resultadocombate != -1) {

            int p1_ataqueTotal;
            int p1_defensa;

            if (p1.getClass().equals(PlantaRecolectora.class)) {
                p1_ataqueTotal = p1.getAtaque();

            } else if (p1.getClass().equals(Planta.class)) {
                p1_ataqueTotal = p1.getAtaque() + ((Planta) p1).getArma().getPotencia();

            } else {
                p1_ataqueTotal = p1.getAtaque() + ((Zombi) p1).getHabilidad().getPotencia();

            }
            p1_defensa = p1.getDefensa();

            int p2_ataqueTotal;
            int p2_defensa;

            if (p2.getClass().equals(PlantaRecolectora.class)) {
                p2_ataqueTotal = p2.getAtaque();

            } else if (p2.getClass().equals(Planta.class)) {
                p2_ataqueTotal = p2.getAtaque() + ((Planta) p2).getArma().getPotencia();

            } else {
                p2_ataqueTotal = p2.getAtaque() + ((Zombi) p2).getHabilidad().getPotencia();

            }

            p2_defensa = p2.getDefensa();

            int damage_a_p1 = p2_ataqueTotal - p1_defensa;
            if (damage_a_p1 > 0) {
                p1.setNivelVida(p1.getNivelVida() - damage_a_p1);
            }

            int damage_a_p2 = p1_ataqueTotal - p2_defensa;
            if (damage_a_p2 > 0) {
                p2.setNivelVida(p2.getNivelVida() - damage_a_p2);
            }

            if (damage_a_p1 > damage_a_p2) {
                resultadocombate = 2;
            } else if (damage_a_p2 > damage_a_p1) {
                resultadocombate = 1;
            }

            String win = "";

            if (p1.getClass().equals(PlantaRecolectora.class) || p2.getClass().equals(PlantaRecolectora.class)) {

                if (p1.getClass().equals(PlantaRecolectora.class)) {
                    p1.setNivelVida(0);
                } else if (p2.getClass().equals(PlantaRecolectora.class)) {
                    p2.setNivelVida(0);
                }

                win += "\t\tUna planta de tipo recolectora ha muerto";
                plantasRecolectoras_vivas--;

            } else {
                win += "COMBATE: " + p1.getNombre() + " vs " + p2.getNombre();

                win += "\n======== GANADOR: ";

                if (resultadocombate == 1) {
                    win += p1.getNombre();
                } else if (resultadocombate == 2) {
                    win += p2.getNombre();
                } else {
                    win += "Ha habido un empate";
                }

                win += "\n******** ";
                if (p1.isVivo()) {
                    win += p1.getNombre() + " sigue viva";
                } else {
                    win += p1.getNombre() + " ha muerto";
                    if (p1.getClass().equals(Planta.class)) {
                        plantasGuerreras_vivas--;
                    } else {
                        zombis_vivos--;
                    }
                }

                win += "\n******** ";
                if (p2.isVivo()) {
                    win += p2.getNombre() + " sigue vivo";
                } else {
                    win += p2.getNombre() + " ha muerto";
                    if (p2.getClass().equals(Planta.class)) {
                        plantasGuerreras_vivas--;
                    } else {
                        zombis_vivos--;
                    }

                }
            }
            System.out.println(win);
        }
        num_combates++;
        return resultadocombate;
    }

    public void imprimePlantasGuerrerasVivas() {
        String p = "--> PLANTAS GUERRERAS:\n";

        for (int i = 0; i < plantasGuerreras.length; i++) {
            if (plantasGuerreras[i].isVivo()) {
                p += i + ": " + plantasGuerreras[i] + "\n";
            }
        }
        System.out.println(p);
    }

    public void imprimeZombisVivos() {
        String z = "--> ZOMBIS VIVOS:\n";

        for (int i = 0; i < zombis.length; i++) {
            if (zombis[i].isVivo()) {
                z += i + ": " + zombis[i] + "\n";
            }
        }
        System.out.println(z);
    }

    public void jugar() {

    }

}
