import java.util.Scanner;

public class Simulacion {
    static StringBuilder sb = new StringBuilder("¡¡ Hola Bienvenido !!")
            .append("\n 1: Iniciar Recorrido ")
            .append("\n 2: Salir");
    protected static boolean recorrido = false;
    private static boolean salir = false;
    public static void main(String[] args) {


        Scanner s = new Scanner(System.in);
        Mapa mapa = new Mapa(30);
        SubMapa submapaP = new SubMapa();
        Agente p = new Agente('P', 5, 0, mapa,submapaP);





        while (!salir) {
            System.out.println(sb);
            System.out.print("Seleccione un opción: ");
            int opcion = s.nextInt();

            switch (opcion) {
                case 1 -> {
                    recorrido = true;
                    while (recorrido) {
                        mapa.ubicacionAgente(mapa, p);
                        if (!recorrido) {
                            break;
                        }
                        p.movimientoAgente();
                    }
                    submapaP.imprimirSubMapa();
             
                }
                case 2 -> {
                    salir = true;
                }

            }
        }
    }
}