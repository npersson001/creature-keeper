package com.personal.creaturekeeper.exceptions;

import org.springframework.http.HttpStatus;

public enum CreatureKeeperStatus {

    CREATURE_NOT_FOUND(404),
    INVALID_CREATURE(499),
    UNKNOWN_ERROR(999);

    private final int code;

    CreatureKeeperStatus(int code) {
        this.code = code;
    }

    public int getValue() {
        return this.code;
    }

    public static CreatureKeeperStatus mapToStatus(Exception ex) {
        if (ex instanceof CreatureValidationException) {
            return CreatureKeeperStatus.INVALID_CREATURE;
        } else if (ex instanceof CreatureNotFoundException) {
            return CreatureKeeperStatus.CREATURE_NOT_FOUND;
        } else {
            return CreatureKeeperStatus.UNKNOWN_ERROR;
        }
    }

    public static int mapToExternal(CreatureKeeperStatus internalStatus) {
        switch (internalStatus) {
            case CREATURE_NOT_FOUND:
                return HttpStatus.NOT_FOUND.value();
            case INVALID_CREATURE:
                return HttpStatus.BAD_REQUEST.value();
            default:
                return HttpStatus.INTERNAL_SERVER_ERROR.value();
        }
    }

}
