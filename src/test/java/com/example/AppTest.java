package com.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class AppTest{

    @Test
    public void testParking() throws Exception {
        Parking parking = new Parking();
        parking.init();
        parking.addAuthorizedCar("AA-123-AA");
        parking.addAuthorizedCar("BB-123-BB");
        parking.addAuthorizedCar("CC-123-CC");

        parking.carParked(0, "AA-123-AA");
        parking.carParked(1, "BB-123-BB");
        parking.carParked(2, "CC-123-CC");

        parking.carLeaved(1);

        assertTrue(parking.getAmountCarParked() == 2);

        assertTrue(parking.canPark("AA-123-AA") == false);
        assertTrue(parking.canPark("BB-123-BB") == true);

        assertTrue(parking.isCarParked("AA-123-AA") == true);
        assertTrue(parking.isCarParked("BB-123-BB") == false);
        assertTrue(parking.isCarParked("CC-123-CC") == true);
    }

    @Test
    public void vehiculeAutorisesVide_ajouterVehiculeAutorise_devraitAjouterVehicule() {
        /// AAA : Arrange Act Assert
        // Arrange
        Parking parking = new Parking();
        // Act
        parking.addAuthorizedCar("AA-123-AA");
        // Assert
        assertTrue(parking.getAuthorizedCars().contains("AA-123-AA"));
    }

    @Test
    public void vehiculeAutorisesVide_AjouterDoublonVehicule_devraitAjouterUnique() {
        /// AAA : Arrange Act Assert
        // Arrange
        Parking parking = new Parking();
        // Act
        parking.addAuthorizedCar("AA-123-AA");
        parking.addAuthorizedCar("AA-123-AA");
        // Assert
        assertTrue(parking.getAuthorizedCars().size() == 1);
    }

    @Test
    public void vehiculeAutoriseDansLaListe_ajouterAutreVehicule_devraitAvoirDeux () {
        /// AAA : Arrange Act Assert
        // Arrange
        Parking parking = new Parking();
        // Act
        parking.addAuthorizedCar("AA-123-AA");
        parking.addAuthorizedCar("BB-123-BB");
        // Assert
        assertTrue(parking.getAuthorizedCars().size() == 2);
    }

    @Test
    public void vehiculeAutoriseDansLaListe_SupprimerVehicule_devraitEtreVide () {
        ///AAA
        // Arrange 
        Parking parking = new Parking();
        // Act
        parking.addAuthorizedCar("AA-123-AA");
        parking.removeAuthorizedCar("AA-123-AA");
        // Assert
        assertTrue(parking.getAuthorizedCars().size() == 0);
    }

    @Test
    public void parkingPlein_ajouterVehiculeAutorise_devraitAjouterVehicule() {
        /// AAA : Arrange Act Assert
        // Arrange
        Parking parking = new Parking();
        // Act
        for (int i = 0; i < parking.capacity; i++) {
            parking.parked.put(Integer.toString(i), "");
        }
        parking.addAuthorizedCar("AA-123-AA");
        // Assert
        assertTrue(parking.getAuthorizedCars().contains("AA-123-AA"));
    }

        @Test
    public void parkingPlein_vehiculeVeutEntrer_devraitPasOuvrir(){
        /// AAA : Arrange Act Assert
        // Arrange
        Parking parking = new Parking();
        // Act
        for (int i = 0; i < parking.capacity; i++) {
            parking.authorizedCars.add("AA-0"+i+"-AA");
            parking.parked.put(Integer.toString(i), "AA-0"+i+"-AA");
        }

        parking.authorizedCars.add("AA-100-AA");
        // Assert
        assertFalse(parking.canPark("AA-100-AA"));
    }

    @Test
    public void parkingPlein_vehiculeDoublonVeutEntrer_devraitPasOuvrir(){
        /// AAA : Arrange Act Assert
        // Arrange
        Parking parking = new Parking();
        // Act
        for (int i = 0; i < parking.capacity; i++) {
            parking.authorizedCars.add("AA-0"+i+"-AA");
            parking.parked.put(Integer.toString(i), "AA-0"+i+"-AA");
        }
        // Assert
        assertFalse(parking.canPark("AA-012-AA"));
    }

}
