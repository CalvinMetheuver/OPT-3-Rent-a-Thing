package code;

public class Boor extends Product {
    String merk;
    String type;

    public Boor(int prodnr, String merk, String type) {
        super(prodnr, 5, 1);
        this.merk = merk;
        this.type = type;
    }

    @Override
    double verzekering() {
        return 0;
    }
}
