package code;

import java.io.FileNotFoundException;

public class Boor extends Product {
    private String type;
    public Boor(String merk, String type) throws FileNotFoundException {
        super("Boor", merk);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String getTot() {
        return getNaam() + " - " + getMerk() + " - " + getType();
    }

    @Override
    public double berekenPrijs(Boolean verzekering) {
        if(verzekering){
            return 5+1;
        }else{
            return 5;
        }
    }
}
