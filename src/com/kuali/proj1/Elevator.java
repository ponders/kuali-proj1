package com.kuali.proj1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * @author llebaron
 * @since 12/5/15
 */
public class Elevator {
    private enum State {
        DOORS_CLOSED(1), DOORS_OPENING(2), DOORS_OPEN(3), DOORS_CLOSING(4), MOVING(6), WAITING_AFTER_MOVEMENT(7), IN_MAINTENANCE(8);
        private Integer id;

        private State(Integer id) {
            this.id = id;
        }
    };

    private int id;
    private State state = State.DOORS_CLOSED;
    private double stateStartTime = 0;
    private int direction = 0; // (-1 = down, 0 = not moving; 1 = up)
    private double currentPosition;
    private NavigableSet<Integer> outstandingRequests = new TreeSet();
    private boolean isOccupied = false;
    private List<ElevatorListener> listeners = new LinkedList();

    private static int DOORS_OPEN_WAIT_SECONDS = 20;
    private static int WAITING_BEFORE_MOVEMENT_SECONDS = 2;
    private static int WAITING_AFTER_MOVEMENT_SECONDS = 2;
    private static double FLOOR_POSITION_TOLERANCE = 0.001;

    private static double MOVE_RATE_FLOORS_PER_SECOND = 0.1;

    private static int MAX_FLOOR = 1;
    private static int MIN_FLOOR = 1;
    public static void setMaxFloor(int maxFloor) {
        // TODO: validate parameter
        MAX_FLOOR = maxFloor;
    }

    Elevator(int id) {
        this.id = id;
    }

/*
    trip count
    trip count service interval (constant)
    hasBeenServiced (or trip count at last service)
    inService
*/

    private int getDestinationFloorUp() {
        Iterator<Integer> iterator = outstandingRequests.iterator();
        while(iterator.hasNext()) {
            Integer requestedFloor = iterator.next();
            if (requestedFloor >= currentPosition) {
                return requestedFloor;
            }
        }
        return 0; // no outstanding up requests;
    }

    private int getDestinationFloorDown() {
        Iterator<Integer> iterator = outstandingRequests.descendingIterator();
        while(iterator.hasNext()) {
            Integer requestedFloor = iterator.next();
            if (requestedFloor <= currentPosition) {
                return requestedFloor;
            }
        }
        return 0; // no outstanding up requests;
    }

    private int getDestinationFloor() {
        // based on direction and proximity return the floor elevator wants to move to
        int floor = 0;
        if (direction == 1) {
            floor = getDestinationFloorUp();
        } else if (direction == -1) {
            floor = getDestinationFloorDown();
        } else {
            // no direction, go to the nearest floor either direction
            int upFloor = getDestinationFloorUp();
            int downFloor = getDestinationFloorDown();
            if (upFloor == 0) {
                floor = downFloor; // either both zero, or downFloor is closest
            } else {
                if (downFloor == 0) {
                    floor = upFloor;
                } else if (currentPosition - downFloor <= upFloor - currentPosition) {
                    floor = downFloor;
                } else {
                    floor = upFloor;
                }
            }

        }
        return floor;
    }

    public void makeRequest(int floor) {
        // TODO: check that floor is within the bounds
        outstandingRequests.add(floor);
    }

    // handles the time simulation, called on an interval such as every 1/10th second
    private void timerEvent() {
        switch (state) {
        case DOORS_CLOSED:
            // if currentTime - stateStartTime > WAITING_BEFORE_MOVEMENT_SECONDS,
            // check that trip count no exceeded, if so transition to IN_MAINTENANCE
            // otherwise calculate destination and if any start moving (set direction)
            break;
        case DOORS_OPENING:
            // if currentTime - stateStartTime > time it takes to open doors, transition to DOORS_OPEN & notify
            break;
        case DOORS_OPEN:
            // if currentTime - stateStartTime > DOORS_OPEN_WAIT_SECONDS, transition to DOORS_CLOSING & notify
            break;
        case DOORS_CLOSING:
            // if currentTime - stateStartTime > time it takes to close doors, transition to DOORS_CLOSED & notify
            break;
        case MOVING:
            // update position based on currentTime - stateStartTime, MOVE_RATE_FLOORS_PER_SECOND & direction,
            // calculate requested floor,
            // if we're there: transition to WAITING_AFTER_MOVEMENT & notify at floor
            break;
        case WAITING_AFTER_MOVEMENT:
            // if currentTime - stateStartTime > time it takes to close doors, transition to DOORS_CLOSED & notify
            break;
        }
    }

    // these are used by the controller to decide which elevator to send
    public boolean isOccupied() {
        return isOccupied;
    }

    public double distanceToFloor(int floor) {
        // TODO; validate parameter
        if (floor > currentPosition) {
            return floor - currentPosition;
        } else {
            return currentPosition - floor;
        }
    }
}
