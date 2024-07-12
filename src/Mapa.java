import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Mapa {
    Scanner s = new Scanner(System.in);

    protected char[][] mapa;
    protected int numeroObstaculos;
    public int contadorPosicion=0;

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


    int opcionA;
    public void ubicacionAgente(Mapa mapa, Agente agente) {
        tiempoEspera(1);

        if (contadorPosicion == 5){

            System.out.print("¡¡ El Agente parece estar atorado !!\n1. Reiniciar \n2. Continuar \nElija una opción:");
            opcionA= s.nextInt();
            switch (opcionA){
                case 1 ->{
                    Simulacion.main(null);
                }
                case 2 -> {
                    contadorPosicion=0;
                    return;

                }
            }
            contadorPosicion = 0;
        }

        //Verificación retorno
        if (agente.verificar() < 11 && agente.verificar() > 1){
            System.out.println("Hay un recurso");

            agente.rastroAgente(mapa);
            mapa.mapa[agente.posicionY][agente.posicionX] = agente.nombreAgente;
            System.out.println("La posicion del agente es: " +" X=" + agente.posicionX + " | Y=" + agente.posicionY);
            imprimirMapa();
            agente.retorno();
            return;

        }
        //Rastro Agente
        agente.rastroAgente(mapa);

        if (mapa.mapa[agente.posicionY][agente.posicionX] == '|') {
            System.out.println("¡Hay un obstaculo!");
            agente.posicionAnterior();

        }else if ( agente.subMapa.subMapa[agente.posicionY][agente.posicionX] == 'X' ){
            System.out.println("Posición registrada en el submapa.  No se movera");
            agente.posicionAnterior();
            contadorPosicion++;

        }

        mapa.mapa[agente.posicionY][agente.posicionX] = agente.nombreAgente;


        System.out.println("La posicion del agente es: " +" X=" + agente.posicionX + " | Y=" + agente.posicionY);
        imprimirMapa();


        System.out.println("---------------------------------------------------------------------");


    }

    public void ubicacionAgenteRetorno(Mapa mapa, Agente agente) {
        tiempoEspera(1);

        agente.rastroAgenteR(mapa);

        mapa.mapa[agente.posicionY][agente.posicionX] = agente.nombreAgente;
        imprimirMapa();
        System.out.println("La posicion del agente es: " +" X=" + agente.posicionX + " | Y=" + agente.posicionY);
        System.out.println("---------------------------------------------------------------------");
    }

    public void tiempoEspera(int tiempo){
        int t = tiempo *1000;
        try {
            // Pausa por 1000 milisegundos (1 segundo)
            Thread.sleep(t);
        } catch (InterruptedException e) {
            // Manejo de la excepción en caso de que el hilo sea interrumpido
            e.printStackTrace();
        }
    }




}
