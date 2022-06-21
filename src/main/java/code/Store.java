package code;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Store {
    private static Store singleton = null;

    public ArrayList<Product> verhuurd;
    public List<Product> producten;
    public List<Medewerker> medewerkers;


    private Store() {
        this.verhuurd = new ArrayList<>();
        this.producten = new ArrayList<>();
        this.medewerkers = new ArrayList<>();
    }

    public static Store getInstance() throws FileNotFoundException{
        if(singleton == null){
            return singleton = new Store();
        }
        return singleton;
    }

    public ArrayList<Product> getVerhuurd(){
        return verhuurd;
    }

    public List<Product> getProducten(){return producten;}

    public String login(String code, String ww){
        return "X";
    }
}

//this.voorraad.add(new Boor("FHX", "XL7000"));
//        this.voorraad.add(new Auto("VW", 800));