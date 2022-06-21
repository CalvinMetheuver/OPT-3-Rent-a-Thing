package code;

import java.io.FileNotFoundException;

public class AutoFactory extends ProductFactory{
    @Override
    public Product createProduct(String merk, String type, int gewicht, int lv) throws FileNotFoundException {
        return new Auto(merk, gewicht);
    }
}
