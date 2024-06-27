import java.util.Random;

public class Agente {
    protected char nombreAgente;
    protected int posicionX;
    protected int posicionY;

    protected int anteriorX;
    protected int anteriorY;
    private final Mapa mapa;
    protected  SubMapa subMapa;
    private int contadorRastro;
    private int recurso;
    private static final String MENSAJE_LIMITE = "¡EL Agente esta en en limite!. No se movera";


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


        // Registrar movimiento en el subMapa
        subMapa.movimientosSubMapa(posicionX, posicionY);
        // Guardar la posición anterior del Agente
        setAnteriorY(posicionY);
        setAnteriorX(posicionX);



        Random rnd = new Random();

        int movimiento = rnd.nextInt(4);

        switch (movimiento){
            case 0 -> { //Arriba
                System.out.println("El movimiento es: Arriba ");
                if(posicionY == 0){
                    System.out.println(MENSAJE_LIMITE);
                    break;
                }
                posicionY--;
            }
            case 1 -> { // Derecha
                System.out.println("El movimiento es: Derecha");
                if (posicionX == 9){
                    System.out.println(MENSAJE_LIMITE);
                    break;
                }
                posicionX++;
            }
            case 2 -> { //Abajo
                System.out.println("El movimiento es: Abajo");
                if (posicionY == mapa.mapa[0].length - 1){
                    System.out.println(MENSAJE_LIMITE);
                    break;
                }
                posicionY++;
            }
            case 3 -> { // Izquierda
                System.out.println("El movimiento es: Izquierda");
                if (posicionX == 0){
                    System.out.println(MENSAJE_LIMITE);
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
    public void rastroAgenteR(Mapa mapa){
        if (contadorRastro != 0 ){
            mapa.mapa[getAnteriorY()][getAnteriorX()] = '•';
        }
        contadorRastro++;
    }

    public int verificar(){
        char c = mapa.mapa[posicionY][posicionX];
        return Character.getNumericValue(c);
    }


    public void retorno(){
        subMapa.subMapa[posicionY][posicionX] = 'R';

        System.out.println("------------------------- Comenzando retorno -------------------------");

        int bandera = subMapa.getRecorridoX().size();
        System.out.println("Y: " + subMapa.getRecorridoY());
        System.out.println("X: " + subMapa.getRecorridoX());


        if(bandera > 0){
            for (int i = bandera; i > 0  ; i--) {

                setAnteriorY(posicionY);
                setAnteriorX(posicionX);

                posicionY = subMapa.getRecorridoY().get(i);
                posicionX = subMapa.getRecorridoX().get(i);
                mapa.ubicacionAgenteRetorno(mapa, Agente.this);

            }
        }
        System.out.println("Hemos llegado al final");
        Simulacion.recorrido = false;

    }


    public void posicionAnterior(){
        posicionY = getAnteriorY();
        posicionX = getAnteriorX();
    }


}
