package code;

import java.io.FileNotFoundException;

public class Medewerker {
    private Store s;
    {
        try {
            s = Store.getInstance();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private final String voornaam;
    private final String achternaam;
    int medcode;
    String ww;
    Boolean actief;

    public Medewerker(String voornaam, String achternaam, int medcode, String ww) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.medcode = medcode;
        this.ww = ww;
        s.addMedewerkerToStore(this);
        actief = false;
    }

    public void setActief(Boolean actief) {
        this.actief = actief;
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

