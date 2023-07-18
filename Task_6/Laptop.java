package Task_6;

class Laptop {
    private static int count = 0;
    private int id;
    private String model;
    private int ram;
    private int storage;
    private String os;
    private String color;

    public Laptop(String model, int ram, int storage, String os, String color) {
        this.id = ++count;
        this.model = model;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id = " + id +
                ",\tmodel = '" + model + '\'' +
                ",\tram = " + ram +
                ",\tstorage = " + storage +
                ",\tos = '" + os + '\'' +
                ",\tcolor = '" + color + '\'' +
                '}';
    }
}