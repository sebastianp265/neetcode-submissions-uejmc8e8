
class Solution {

    private record Car(
        int position,
        int speed
    ) {
    }

    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            cars.add(new Car(position[i], speed[i]));
        }
        cars.sort(Comparator.comparingInt(Car::position));
        int fleetCount = 1;
        var previousTimeReachingTarget = timeReachingTarget(cars.getLast(), target);
        for (int i = cars.size() - 2; i >= 0; i--) {
            var timeReachingTarget = timeReachingTarget(cars.get(i), target);
            if(timeReachingTarget > previousTimeReachingTarget) {
                fleetCount++;
                previousTimeReachingTarget = timeReachingTarget;
            }
        }

        return fleetCount;
    }

    private double timeReachingTarget(Car car, int target) {
        return (double) (target - car.position) / car.speed;
    }

}
