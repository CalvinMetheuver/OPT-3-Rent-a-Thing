package code;

import java.io.FileNotFoundException;

public class AutoFactory extends ProductFactory{
    @Override
    public Product createProduct(String merk, String type, int kg, int cc) throws FileNotFoundException {
        return new Auto(merk, kg, cc);
    }
}
