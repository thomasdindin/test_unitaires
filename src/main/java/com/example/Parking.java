package com.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Parking {
    
    // La liste des voitures autorisées
    ArrayList<String> authorizedCars = new ArrayList<String>();
    // La liste des voitures garées
    HashMap<String, String> parked = new HashMap<String, String>();
    // La capacité maximale du parking
    int capacity = 50;

    public void init() {
        for (int i = 0; i < capacity; i++) {
            parked.put(Integer.toString(i), "");
        }
    }

    public void carParked(int place, String car) {
        parked.put(Integer.toString(place), car);
        System.out.println("Car " + car + " parked at place " + place);
    }

    public void carLeaved(int place) {
        System.out.println("Car " + parked.get(Integer.toString(place)) + " left place " + place);
        parked.put(Integer.toString(place), "");
    }

    public boolean isCarParked(String car) {
        return parked.containsValue(car);
    }

    public boolean canPark(String car) {
    return authorizedCars.contains(car) && !isCarParked(car) && parked.containsValue("");
    }

    public ArrayList<String> getCarParked () {
        ArrayList<String> cars = new ArrayList<String>();
        for (String car : parked.values()) {
            if (car != "") {
                cars.add(car);
            }
        }
        return cars;
    }

    public void addAuthorizedCar(String car) {
        if (!authorizedCars.contains(car)) authorizedCars.add(car);
    }

    public void removeAuthorizedCar(String car) {
        if (authorizedCars.contains(car)) authorizedCars.remove(car);
    }

    public int getAmountCarParked() {
        return getCarParked().size();
    }
    
    public ArrayList<String> getAuthorizedCars() {
        return authorizedCars;
    }

    public int getTauxRemplissage() {
        return capacity*100/getAmountCarParked();
    }
}
