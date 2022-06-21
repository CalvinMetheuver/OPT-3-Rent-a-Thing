package code;

import java.io.FileNotFoundException;

public class VrachtwagenFactory extends ProductFactory {
    @Override
    public Product createProduct(String merk, String type, int gewicht, int lv) throws FileNotFoundException {
        return new Vrachtwagen(merk, lv, gewicht);
    }
}
