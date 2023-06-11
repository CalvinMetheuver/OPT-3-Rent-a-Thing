package code;

import java.io.FileNotFoundException;

public class VrachtwagenFactory extends ProductFactory {
    @Override
    public Product createProduct(String merk, String type, int kg, int cc) throws FileNotFoundException {
        return new Vrachtwagen(merk, kg, cc);
    }
}
