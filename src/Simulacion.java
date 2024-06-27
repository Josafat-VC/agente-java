import java.util.Scanner;

public class Simulacion {
    static StringBuilder sb = new StringBuilder("Ingrese una opción:")
            .append("\n 1: Iniciar Recorrido ")
            .append("\n 2: Reiniciar")
            .append("\n 3: Salir");
    protected static boolean recorrido = false;
    public static void main(String[] args) {


        Scanner s = new Scanner(System.in);
        Mapa mapa = new Mapa(30);
        SubMapa submapaP = new SubMapa();
        Agente p = new Agente('P', 5, 0, mapa,submapaP);



        System.out.println(sb);
        int opcion = s.nextInt();

        switch (opcion){
            case 1 -> {
                recorrido = true;
                while (recorrido) {
                    mapa.ubicacionAgente(mapa, p);
                    p.movimientoAgente();
                }
                    mapa.ubicacionAgente(mapa, p);
                    submapaP.imprimirSubMapa();
                    break;
            }
            case 2 ->{
                main(null);
            }
            case 3 ->{
            }

        }






//        for (int i = 0; i < 15; i++) {
//            mapa.ubicacionAgente(mapa,p);
//            p.movimientoAgente();
//
//        }
//        mapa.ubicacionAgente(mapa, p);
//
//        submapaP.imprimirSubMapa();









    }
}