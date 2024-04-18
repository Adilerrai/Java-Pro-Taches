class Motorcycle extends StartVehicle {
    @Override
    public void start() {
        System.out.println("Starting the motorcycle.");
    }

    public void kickStand() {
        System.out.println("Putting down the motorcycle's kickstand.");
    }
}
