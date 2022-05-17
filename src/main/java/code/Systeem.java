package code;

import java.util.ArrayList;
import java.util.Scanner;

public class Systeem {
    Scanner scanner = new Scanner(System.in);

    ArrayList<Medewerker> medewerkers;
    ArrayList<Product> producten;
    ArrayList<Product> verhuur;

    public Systeem() {
        this.medewerkers = new ArrayList<>();
        this.producten = new ArrayList<>();
        this.verhuur = new ArrayList<>();
    }

    public ArrayList<Medewerker> getMedewerkers() {
        return medewerkers;
    }

    public ArrayList<Product> getProducten() {
        return producten;
    }

    public ArrayList<Product> getVerhuur() {
        return verhuur;
    }

    public void addMedewerker(String vn, String an, String ww ){
        medewerkers.add(new Medewerker(vn, an, medewerkers.size(), ww));
    }

    public void addVerhuur(int prodnr){
        Product p = getProduct(prodnr);
        if(p != null) {
            verhuur.add(p);
        }
    }

    public void addProduct(Product p) {
        producten.add(p);
    }

    public Medewerker loginCheck(int gn, String ww){
        for(Medewerker m: medewerkers){
            if(gn == m.medcode && ww.equals(m.ww)) {
                return m;
            }
        }
        return null;
    }

    public Product getProduct(int prodnr) {
        for (Product p : producten) {
            if (prodnr == p.prodnr) {
                return p;
            }
        }
        return null;
    }

    public Boolean isVerhuurd(int prod){
        for (Product p : verhuur) {
            if (prod == p.prodnr) {
                return true;
            }
        }
        return false;
    }

    public double berekenPrijs(int prod, int dag, boolean vz) {
        double tot = getProduct(prod).prijs * dag;
        if(vz){
            tot += getProduct(prod).verzekering * dag;
        }
        return tot;
    }
}
