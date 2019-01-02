import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PRU03E06Test_Ivan_Cabellos{
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in).useDelimiter("\\n");

        /* LISTAS PREDEFINIDAS */

        ArrayList<PRU03E06_Ivan_Cabellos> entradesReservades = new ArrayList<>();

        PRU03E06_Ivan_Cabellos entraPredefVIP = new PRU03E06_Ivan_Cabellos(2, "Tofol");
        PRU03E06_Ivan_Cabellos entraPredefAmfi = new PRU03E06_Ivan_Cabellos(5, "Antonio");
        PRU03E06_Ivan_Cabellos entraPredefPlat = new PRU03E06_Ivan_Cabellos(8, "Biel");

        entraPredefVIP.setNumEntradesVIP();
        System.out.println(Arrays.toString(entraPredefVIP.getPosicionsReservades()));

        entraPredefAmfi.setNumEntradesAmfi();
        System.out.println(Arrays.toString(entraPredefAmfi.getPosicionsReservades()));

        entraPredefPlat.setNumEntradesPlatea();
        System.out.println(Arrays.toString(entraPredefPlat.getPosicionsReservades()));

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
                case 1:
                    System.out.println("Quedan " + PRU03E06_Ivan_Cabellos.numEntradesTotal + " de entradas en total." +
                            "\nPara la platea quedan " + PRU03E06_Ivan_Cabellos.numEntradesPlatea +
                            "\nPara el amfiteatro quedan " + PRU03E06_Ivan_Cabellos.numEntradesAmfi +
                            "\nY quedan " + PRU03E06_Ivan_Cabellos.numEntradesVIP + " entradas VIP\n");
                    System.out.println("¿Quieres ver las posiciones reservadas? teclea 'si',  sino '7'");
                    String controlImprimir = sc.next();
                    switch (controlImprimir){
                        case "si":
                            System.out.println("Dime que tipo de entradas quieres ver: ");
                            System.out.println("[1]La platea" +
                                    "\n[2]El amfiteatro" +
                                    "\n[3]Las VIP");
                            controlImprimir = sc.next();
                            switch (controlImprimir){
                                case "1":
                                    System.out.print("La platea se divide en 4 secciones: ");
                                    System.out.println("Dime si quires ver las entradas de " +
                                            "\nArriba\nIzquierda\nDerecha\nCentro");
                                    controlImprimir = sc.next().toUpperCase();
                                    switch (controlImprimir){
                                        case "ARRIBA":
                                            controlImprimir = "0"; break;
                                        case "IZQUIERDA":
                                            controlImprimir = "1"; break;
                                        case "DERECHA":
                                            controlImprimir = "2"; break;
                                        case "CENTRO":
                                            controlImprimir = "3"; break;
                                    }
                                    System.out.println(Arrays.deepToString(PRU03E06_Ivan_Cabellos.espaciosPlatea[Integer.parseInt(controlImprimir)]));
                                    break;
                                case "2":
                                    System.out.println(Arrays.deepToString(PRU03E06_Ivan_Cabellos.espaciosAmfiteatro));
                                    break;
                                case "3":
                                    System.out.println(Arrays.deepToString(PRU03E06_Ivan_Cabellos.espaciosVIP));
                            }
                    }
                    break;

                case 2:
                    System.out.println("Dime donde quieres en que zona quieres comprar la entrada:" +
                            "\n[1] En la platea, quedan " + PRU03E06_Ivan_Cabellos.numEntradesPlatea +
                            "\n[2] En el amfiteatro, quedan " + PRU03E06_Ivan_Cabellos.numEntradesAmfi +
                            "\n[3] Una entrada VIP, que quedan " + PRU03E06_Ivan_Cabellos.numEntradesVIP + "\n");
                    int tipoEntrada = sc.nextInt();

                    int numEntradas;
                    String nomReserva;

                    //TODO preguntar donde queremos guardar las entradas
                    switch (tipoEntrada){
                        case 1:
                            System.out.print("Cuantas entradas quieres comprar para la platea: ");
                            numEntradas = sc.nextInt();
                            System.out.println("Nombre para la reserva: ");
                            nomReserva = sc.next();
                            PRU03E06_Ivan_Cabellos entradasCompradasPlatea = new PRU03E06_Ivan_Cabellos(numEntradas);
                            entradasCompradasPlatea.TipusEntrada = TipusEntrada.platea;
                            entradasCompradasPlatea.setNomReserva(nomReserva);
                            entradasCompradasPlatea.setNumEntradesPlatea();
                            entradesReservades.add(entradasCompradasPlatea);
                            System.out.println("Se han comprado " + numEntradas + " para la platea");
                            break;

                        case 2:
                            System.out.print("Cuantas entradas quieres comprar para el amfiteatro: ");
                            numEntradas = sc.nextInt();
                            System.out.print("Nombre de la reserva: ");
                            nomReserva = sc.next();
                            PRU03E06_Ivan_Cabellos entradasCompradasAmfi = new PRU03E06_Ivan_Cabellos(numEntradas);
                            entradasCompradasAmfi.TipusEntrada = TipusEntrada.amfiteatro;
                            entradasCompradasAmfi.setNomReserva(nomReserva);
                            entradasCompradasAmfi.setNumEntradesAmfi();
                            entradesReservades.add(entradasCompradasAmfi);
                            System.out.println("Se han comprado " + numEntradas + " para el amfiteatro");
                            break;

                        case 3:
                            System.out.print("Cuantas entradas VIP quieres comprar: ");
                            numEntradas = sc.nextInt();
                            System.out.print("Nombre de la reserva: ");
                            nomReserva = sc.next();
                            PRU03E06_Ivan_Cabellos entradasCompradasVIP = new PRU03E06_Ivan_Cabellos(numEntradas);
                            entradasCompradasVIP.TipusEntrada = TipusEntrada.vip;
                            entradasCompradasVIP.setNomReserva(nomReserva);
                            entradasCompradasVIP.setNumEntradesVIP();
                            entradesReservades.add(entradasCompradasVIP);
                            System.out.println("Se han comprado " + numEntradas + " de entradas VIP");
                            break;
                    }
                    break;
            }

        }

    }
}
