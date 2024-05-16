import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pubblicazione {
    LocalDateTime ora = LocalDateTime.now();
    Utente utente;
    Messaggio messaggio;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    String dataPubb;

    public Pubblicazione () {
    }

    public Pubblicazione ( Utente utente, Messaggio messaggio ) {
        this.utente = utente;
        this.messaggio = messaggio;
        this.dataPubb = formatter.format(LocalDateTime.now());
    }

    public Utente getUtente () {
        return utente;
    }

    public void setUtente ( Utente utente ) {
        this.utente = utente;
    }

    public Messaggio getMessaggio () {
        return messaggio;
    }

    public void setMessaggio ( Messaggio messaggio ) {
        this.messaggio = messaggio;
    }

    public String getDataPubb () {
        return dataPubb;
    }

    public void setDataPubb ( String dataPubb ) {
        this.dataPubb = dataPubb;
    }

    public void writePub(Pubblicazione p, Gruppo g){
        File f = g.getFile();
        try {
            FileWriter fw = new FileWriter(f, true);
            fw.write(p.toString());
            fw.flush();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
