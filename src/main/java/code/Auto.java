package code;

import java.io.FileNotFoundException;

public abstract class Auto extends Product{
    private int cc;

    public Auto(String naam, String merk, int cc) throws FileNotFoundException {
        super(naam, merk);
        this.cc = cc;
    }
}
