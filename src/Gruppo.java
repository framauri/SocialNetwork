import java.io.File;
import java.util.ArrayList;

public class Gruppo {
    private String nome;
    private String topic;
    private ArrayList<Utente> iscritti = new ArrayList<>();
    private ArrayList<Pubblicazione> listaPubblicazioni = new ArrayList<>();
    private String path = this.getNome();
    File file = new File(path +" gruppo.txt");

    public Gruppo(String nome, String topic) {
        this.nome = nome;
        this.topic = topic;
    }

    public Gruppo() {
    }


    public String getNome () {
        return nome;
    }

    public void setNome ( String nome ) {
        this.nome = nome;
    }

    public String getTopic () {
        return topic;
    }

    public void setTopic ( String topic ) {
        this.topic = topic;
    }

    public ArrayList<Pubblicazione> getListaPubblicazioni () {
        return listaPubblicazioni;
    }

    public void setListaPubblicazioni ( ArrayList<Pubblicazione> listaPubblicazioni ) {
        this.listaPubblicazioni = listaPubblicazioni;
    }

    public File getFile () {
        return file;
    }

    public void setFile ( File file ) {
        this.file = file;
    }
}
