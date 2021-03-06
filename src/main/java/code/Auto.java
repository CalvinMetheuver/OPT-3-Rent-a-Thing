package code;

import java.io.FileNotFoundException;

public class Auto extends Product {

    private int gewicht;

    public Auto(String merk, int gewicht) throws FileNotFoundException {
        super("Auto", merk);
        this.gewicht = gewicht;
    }

    public int getGewicht() {
        return gewicht;
    }

    @Override
    public String getTot() {
        return getNaam() + " - " + getMerk() + " - " + getGewicht();
    }

    @Override
    public double berekenPrijs(Boolean verzekering) {

        if(verzekering){
            return 50 + gewicht * 0.01;
        } else{
            return 50;
        }
    }
}
