public class Utente {
    private String nome;
    private String cognome;
    private String username;
    private String email;
    private String password;

    public Utente ( String nome, String cognome, String username, String email, String password ) {
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Utente () {

    }

    public String getPassword () {
        return password;
    }

    public void setPassword ( String password ) {
        this.password = password;
    }


    public String getNome () {
        return nome;
    }

    public void setNome ( String nome ) {
        this.nome = nome;
    }

    public String getCognome () {
        return cognome;
    }

    public void setCognome ( String cognome ) {
        this.cognome = cognome;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail ( String email ) {
        this.email = email;
    }

    public String getUsername () {
        return username;
    }

    public void setUsername ( String username ) {
        this.username = username;
    }

    public int authentication(String mail, String pass) {
        if (mail.equals(this.email) && pass.equals(this.password)) {
            return 1;
        }
        else {
            return 0;
        }
    }

    @Override
    public String toString () {
        return "Utente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Gruppo cercaGruppo (String nomeGruppo) {
        for (Gruppo g : Social.getListaGruppi()){
            if (g.getNome().equalsIgnoreCase(nomeGruppo)) {
                Social.getListaUtenti().add(this);
                return g;
            }
        }
        return null;
    }

    public int scriviMess (String nomeGruppo, String testo){
        Gruppo g = cercaGruppo(nomeGruppo);
        Messaggio m = new Messaggio(testo);
        g.getListaPubblicazioni().add(new Pubblicazione(this, m));
        return 1;
    }
}
