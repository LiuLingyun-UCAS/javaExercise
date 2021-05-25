package com.lly.chapter08.extend_.exercise;

public class ExtendExcerise03 {

    public static void main(String[] args) {
        PC pc = new PC("intel", 12, 1000, "huawei");
        NotePad notePad = new NotePad("AMD", 12, 2000, "ASUS");
        pc.getDetails();
        notePad.getDetails();
    }
}

class Computer {
    private String cpu;
    private int memory;
    private int storage;

    public Computer(String cpu, int memory, int storage) {
        this.cpu = cpu;
        this.memory = memory;
        this.storage = storage;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public void getDetails() {
        System.out.println("cpu=" + cpu + "\tmemory=" + memory + "\tstorage=" + storage);
    }
}

class PC extends Computer {
    private String brand;

    public PC(String cpu, int memory, int storage, String brand) {
        super(cpu, memory, storage);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public void getDetails() {
        System.out.println("cpu=" + getCpu() + "\tmemory=" + getMemory() + "\tstorage=" + getStorage()
                + "\tbrand=" + getBrand());
    }
}

class NotePad extends Computer {
    private String color;

    public NotePad(String cpu, int memory, int storage, String color) {
        super(cpu, memory, storage);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void getDetails() {
        System.out.println("cpu=" + getCpu() + "\tmemory=" + getMemory() + "\tstorage=" + getStorage()
                + "\tcolor=" + getColor());
    }
}
