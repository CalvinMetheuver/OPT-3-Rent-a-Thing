package code;

import java.io.FileNotFoundException;

public class Auto extends Product {

    private int gewicht;
    private int cc;

    public Auto(String merk, int gewicht, int cc) throws FileNotFoundException {
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
    public double berekenPrijs(Boolean verzekering) {

        if(verzekering){
            return 50 + cc * 0.01;
        } else{
            return 50;
        }
    }
}
