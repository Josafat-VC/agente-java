public class Simulacion {
    public static void main(String[] args) {
        Mapa mapa = new Mapa(30);
        SubMapa submapaP = new SubMapa();
        Agente p = new Agente('P', 5, 0, mapa,submapaP);


        for (int i = 0; i < 15; i++) {
            mapa.ubicacionAgente(mapa,p);
            p.movimientoAgente();

        }
        mapa.ubicacionAgente(mapa, p);

        submapaP.imprimirSubMapa();

        System.out.println("Comenzando retorno--------------------------");



//        for (int i = submapaP.getRecorridoX().size(); i > 0 ; i--) {
//            mapa.ubicacionAgenteRetorno(mapa,p);
//            p.retorno();
//        }

            p.retorno();







    }
}