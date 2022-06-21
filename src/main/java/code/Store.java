package code;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Store implements Observer{
    private static Store singleton = null;
    private final List<Observer> listeners = new ArrayList<Observer>();


    public void addObserver(Observer observer){
        listeners.add(observer);
    }

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

    public Medewerker login(int code, String ww){
        for(Medewerker m: medewerkers){
            if ((m.getMedcode() ==code) && m.getWw().equals(ww)){
                return m;
            }
        }
        return null;

    }

    @Override
    public void update(Observable o, Object arg) {
        notifyAll();
    }
}

//this.voorraad.add(new Boor("FHX", "XL7000"));
//        this.voorraad.add(new Auto("VW", 800));