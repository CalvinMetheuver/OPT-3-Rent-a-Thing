package code;

import java.io.FileNotFoundException;
import java.util.Scanner;

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
    public static final AutoFactory AUTO_FACTORY = new AutoFactory();
    public static final VrachtwagenFactory VRACHTWAGEN_FACTORY = new VrachtwagenFactory();

    public abstract Product createProduct(String merk, String type, int gewicht, int lv) throws FileNotFoundException;
}