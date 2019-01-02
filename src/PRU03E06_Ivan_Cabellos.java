import java.util.Scanner;

public class PRU03E06_Ivan_Cabellos {

    private int numEntradesAComprar;
    private int[] posicionsReservades;
    private String nomReserva;

    /* Numero de entradas en total disponibles del espacio */
    static int numEntradesTotal = 1225;
    static int numEntradesPlatea = 1000;
    static int numEntradesAmfi = 200;
    static int numEntradesVIP = 25;

    TipusEntrada TipusEntrada;

    /* Atributos para que vayan numeradas */
    static String[][] espaciosPlatea = new String[5][200];

    static String[] espaciosAmfiteatro = new String[200];
    static String[] espaciosVIP = new String[25];

    PRU03E06_Ivan_Cabellos(int numEntrades){
        this.numEntradesAComprar = numEntrades;
    }

    PRU03E06_Ivan_Cabellos(int numEntrades, String nomReserva) {
        this.numEntradesAComprar = numEntrades;
        this.nomReserva = nomReserva;
    }


    //TODO controlar la posicion donde guardamos las entradas
    void setNumEntradesVIP() throws Exception {
        if (numEntradesVIP >= numEntradesAComprar){
            numEntradesTotal = numEntradesTotal - this.numEntradesAComprar;
            numEntradesVIP = numEntradesVIP - this.numEntradesAComprar;
            System.out.println("Quedan: " + numEntradesTotal + " de entrades en total, " +
                    "y " + numEntradesVIP + " entradas VIP");

            int numEntradasAColorcar = this.numEntradesAComprar;
            posicionsReservades = new int[numEntradasAColorcar];
            for (int i = 0; i < espaciosVIP.length; i++) {
                if (espaciosVIP[i] == null){
                    for (int j = 0; j < numEntradasAColorcar; j++, i++) {
                        espaciosVIP[i] = getNomReserva();
                        posicionsReservades[j] = i + 1;
                    }
                    break;
                }
            }

        } else throw new Exception("No hay suficientes entradas VIP");
    }

    void setNumEntradesAmfi() throws Exception {
        if (numEntradesAmfi >= numEntradesAComprar){
            numEntradesTotal = numEntradesTotal - this.numEntradesAComprar;
            numEntradesAmfi = numEntradesAmfi - this.numEntradesAComprar;
            System.out.println("Quedan: " + numEntradesTotal + " de entrades en total, " +
                    "y " + numEntradesAmfi + " para el amfiteatro");

            int numEntradasAColocar = this.numEntradesAComprar;
            posicionsReservades = new int[numEntradasAColocar];
            for (int i = 0; i < espaciosAmfiteatro.length; i++) {
                if (espaciosAmfiteatro[i] == null){
                    for (int j = 0; j < numEntradasAColocar; j++, i++) {
                        espaciosAmfiteatro[i] = getNomReserva();
                        posicionsReservades[j] = i + 1;
                    }
                    break;
                }
            }

        } else throw new Exception("No hay suficientes entradas para el amfiteatro");
    }

    void setNumEntradesPlatea() throws Exception {
        Scanner sc = new Scanner(System.in).useDelimiter("\\n");
        if (numEntradesPlatea >= numEntradesAComprar){
            numEntradesTotal = numEntradesTotal - this.numEntradesAComprar;
            numEntradesPlatea = numEntradesPlatea- this.numEntradesAComprar;
            System.out.println("Quedan: " + numEntradesTotal + " de entrades en total, " +
                    "y " + numEntradesPlatea + " para la platea");
        } else throw new Exception("No hay sificientes entradas en la platea");

        int numEntradasAColocar = this.numEntradesAComprar;
        posicionsReservades = new int[numEntradasAColocar];
        System.out.println("Dime sobre donde quieres las entradas de la platea: ");
        System.out.println("Arriba, izquierda, derecha o en el centro");
        String posEntradasPlatea = sc.next().toUpperCase();

        switch (posEntradasPlatea){
            case "ARRIBA":
                posEntradasPlatea = "0"; break;
            case "IZQUIERDA":
                posEntradasPlatea = "1"; break;
            case "DERECHA":
                posEntradasPlatea = "2"; break;
            case "CENTRO":
                posEntradasPlatea = "3"; break;
        }

        for (int i = 0; i < espaciosPlatea[Integer.parseInt(posEntradasPlatea)].length; i++) {
            if (espaciosPlatea[Integer.parseInt(posEntradasPlatea)][i] == null){
                for (int j = 0; j < numEntradasAColocar; j++, i++) {
                    espaciosPlatea[Integer.parseInt(posEntradasPlatea)][i] = getNomReserva();
                    posicionsReservades[j] = i + 1;
                }
                break;
            }
        }

    }

    public String getNomReserva() {
        return nomReserva;
    }

    public void setNomReserva(String nomReserva) {
        this.nomReserva = nomReserva;
    }

    public int[] getPosicionsReservades() {
        return posicionsReservades;
    }

    public TipusEntrada getTipusEntrada() {
        return TipusEntrada;
    }

}
