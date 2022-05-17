package code;

public abstract class Product {
    int prodnr;
    double prijs;
    double verzekering;

    public Product(int prodnr, double prijs, double verzekering) {
        this.prodnr = prodnr;
        this.prijs = prijs;
        this.verzekering = verzekering;
    }

    final double berekenPrijs(int dag){
        double totPrijs = prijs * dag;
        if(verzekerd()){
            totPrijs+=verzekering();
        }
        return totPrijs;
    }

    abstract double verzekering();

    boolean verzekerd(){return false;}
}
