class Truck extends StartVehicle {
    @Override
    public void start() {
        System.out.println("Starting the truck.");
    }

    public void liftTailgate() {
        System.out.println("Lifting the truck's tailgate.");
    }
}