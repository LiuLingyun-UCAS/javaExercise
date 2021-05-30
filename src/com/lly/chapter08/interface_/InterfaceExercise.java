package com.lly.chapter08.interface_;

/**
 * @author 刘凌云
 * @version 1.0
 */
public class InterfaceExercise {
    public static void main(String[] args) {
        Person person = new Person("唐僧", VehiclesFactory.getHorse());
        person.passRiver();
        person.ride();
    }
}

interface Vehicles {
    void work();
}

class Horse implements Vehicles {
    @Override
    public void work() {
        System.out.println("平时骑马");
    }
}

class Boat implements Vehicles {
    @Override
    public void work() {
        System.out.println("过河用船");
    }
}

class VehiclesFactory {
    private static final Horse horse = new Horse();
    private static final Boat boat = new Boat();

    private VehiclesFactory() {

    }

    public static Horse getHorse() {
        return horse;
    }

    public static Boat getBoat() {
        return boat;
    }
}

class Person {
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public void passRiver() {
        if (!(vehicles instanceof Boat)) {
            vehicles = VehiclesFactory.getBoat();
        }
        vehicles.work();
    }

    public void ride() {
        if (!(vehicles instanceof Horse)) {
            vehicles = VehiclesFactory.getHorse();
        }
        vehicles.work();
    }
}
