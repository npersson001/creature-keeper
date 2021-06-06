package com.personal.creaturekeeper.exceptions;

public class CreatureKeeperHttpStatus {

    public static final CreatureKeeperHttpStatus OK =
            new CreatureKeeperHttpStatus(org.springframework.http.HttpStatus.OK.value());

    private final int code;

    public CreatureKeeperHttpStatus(int code) {
        this.code = code;
    }

}
