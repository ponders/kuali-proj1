package com.kuali.proj1;

import jdk.nashorn.internal.objects.annotations.Setter;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author llebaron
 * @since 12/5/15
 */
public class Elevator {
    private int id;
    private float currentPosition;
    private SortedSet<Integer> outstandingRequests = new TreeSet();
    private static Integer MAX_FLOOR = 1;
    private static Integer MIN_FLOOR = 1;
    public static void setMaxFloor(Integer maxFloor) {
        MAX_FLOOR = maxFloor;
    }

    Elevator(int id) {
        this.id = id;

    }

    notification subscribers
    at floor + direction
    doors opened (opening + open)?
    doors closed (closing + closed)?
    trip count
    trip count service interval (constant)
    hasBeenServiced (or trip count at last service)
    inService


            isOccupied
    distance to target (includes transit to destination then to target)
}
