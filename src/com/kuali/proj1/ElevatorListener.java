package com.kuali.proj1;

/**
 * @author llebaron
 * @since 12/5/15
 */
public interface ElevatorListener {
    public void elevatorAtFloor(int id);
    public void elevatorDoorsOpening(int id);
    public void elevatorDoorsOpen(int id);
    public void elevatorDoorsClosing(int id);
    public void elevatorDoorsClosed(int id);
}
