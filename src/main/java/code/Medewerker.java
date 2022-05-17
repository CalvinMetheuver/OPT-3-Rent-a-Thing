package code;

public class Medewerker {
    private final String voornaam;
    private final String achternaam;
    int medcode;
    String ww;

    public Medewerker(String voornaam, String achternaam, int medcode, String ww) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.medcode = medcode;
        this.ww = ww;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public int getMedcode() {
        return medcode;
    }

    public String getWw() {
        return ww;
    }
}

