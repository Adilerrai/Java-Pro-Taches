abstract class StartVehicle {
    public abstract void start();


public static void startVehicle(StartVehicle vehicle) {
    vehicle.start();

    if (vehicle instanceof Car) {
        ((Car) vehicle).openDoors();
    } else if (vehicle instanceof Truck) {
        ((Truck) vehicle).liftTailgate();
    } else if (vehicle instanceof Motorcycle) {
        ((Motorcycle) vehicle).kickStand();
    }
}

}
