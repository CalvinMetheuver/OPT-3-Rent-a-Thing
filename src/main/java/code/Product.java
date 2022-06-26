package code;

import java.io.FileNotFoundException;
import java.util.Observable;

public abstract class Product extends Observable{
    Store s = Store.getInstance();

    private String naam;
    private String merk;
    private Medewerker m;
    private Klant k;

    public Product(String naam, String merk) throws FileNotFoundException {
        this.naam = naam;
        this.merk = merk;
        this.m = null;
        this.k = null;
        s.getProducten().add(this);
        setOpVerhuurd(false, null, null);
    }

    public String getMerk() {
        return merk;
    }

    public String getNaam() {
        return naam;
    }

    public Medewerker getMedewerker() {
        return m;
    }

    public Klant getKlant() {
        return k;
    }

    public boolean verhuurd(){
        return s.getVerhuurd().contains(this);
    }

    public void setOpVerhuurd(boolean status, Medewerker med, Klant klant){
        if(status && klant != null){
            s.verhuurd.add(this);
            m = med;
            k = klant;
        } else if(!status){
            s.verhuurd.remove(this);
            m = null;
            k = null;
        } else {
            System.out.println("FOUTMELDING, GEEN NAAM");
        }
        setChanged();
        notifyObservers();
    }

    public abstract String getTot();

    public abstract double berekenPrijs(Boolean verzekering);


}
