package code;

import java.io.FileNotFoundException;

public class Boor extends Product {
    private String type;
    public Boor(Store s, String merk, String type) throws FileNotFoundException {
        super(s, "Boor", merk);
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
    public void teruggebracht() {
        System.out.println(this.getTot() +  " is weer beschikbaar");
    }

    @Override
    public void uitgeleend() {
        System.out.println(this.getTot() +  " is niet meer beschikbaar");
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
