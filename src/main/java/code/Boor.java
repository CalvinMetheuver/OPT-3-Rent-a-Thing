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
    protected double basisPrijs() {
        return 5;
    }

    @Override
    protected double extraPrijs(Boolean verzekering) {
        if(verzekering){
            return 1;
        }
        return 0;
    }
}
