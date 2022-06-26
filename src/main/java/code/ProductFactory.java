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





    /*
    public ProductFactory(Store s) {
        this.s = s;
    }

    public static ISwitchable getProduct() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Kies Product(A/V/B)");
        String pr = scanner.nextLine();

        if(pr.equals("A")){
            System.out.println("Van welk merk is de auto?");
            String merk = scanner.nextLine();
            System.out.println("Hoeveel weegt de auto?");
            int gewicht = scanner.nextInt();
            scanner.nextLine();
            return new Auto(s, merk, gewicht);

        }else if(pr.equals("B")){
            System.out.println("Van welk merk is de boor?");
            String merk = scanner.nextLine();
            System.out.println("Wat voor type is de boor?");
            String type = scanner.nextLine();
            return new Boor(s, merk, type);

        }else if(pr.equals("V")){
            System.out.println("Van welk merk is de vrachtwagen?");
            String merk = scanner.nextLine();
            System.out.println("Wat is het laadvermogen van de vrachtwagen?");
            int laadvermogen = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Wat is het gewicht van de vrachtwagen?");
            int gewicht = scanner.nextInt();
            scanner.nextLine();
            return new Vrachtwagen(s, merk, laadvermogen, gewicht);
        }else{
            return null;
        }


    }

     */
}
