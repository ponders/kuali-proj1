package com.kuali.proj1;

import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author llebaron
 * @since 12/5/15
 */
public class Elevator {
    private int id;
    private int direction = 0; // (-1 = down, 0 = not moving; 1 = up)
    private float currentPosition;
    private SortedSet<Integer> outstandingRequests = new TreeSet();
    private boolean isOccupied = false;
    private List<ElevatorListener> listeners = new LinkedList();

    private static int DOORS_OPEN_WAIT_SECONDS = 20;
    private static int DOORS_CLOSED_TO_MOVE_WAIT_SECONDS = 2;

    private static int MAX_FLOOR = 1;
    private static int MIN_FLOOR = 1;
    public static void setMaxFloor(int maxFloor) {
        MAX_FLOOR = maxFloor;
    }

    Elevator(int id) {
        this.id = id;
    }



    private startMoving(int direction) { // engages the engine }
    private

    doors opened (opening + open)?
    doors closed (closing + closed)?
    trip count
    trip count service interval (constant)
    hasBeenServiced (or trip count at last service)
    inService


    makeRequest(int floor);
            isOccupied
    distance to target (includes transit to destination then to target)
}

/* this wants a state machine for the full simulation

 */