import java.util.Arrays;
import java.util.Random;

public class Mapa {

    protected char[][] mapa;
    protected int numeroObstaculos;

    public Mapa() {

    }

    public Mapa(int numeroObstaculos) {
        this.mapa = new char[10][10];

        for (char[] filas : mapa) {
            Arrays.fill(filas, '*');
        }

        for (int i = 0; i < (this.numeroObstaculos = numeroObstaculos); i++) {
            Random rnd = new Random();
            mapa[rnd.nextInt(8) + 2][rnd.nextInt(9) + 1] = '|';

        }

        for (int i = 0; i < 14; i++) {
            Random rnd = new Random();
            mapa[rnd.nextInt(8) + 2][rnd.nextInt(8) +1 ] = (char) (rnd.nextInt(9) + '1');

        }

    }

    public void imprimirMapa() {

        for (int filas = 0; filas < mapa.length; filas++) {
            for (int columnas = 0; columnas < mapa[filas].length; columnas++) {
                System.out.print(mapa[filas][columnas] + " ");
            }
            System.out.println();
        }
    }


    public void ubicacionAgente(Mapa mapa, Agente agente) {
        //Rastro Agente
        agente.rastroAgente(mapa);

        if (mapa.mapa[agente.posicionY][agente.posicionX] == '|') {
            System.out.println("¡Hay un obstaculo!");
            agente.posicionAnterior();

        }else if ( agente.subMapa.subMapa[agente.posicionY][agente.posicionX] == 'X' ){
            System.out.println("Posición registrada en el submapa.  No se movera");
            agente.posicionAnterior();
        }

        mapa.mapa[agente.posicionY][agente.posicionX] = agente.nombreAgente;


        System.out.println("La posicion del agente es: " +" X=" + agente.posicionX + " | Y=" + agente.posicionY);
        imprimirMapa();
        System.out.println("---------------------------------------------------------------------");


    }

    public void ubicacionAgenteRetorno(Mapa mapa, Agente agente) {

        System.out.println("La posicion del agente es: " +" X=" + agente.posicionX + " | Y=" + agente.posicionY);
        imprimirMapa();
        System.out.println("---------------------------------------------------------------------");

        agente.rastroAgenteR(mapa);

        mapa.mapa[agente.posicionY][agente.posicionX] = agente.nombreAgente;

    }




}
