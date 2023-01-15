package org.example.world;

public class World {
    private String country;

    public World() {
    }

    public World(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public static void world() {
        System.out.println("world2");
    }
}