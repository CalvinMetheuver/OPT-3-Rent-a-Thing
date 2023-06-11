package code;

import java.io.FileNotFoundException;

public class Vrachtwagen extends Product {

    private int laadvermogen;
    private int cc;

    public Vrachtwagen(String merk, int laadvermogen, int cc) throws FileNotFoundException {
        super("Vrachtwagen", merk);
        this.laadvermogen = laadvermogen;
        this.cc = cc;
    }

    public int getLaadvermogen() {
        return laadvermogen;
    }

    public int getCc(){return cc;}


    @Override
    public String getTot() {
        return getNaam() + " - " + getMerk() + " - " + getLaadvermogen() + " KG - "+getCc()+ " CC";
    }

    @Override
    public double berekenPrijs(Boolean verzekering) {
        if(verzekering){
            return laadvermogen*0.10 + cc * 0.01;
        }
        return laadvermogen*0.10;
    }
}
