package org.example.app;

import org.example.hello.Hello;
import org.example.world.World;

public class App {
    public static void main(String[] args) {
        Hello.hello();
        World.world();
//        try {
//            World world = new World("Korea");
//            Class<?> worldClass = Class.forName("io.jayground8.hello.internal.World");
//            Field countryField = worldClass.getDeclaredField("country");
//            countryField.setAccessible(true);
//            countryField.set(world, "USA");
//            System.out.println(world.getCountry());
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    }
}
