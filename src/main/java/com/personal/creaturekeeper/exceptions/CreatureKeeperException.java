package com.personal.creaturekeeper.exceptions;

public class CreatureKeeperException extends Exception {

    public CreatureKeeperException(String message) {
        super(message);
    }

    public CreatureKeeperException(String message, Exception ex) {
        super(message, ex);
    }

}
