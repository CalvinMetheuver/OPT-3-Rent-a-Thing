import code.*;
import java.io.FileNotFoundException;

public class Main {

    public static void seed(Store s) throws FileNotFoundException {
        new Boor( "Bosch", "UniversalDrill18");
        new Boor( "VONROC", "12V Li-Ion");
        new Boor( "Makita", "HP457DWE10");
        new Auto("Mercedes",900);
        new Auto("BMW", 1320);
        new Auto("Audi", 1020);
        new Vrachtwagen("Mercedes",21000, 11000);
        new Vrachtwagen("Volvo",9350, 8600);
        new Vrachtwagen("Volvo",15000, 13000);
        new Medewerker( "Calvin", "Metheuver", 1, "ww");
        new Medewerker( "Justin", "de Groot", 2, "wachtwoord");
        new Medewerker( "Dre", "DR", 3, "DRDre");
    }

    public static void main(String[] args) throws FileNotFoundException{
        seed(Store.getInstance());

        JavaFXApp.main(args);
    }
}