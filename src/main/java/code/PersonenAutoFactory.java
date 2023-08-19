package code;

import java.io.FileNotFoundException;

public class PersonenAutoFactory extends ProductFactory{
    @Override
    public Product createProduct(String merk, String type, int kg, int cc) throws FileNotFoundException {
        return new PersonenAuto(merk, kg, cc);
    }
}
