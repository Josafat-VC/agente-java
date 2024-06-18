import java.util.Arrays;
import java.util.Random;

public class Pruebas {
    public static void main(String[] args) {
        Random rnd = new Random();
//        for (int i = 0; i < 20; i++) {
//            int prueba = rnd.nextInt(3)+1;
//            System.out.println(prueba);
//        }
//
//
//        String[][] mapa = new String[10][10];
//        for (String[] filas : mapa){
//            Arrays.fill(filas, "*");
//        }
//        System.out.println(mapa[0].length-1);

//        char[][] grid = {
//                {'*', '*', '*', '*', '*', '-', '7', '*', '*', '*'},
//                {'*', '*', '|', 'X', '*', '-', '*', '|', '6', '|'},
//                {'*', '|', '*', '|', 'X', '-', '*', '*', '|', '|'},
//                {'*', '|', '*', '|', 'X', 'P', 'X', '*', '*', '*'},
//                {'*', '*', '|', '3', '*', '|', '*', '*', '*', '*'},
//                {'*', '*', '|', '*', '|', '*', '1', '*', '*', '*'},
//                {'*', '|', '*', '5', '|', '*', '5', '1', '*', '*'},
//                {'*', '*', '*', '*', '1', 'X', '*', '|', '*', '*'},
//                {'*', '|', '|', '*', '*', '*', '*', '2', '*', '3'},
//                {'*', '*', '*', '*', '|', '*', '*', '*', '3', '3'}
//        };

//        for (int i = 9; i >= 0; i--){
//            for (int y = 9 ; y >= 0; y--){
//                int a = Character.getNumericValue(grid[y][i]);
//                System.out.println(a);
//            }
//        }


//        for (int i = 9; i >= 0; i--) {
//            for (int y = 9; y >= 0; y--) {
//                char c = grid[y][i];
//                if (Character.isDigit(c) ) {
//                    int a = Character.getNumericValue(c);
//                    System.out.println("Carácter: " + c + ", Valor numérico: " + a);
//                } else {
//                    String sd = Character.toString (c);
//                    System.out.println("Carácter no numérico: " + c);
//                    System.out.println(sd);
//                }
//            }
//        }


        for (int i = 0; i < 9; i++) {
            int a = rnd.nextInt(4) + 1;

            System.out.println(a);

        }




    }
}
