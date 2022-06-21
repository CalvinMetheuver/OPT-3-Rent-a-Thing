package code;

import java.io.FileNotFoundException;

public class BoorFactory extends ProductFactory {
    @Override
    public Product createProduct(String merk, String type, int gewicht, int lv) throws FileNotFoundException {
        return new Boor(merk, type);
    }
}
