package com.kuali.proj1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author llebaron
 * @since 12/5/15
 */
public class Elevator implements PositionNotification {
    private enum State {
        DOORS_CLOSED(1), DOORS_OPENING(2), DOORS_OPEN(3), DOORS_CLOSING(4), WAITING_BEFORE_MOVEMENT(5), MOVING(6), WAITING_AFTER_MOVEMENT(7);
        private Integer id;

        private State(Integer id) {
            this.id = id;
        }
    };

    private int id;
    private State state = State.DOORS_CLOSED;
    private int direction = 0; // (-1 = down, 0 = not moving; 1 = up)
    private double currentPosition;
    private SortedSet<Integer> outstandingRequests = new TreeSet();
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
        MAX_FLOOR = maxFloor;
    }

    Elevator(int id) {
        this.id = id;
    }

    private void startMovingIfRequestOutstanding() {
        // if the elevator has any outstanding requests, start moving toward closest request in the current direction
        state = State.MOVING;
    }
    void positionNotification(double position) {
        // accepts position information from sensors or motor
        currentPosition = position;
        if (position)
    }

    doors opened (opening + open)?
    doors closed (closing + closed)?
    trip count
    trip count service interval (constant)
    hasBeenServiced (or trip count at last service)
    inService

    public boolean isAtFloor(int floor) {

    }

    private int getDestinationFloor() {
        // based on direction and proximity return the floor elevator wants to move to
        if (direction == 1) {
            Iterator<Integer> iterator = outstandingRequests.iterator();
            while(iterator.hasNext()) {
                Integer requestedFloor = iterator.next();
                if (requestedFloor >= currentPosition) {
                    return requestedFloor;
                }
            }
        } else if (direction = -1) {
            Iterator<Integer> iterator = outstandingRequests.descendingIterator();
            while(iterator.hasNext()) {
                Integer requestedFloor = iterator.next();
                if (requestedFloor >= currentPosition) {
                    return requestedFloor;
                }
            }
        } else {

        }
        return 0; // no outstanding requests;
    }

    public void makeRequest(int floor) {
        outstandingRequests.add(floor);
    }


            isOccupied
    distance to target (includes transit to destination then to target)
}

/* this wants a state machine for the full simulation
    at floor with doors closed
    doors opening
    doors open
    doors closing
    waiting before movement
    moving
    waiting after movement

 */