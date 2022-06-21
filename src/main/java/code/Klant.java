package code;

public class Klant {
    private final String vnaam;
    private final String anaam;

    public Klant(String v, String a) {
        this.vnaam = v;
        this.anaam = a;
    }

    public String getVnaam() {
        return vnaam;
    }

    public String getAnaam() {
        return anaam;
    }
}
