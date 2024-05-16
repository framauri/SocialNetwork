import java.util.ArrayList;

public class Social {
    private static ArrayList<Utente> listaUtenti = new ArrayList<Utente>();
    private static ArrayList<Gruppo> listaGruppi = new ArrayList<Gruppo>();

    private static Social istanza;

    private Social () {
    }

    public static Social getInstance () {
        if (istanza == null) {
            istanza = new Social();
        }

        return istanza;
    }

    public static ArrayList<Utente> getListaUtenti () {
        return listaUtenti;
    }

    public static void setListaUtenti ( ArrayList<Utente> listaUtenti ) {
        Social.listaUtenti = listaUtenti;
    }

    public static ArrayList<Gruppo> getListaGruppi () {
        return listaGruppi;
    }

    public static void setListaGruppi ( ArrayList<Gruppo> listaGruppi ) {
        Social.listaGruppi = listaGruppi;
    }
}
