package code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SysteemTest {

    Systeem dbs;

    @BeforeEach
    void BeforeAll(){
        dbs = new Systeem();
    }

    @Test
    void addMedewerker() {
        assertEquals(0, dbs.getMedewerkers().size());
        dbs.addMedewerker("Cal", "Met", "WW");
        assertEquals(1, dbs.getMedewerkers().size());
    }

    @Test
    void addVerhuur() {
        assertEquals(0, dbs.getVerhuur().size());
        dbs.addProduct(new Boor(4, "Bosch", "XL12"));
        dbs.addVerhuur(4);
        assertEquals(1, dbs.getVerhuur().size());
    }

    @Test
    void addProduct() {
        assertEquals(0, dbs.getProducten().size());
        dbs.addProduct(new Boor(4, "Bosch", "XL12"));
        assertEquals(1, dbs.getProducten().size());
    }

    @Test
    void loginCheck() {
        dbs.addMedewerker("Cal", "met", "ww");
        dbs.addMedewerker("Calvin", "metheuver", "xoxo");
        assertEquals(dbs.medewerkers.get(0),dbs.loginCheck(0,"ww"));
        assertEquals(dbs.medewerkers.get(1),dbs.loginCheck(1,"xoxo"));
    }

    @Test
    void isVerhuurd() {
        assertFalse(dbs.isVerhuurd(3));
        dbs.addProduct(new Boor(3, "Bso", "HH"));
        assertFalse(dbs.isVerhuurd(3));
        dbs.addVerhuur(3);
        assertTrue(dbs.isVerhuurd(3));
    }

    @Test
    void berekenPrijs() {
        dbs.addProduct(new Boor(9, "Bosch", "CL"));
        //5 eu per dag + 1/dag vz
        assertEquals(5 ,dbs.berekenPrijs(9, 1, false, false));
        assertEquals(50 ,dbs.berekenPrijs(9, 10, false, false));
        assertEquals(6 ,dbs.berekenPrijs(9, 1, true, false));
        assertEquals(60 ,dbs.berekenPrijs(9, 10, true, false));
        assertEquals(5 ,dbs.berekenPrijs(9, 1, false, true));
        assertEquals(20 ,dbs.berekenPrijs(9, 4, false, true));
        assertEquals(23.75 ,dbs.berekenPrijs(9, 5, false, true));
        assertEquals(42.75 ,dbs.berekenPrijs(9, 9, false, true));
        assertEquals(45 ,dbs.berekenPrijs(9, 10, false, true));
        assertEquals(63 ,dbs.berekenPrijs(9, 14, false, true));
        assertEquals(405 ,dbs.berekenPrijs(9, 90, false, true));
    }

    @Test
    void verhuring(){
        dbs.addMedewerker("C", "M", "ww");
        dbs.addProduct(new Boor(2, "HBO", "XL"));
        dbs.addVerhuur(2);
        assertTrue(dbs.verhuring(0, "ww", 2, 3, true));
    }
}