import java.util.Random;

public class Agente {
    protected char nombreAgente;
    protected int posicionX;
    protected int posicionY;

    protected int anteriorX;
    protected int anteriorY;
    private final Mapa mapa;
    protected final SubMapa subMapa;
    private int contadorRastro;
    private int recurso;


    public Agente(char nombreAgente, int posicionX, int posicionY, Mapa mapa, SubMapa subMapa) {
        this.nombreAgente = nombreAgente;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.mapa = mapa;
        this.subMapa = subMapa;
    }


    public int getAnteriorX() {
        return anteriorX;
    }

    public int getAnteriorY() {
        return anteriorY;
    }

    public void setAnteriorX(int anteriorX) {
        this.anteriorX = anteriorX;
    }

    public void setAnteriorY(int anteriorY) {
        this.anteriorY = anteriorY;
    }

    public void movimientoAgente() {
        // Guardar la posición anterior del Agente
        setAnteriorY(posicionY);
        setAnteriorX(posicionX);

        // Registrar movimiento en el subMapa
        subMapa.movimientosSubMapa(posicionX, posicionY);

        Random rnd = new Random();

        int movimiento = rnd.nextInt(3);

        switch (movimiento){
            case 0 -> { //Arriba
                if(posicionY == 0){
                    System.out.println("El Agente se encuentra en el limite");
                    break;
                }
                posicionY--;
            }
            case 1 -> { // Derecha
                if (posicionX == 9){
                    System.out.println("El Agente se encuentra en el limite");
                    break;
                }
                posicionX++;
            }
            case 2 -> { //Abajo
                if (posicionY == mapa.mapa[0].length - 1){
                    System.out.println("El Agente se encuentra en el limite");
                    break;
                }
                posicionY++;
            }
            case 3 -> { // Izquierda

                if (posicionX == 0){
                    System.out.println("El Agente se encuentra en el limite");
                    break;
                }
                posicionX--;
            }

        }
    }

    public void rastroAgente(Mapa mapa){
        if (contadorRastro != 0 ){
            mapa.mapa[getAnteriorY()][getAnteriorX()] = '-';
        }
        contadorRastro++;
    }

    public int verificar(){
        char c = mapa.mapa[posicionY][posicionX];
        return Character.getNumericValue(c);
    }

    public void retorno(){

        for (int filas = 9; filas >= 0; filas-- ){
            for (int columnas = 9; columnas >= 0; columnas--){
                char c = subMapa.subMapa[filas][columnas];
                String s = Character.toString(c);

                if ( s.equals( "X") ){
                    System.out.println("Posicion Y: " + filas);
                    System.out.println("Posicion X: " + columnas);
                }

            }
        }

    }


    public void posicionAnterior(){
        posicionY = getAnteriorY();
        posicionX = getAnteriorX();
    }


}
