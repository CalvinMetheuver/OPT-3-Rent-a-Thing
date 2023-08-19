package code;

import java.io.FileNotFoundException;

public class PersonenAuto extends Product {

    private int gewicht;
    private int cc;

    public PersonenAuto(String merk, int gewicht, int cc) throws FileNotFoundException {
        super("Auto", merk);
        this.gewicht = gewicht;
        this.cc = cc;
    }

    public int getGewicht() {
        return gewicht;
    }
    public int getCC() {
        return cc;
    }

    @Override
    public String getTot() {
        return getNaam() + " - " + getMerk() + " - " + getGewicht() + " KG - " + getCC() + " CC";
    }

    @Override
    protected double basisPrijs() {
        return 50;
    }

    @Override
    protected double extraPrijs(Boolean verzekering) {
        if(verzekering) {
            return cc * 0.01;
        }
         return 0;
    }
}
