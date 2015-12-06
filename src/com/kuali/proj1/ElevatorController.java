package com.kuali.proj1;

/**
 * @author llebaron
 * @since 12/5/15
 */
public class ElevatorController {
    public ElevatorController(int maxFloor, int numElevators) {
        Elevator.setMaxFloor(maxFloor);
        // instantiate numElevators elevators
    }

    public void makeRequest(int floor) {
        // iterator over the elevators and for each that is unoccupied request the distance from floor to that elevator's position (distanceToFloor(floor))
        // then call makeRequest on the elevator with the shortest distance
    }
}
