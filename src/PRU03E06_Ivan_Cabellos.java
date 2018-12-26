import java.util.Arrays;

public class PRU03E06_Ivan_Cabellos {

    private int numEntradesAComprar;

    /* Numero de entradas en total disponibles del espacio */
    static int numEntradesTotal = 1225;
    static int numEntradesPlatea = 1000;
    static int numEntradesAmfi = 200;
    static int numEntradesVIP = 25;

    //TODO implimentar el enum del tipo de las entradas
    tipusEntrada tipusEntrada;

    /* Atributos para que vayan numeradas */
    //TODO tengo que controlar las reservas de los tickets
    static boolean[][] espaciosPlatea = new boolean[4][250];
    static boolean[] espaciosAmfiteatro = new boolean[200];
    //
    static boolean[] espaciosVIP = new boolean[25];

    PRU03E06_Ivan_Cabellos() {
    }

    PRU03E06_Ivan_Cabellos(int numEntrades) {
        this.numEntradesAComprar = numEntrades;
    }

    void setNumEntradesVIP() throws Exception {
        if (numEntradesVIP >= numEntradesAComprar){
            numEntradesTotal = numEntradesTotal - this.numEntradesAComprar;
            numEntradesVIP = numEntradesVIP - this.numEntradesAComprar;
            System.out.println("Quedan: " + numEntradesTotal + " de entrades en total, " +
                    "y " + numEntradesVIP + " entradas VIP");
        } else throw new Exception("No hay suficientes entradas VIP");
    }

    void setNumEntradesAmfi() throws Exception {
        if (numEntradesAmfi >= numEntradesAComprar){
            numEntradesTotal = numEntradesTotal - this.numEntradesAComprar;
            numEntradesAmfi = numEntradesAmfi - this.numEntradesAComprar;
            System.out.println("Quedan: " + numEntradesTotal + " de entrades en total, " +
                    "y " + numEntradesAmfi + " para el amfiteatro");
        } else throw new Exception("No hay suficientes entradas para el amfiteatro");
    }

    void setNumEntradesPlatea() throws Exception {
        if (numEntradesPlatea >= numEntradesAComprar){
            numEntradesTotal = numEntradesTotal - this.numEntradesAComprar;
            numEntradesPlatea = numEntradesPlatea- this.numEntradesAComprar;
            System.out.println("Quedan: " + numEntradesTotal + " de entrades en total, " +
                    "y " + numEntradesPlatea + " para la platea");
        } else throw new Exception("No hay sificientes entradas en la platea");
    }

    public void setPosEntradaVIP() throws Exception {
        try {
            int numEntradasAColorcar = this.numEntradesAComprar;
            for (int i = 0; i < espaciosVIP.length; i++) {
                if (!espaciosVIP[i]) {
                    for (int j = 0; j < numEntradasAColorcar; j++, i++) {
                        espaciosVIP[i] = true;
                    }
                    break;
                }
            }
        } catch (Exception e){
            throw new Exception("No hay suficientes entradas para todos");
        }

    }

}
