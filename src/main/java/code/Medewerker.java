package code;

import java.io.FileNotFoundException;

public class Medewerker extends Gebruiker {
    private Store s;
    {
        try {
            s = Store.getInstance();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private int medcode;
    private String ww;
    Boolean actief;

    public Medewerker(String voornaam, String achternaam, int medcode, String ww) {
        super(voornaam, achternaam);
        this.medcode = medcode;
        this.ww = ww;
        s.addMedewerkerToStore(this);
        actief = false;
    }

    public void setActief(Boolean actief) {
        this.actief = actief;
    }

    public String getVoornaam() {
        return super.getVnaam();
    }

    public String getAchternaam() {
        return super.getAnaam();
    }

    public int getMedcode() {
        return medcode;
    }

    public String getWw() {
        return ww;
    }
}

