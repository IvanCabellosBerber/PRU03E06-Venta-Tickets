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
    //TODO tengo que controlar las reservas de los tickets en la platea
    static String[][] espaciosPlatea = new String[4][250];
    //
    static String[] espaciosAmfiteatro = new String[200];
    static String[] espaciosVIP = new String[25];

    PRU03E06_Ivan_Cabellos(int numEntrades){
        this.numEntradesAComprar = numEntrades;
    }

    PRU03E06_Ivan_Cabellos(int numEntrades, String nomReserva) {
        this.numEntradesAComprar = numEntrades;
        this.nomReserva = nomReserva;
    }

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
                        espaciosVIP[i] = String.valueOf(this.nomReserva);
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
                        espaciosAmfiteatro[i] = String.valueOf(this.nomReserva);
                        posicionsReservades[j] = i + 1;
                    }
                    break;
                }
            }

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

    /*public void setPosEntradaAmfi() throws Exception {
        try{
            int numEntradasAColocar = this.numEntradesAComprar;
            posicionsReservades = new int[numEntradasAColocar];
            for (int i = 0; i < espaciosAmfiteatro.length; i++) {
                if (espaciosAmfiteatro[i] == null){
                    for (int j = 0; j < numEntradasAColocar; j++, i++) {
                        espaciosAmfiteatro[i] = String.valueOf(this.nomReserva);
                        posicionsReservades[j] = i + 1;
                    }
                    break;
                }
            }
        }catch (Exception e){
            throw new Exception("No hay suficientes entradas para todos en el amfiteatro");
        }
    }
    */
    public void setPosEntradaPlat(){

    }

}
