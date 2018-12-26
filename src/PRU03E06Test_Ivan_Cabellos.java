import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PRU03E06Test_Ivan_Cabellos{
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in).useDelimiter("\\n");

        /* LISTAS PREDEFINIDAS */

        ArrayList<PRU03E06_Ivan_Cabellos> entradesReservades = new ArrayList<>();

        PRU03E06_Ivan_Cabellos entraPredefVIP = new PRU03E06_Ivan_Cabellos(2);
        PRU03E06_Ivan_Cabellos entraPredefAmfi = new PRU03E06_Ivan_Cabellos(5);
        PRU03E06_Ivan_Cabellos entraPredefPlat = new PRU03E06_Ivan_Cabellos(8);

        entraPredefVIP.setNumEntradesVIP(); entraPredefVIP.setPosEntradaVIP();
        entraPredefAmfi.setNumEntradesAmfi();
        entraPredefPlat.setNumEntradesPlatea();

        entradesReservades.add(entraPredefVIP);
        entradesReservades.add(entraPredefAmfi);
        entradesReservades.add(entraPredefPlat);

        /* --- */

        int controlDelMenu = 0;
        while (controlDelMenu != 7){
            System.out.print("Bienvenido a conciertos Palma, " +
                    "que quieres hacer: " +
                    "\n1. Mostrar el número de entradas disponibles." +
                    "\n2. Comprar  una entrada." +
                    "\n7. Salir\n");
            controlDelMenu = sc.nextInt();

            switch (controlDelMenu){
                //TODO controlar que printee las posiciones de las entradas
                case 1:
                    System.out.println("Quedan " + PRU03E06_Ivan_Cabellos.numEntradesTotal + " de entradas en total." +
                            "\nPara la platea quedan " + PRU03E06_Ivan_Cabellos.numEntradesPlatea +
                            "\nPara el amfiteatro quedan " + PRU03E06_Ivan_Cabellos.numEntradesAmfi +
                            "\nY quedan " + PRU03E06_Ivan_Cabellos.numEntradesVIP + " entradas VIP\n");
                    break;

                case 2:
                    System.out.println("Dime donde quieres en que zona quieres comprar la entrada:" +
                            "\n[1] En la platea, quedan " + PRU03E06_Ivan_Cabellos.numEntradesPlatea +
                            "\n[2] En el amfiteatro, quedan " + PRU03E06_Ivan_Cabellos.numEntradesAmfi +
                            "\n[3] Una entrada VIP, que quedan " + PRU03E06_Ivan_Cabellos.numEntradesVIP + "\n");
                    int tipoEntrada = sc.nextInt();

                    int numEntradas;

                    switch (tipoEntrada){
                        //TODO controlar las posiciones cuando gardamos las entradas de la platea y el amfiteatro
                        case 1:
                            System.out.print("Cuantas entradas quieres comprar para la platea: ");
                            numEntradas = sc.nextInt();
                            PRU03E06_Ivan_Cabellos entradasCompradasPlatea = new PRU03E06_Ivan_Cabellos(numEntradas);
                            
                            entradasCompradasPlatea.setNumEntradesPlatea();
                            System.out.println("Se han comprado " + numEntradas + " para la platea");
                            break;

                        case 2:
                            System.out.print("Cuantas entradas quieres comprar para el amfiteatro: ");
                            numEntradas = sc.nextInt();
                            PRU03E06_Ivan_Cabellos entradasCompradasAmfi = new PRU03E06_Ivan_Cabellos(numEntradas);
                            entradasCompradasAmfi.setNumEntradesAmfi();
                            System.out.println("Se han comprado " + numEntradas + " para el amfiteatro");
                            break;

                        case 3:
                            System.out.print("Cuantas entradas VIP quieres comprar: ");
                            numEntradas = sc.nextInt();
                            PRU03E06_Ivan_Cabellos entradasCompradasVIP = new PRU03E06_Ivan_Cabellos(numEntradas);
                            entradasCompradasVIP.setNumEntradesVIP();
                            entradasCompradasVIP.setPosEntradaVIP();
                            System.out.println("Se han comprado " + numEntradas + " de entradas VIP");
                            System.out.println(Arrays.toString(PRU03E06_Ivan_Cabellos.espaciosVIP));
                            break;
                    }
                    break;
            }

        }

    }
}
