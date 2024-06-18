import java.util.Arrays;
import java.util.HashMap;

public class SubMapa {
    protected char[][] subMapa;
    private  HashMap<Integer, Integer> recorridoY;
    private HashMap<Integer, Integer> recorridoX;
    private int idHash = 0;



    public SubMapa() {
        subMapa = new char[10][10];

        for (char[] filas : subMapa) {
            Arrays.fill(filas, ' ');
        }
        recorridoY = new HashMap<>();
        recorridoX = new HashMap<>();

    }

    public void imprimirSubMapa() {
        for (int filas = 0; filas < subMapa.length; filas++) {
            for (int columnas = 0; columnas < subMapa[filas].length; columnas++) {
                System.out.print(subMapa[filas][columnas] + " ");
            }
            System.out.println();
        }
    }


    public void movimientosSubMapa(int posicionX, int posicionY) {
        subMapa[posicionY][posicionX] = 'X';
        coordenadaY(posicionY);
        coordenadaX(posicionX);
        idHash++;
    }

    private void coordenadaY(int posicionY) {
        recorridoY.put(idHash, posicionY);
    }

    private void coordenadaX(int posicionX) {
        recorridoX.put(idHash, posicionX);
    }

    public void imprimirHas() {
        System.out.println("Recorrido Y:");
        for (HashMap.Entry<Integer, Integer> entrada : recorridoY.entrySet()) {
            System.out.println("ID: " + entrada.getKey() + ", Posición Y: " + entrada.getValue());
        }

        System.out.println("Recorrido X:");
        for (HashMap.Entry<Integer, Integer> entrada : recorridoX.entrySet()) {
            System.out.println("ID: " + entrada.getKey() + ", Posición X: " + entrada.getValue());
        }
    }

    public static void main(String[] args) {
        SubMapa mapa = new SubMapa();
        mapa.movimientosSubMapa(2, 3);
        mapa.movimientosSubMapa(4, 5);
        mapa.imprimirSubMapa();
        mapa.imprimirHas();
    }
}



