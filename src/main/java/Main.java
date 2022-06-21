import code.*;

import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    private Boolean inStore = true;
    private ISwitchable p;
/*
    {
        try {
            //p = new ProductFactory(Store.getInstance()).getProduct());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
 */


    private void status(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("e(xit)/enter");
        String inv = scanner.nextLine();

        while(!inv.equals("e")){
            if (inStore){
                p.uitgeleend();
            } else{
                p.teruggebracht();
            }
            inStore = !inStore;
            inv = scanner.nextLine();
        }
        System.out.println("UIT");
    }

    public static void seed(Store s) throws FileNotFoundException {
        ProductFactory.AUTO_FACTORY.createProduct("Merrie", "", 900,80);
        ProductFactory.BOOR_FACTORY.createProduct("Bosch", "XL090", 900,90);
        ProductFactory.VRACHTWAGEN_FACTORY.createProduct("Mercedes", "", 9000, 800);
        new Auto("Mercedes",900);
        new Vrachtwagen("Volkswagen",300, 1900);
        new Boor( "Bosch", "X780");
        new Medewerker( "Calvin", "Metheuver", 3, "ww");
        new Klant("Karen", "Klein");
    }

    public static void getInventory(){
            //System.out.println(p.getProdnr()+1 + "-" + p.getNaam());

    }

    public static int menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wat wilt u huren:");
        //getInventory();
        int menu = scanner.nextInt();
        scanner.nextLine();
        return menu;
    }



    public static void main(String[] args) throws FileNotFoundException{
        Store s = Store.getInstance();
        seed(Store.getInstance());

        //s.producten.get(0).setOpVerhuurd(false);

        JavaFXApp.main(args);

        /*
        Scanner scanner = new Scanner(System.in);
        seed();

        System.out.println("STOP");


        int menu = menu();
        while(menu > 0){
            if(menu == 8){
                new Main().status();
            }else {
                /*
                Product p = p.getVoorraad().get(menu - 1);
                String order = p.verhuur();
                System.out.println(order);
                System.out.println();

            }
            menu = menu();
        }
        */
    }
}


    /*
    Scanner scanner = new Scanner(System.in);
    Systeem dbs = new Systeem();

        dbs.addMedewerker("Calvin", "Metheuver", "ww");
        dbs.addProduct(new Boor(1, "Bosch", "XO123"));
        dbs.addProduct(new Boor(2, "Makita", "HP457"));

        dbs.addVerhuur(1);
        dbs.addVerhuur(6);

        System.out.println(dbs.getProduct(1).berekenPrijs(6));

        menu(dbs);

        System.out.println("Wat is uw gebruikersnaam?");
        int gn = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Wat is uw ww?");
        String ww = scanner.nextLine();


        if(dbs.loginCheck(gn, ww) != null){
            System.out.println("Welkom " + dbs.loginCheck(gn, ww).getVoornaam());
            int keuze = 1;
            while(keuze != 0){


            }
        } else {
            System.out.println("Inloggen is niet gelukt");
        }
     */

/*
public static void menu(Systeem s){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wat wilt u doen?");
        System.out.println("1) product verhuren");
        System.out.println("2) product toevoegen");

        int keuze = scanner.nextInt();
        scanner.nextLine();

        switch (keuze) {
            case 1:

                System.out.println(s.getProducten());
                System.out.println("Welk product");
                int prod = scanner.nextInt();
                scanner.nextLine();
                s.addVerhuur(prod);
                System.out.println("Hoeveel dagen");
                int dag = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Verzekering?");
                int vz = scanner.nextInt();
                scanner.nextLine();
                if(vz == 0){
                    System.out.println(s.berekenPrijs(prod, dag, false));
                }else{
                System.out.println(s.berekenPrijs(prod, dag, true));
                }

        }
 */
