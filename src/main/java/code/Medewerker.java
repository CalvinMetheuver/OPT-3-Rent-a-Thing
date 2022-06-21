package code;

public class Medewerker {
    private final String voornaam;
    private final String achternaam;
    int medcode;
    String ww;

    public Medewerker(Store s, String voornaam, String achternaam, int medcode, String ww) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.medcode = medcode;
        this.ww = ww;
        s.medewerkers.add(this);
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

