package code;

import java.io.FileNotFoundException;

public abstract class ProductFactory {

    private static Store s;

    static {
        try {
            s = Store.getInstance();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static final BoorFactory BOOR_FACTORY = new BoorFactory();
    public static final PersonenAutoFactory AUTO_FACTORY = new PersonenAutoFactory();
    public static final VrachtwagenFactory VRACHTWAGEN_FACTORY = new VrachtwagenFactory();

    public abstract Product createProduct(String merk, String type, int kg, int cc) throws FileNotFoundException;
}