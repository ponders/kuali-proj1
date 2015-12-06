package com.kuali.proj1;

public class Main {

    public static void main(String[] args) {
	// use args to get # elevators and top floor, instantiate ElevatorController and start the simulation
    }
}

/* NOTE: there is some ambiguity in the requirements so I've assumed what I understand of normal elevator behavior in those circumstances */
/*
    elevator:
        current position
        destination floor (0 means none specified)
            outstandingRequests
        top floor?
        bottom floor (constant?)
        direction (may not need this)
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


    controller:
        handleRequest(floor)

        subscribe to notifications from elevators

 */