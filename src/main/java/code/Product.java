package code;

import java.io.FileNotFoundException;
import java.util.Observable;

public abstract class Product extends Observable implements ISwitchable {

    Store s = Store.getInstance();

    private Object[] verhuurdAan;
    private String naam;
    private String merk;
    private boolean opVoorraad;

    public Product(Store s, String naam, String merk) throws FileNotFoundException {
        this.naam = naam;
        this.merk = merk;
        s.getProducten().add(this);
        //s.getVerhuurd().add(this);
        setOpVerhuurd(false, null, null);
    }

    public String getMerk() {
        return merk;
    }

    public String getNaam() {
        return naam;
    }

    public Object[] getVerhuurdAan() {
        return verhuurdAan;
    }

    public boolean verhuurd(){
        return s.getVerhuurd().contains(this);
    }

    public void setOpVerhuurd(boolean status, Medewerker med, Klant klant){

        if(status && klant != null){
            s.verhuurd.add(this);
            verhuurdAan = new Object[]{med, klant};
        } else if(!status){
            s.verhuurd.remove(this);
            verhuurdAan = new Object[]{};
        } else {
            System.out.println("FOUTMELDING, GEEN NAAM");
        }

        if(status && klant != null){
            if(!s.getVerhuurd().contains(this)){
                s.verhuurd.add(this);
                verhuurdAan = new Object[]{med, klant};
            }
        }else if (status){
            s.getVerhuurd().remove(this);
        } else {

        }
        this.opVoorraad = status;
        setChanged();
        notifyObservers();
    }

    public abstract String getTot();

    public abstract double berekenPrijs(Boolean verzekering);

}
