class Car extends StartVehicle {
    @Override
    public void start() {
        System.out.println("Starting the car.");
    }

    public void openDoors() {
        System.out.println("Opening the car doors.");
    }
}