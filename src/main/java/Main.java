import code.Boor;
import code.Medewerker;
import code.Systeem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Systeem dbs = new Systeem();

        dbs.addMedewerker("Calvin", "Metheuver", "ww");
        dbs.addProduct(new Boor(1, "Bosch", "XO123"));
        dbs.addProduct(new Boor(2, "Makita", "HP457"));

        dbs.addVerhuur(1);
        dbs.addVerhuur(6);

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

        //JavaFXApp.main(args);
    }

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
                    System.out.println(s.berekenPrijs(prod, dag, false, false));
                }else{
                System.out.println(s.berekenPrijs(prod, dag, true, false));
                }

        }
    }
}
