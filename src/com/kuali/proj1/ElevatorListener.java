package com.kuali.proj1;

/**
 * @author llebaron
 * @since 12/5/15
 */

// this class notifies elevator subscribers
// an alternate implementation would be to have an interface for each event. Requirements didn't suggest this was necessary
public interface ElevatorListener {
    public void elevatorAtFloor(int id);
    public void elevatorDoorsOpening(int id);
    public void elevatorDoorsOpen(int id);
    public void elevatorDoorsClosing(int id);
    public void elevatorDoorsClosed(int id);
}
