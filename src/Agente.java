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
        int bandera = subMapa.getRecorridoX().size();
        System.out.println("Y: " + subMapa.getRecorridoY());
        System.out.println("X: " + subMapa.getRecorridoX());


        if(bandera > 0){
                for (int i = bandera; i > 0  ; i--) {

                    System.out.println("Retorno en Y, id: "+ i + " " + subMapa.getRecorridoY().get(i));
                    System.out.println("Retorno en X, id: "+ i + " " + subMapa.getRecorridoX().get(i));
                    posicionY = subMapa.getRecorridoY().get(i);
                    posicionX = subMapa.getRecorridoX().get(i);
                    mapa.ubicacionAgenteRetorno(mapa, Agente.this);

                }


            }
        
        
        
        System.out.println("Hemos llegado al final");


    }


    public void posicionAnterior(){
        posicionY = getAnteriorY();
        posicionX = getAnteriorX();
    }


}
