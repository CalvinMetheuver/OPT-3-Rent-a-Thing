package code;

public class Gebruiker {
    private String vnaam;
    private String anaam;

    public Gebruiker(String vnaam, String anaam) {
        this.vnaam = vnaam;
        this.anaam = anaam;
    }

    public String getVnaam() {
        return vnaam;
    }

    public String getAnaam() {
        return anaam;
    }
}
