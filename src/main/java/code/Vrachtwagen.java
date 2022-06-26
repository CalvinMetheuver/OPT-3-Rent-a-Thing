package code;

import java.io.FileNotFoundException;

public class Vrachtwagen extends Product {

    private int laadvermogen;
    private int gewicht;

    public Vrachtwagen(String merk, int laadvermogen, int gewicht) throws FileNotFoundException {
        super("Vrachtwagen", merk);
        this.laadvermogen = laadvermogen;
        this.gewicht = gewicht;
    }

    public int getLaadvermogen() {
        return laadvermogen;
    }

    public int getGewicht() {
        return gewicht;
    }


    @Override
    public String getTot() {
        return getNaam() + " - " + getMerk() + " - " + getLaadvermogen() + " - " + getGewicht();
    }

    @Override
    public double berekenPrijs(Boolean verzekering) {
        if(verzekering){
            return laadvermogen*0.10 + gewicht * 0.01;
        }
        return laadvermogen*0.10;
    }

    @Override
    public void teruggebracht() {

    }

    @Override
    public void uitgeleend() {

    }
}
