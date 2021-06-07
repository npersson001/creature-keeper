package com.personal.creaturekeeper;

import com.personal.creaturekeeper.requests.CreatureRequest;
import com.personal.creaturekeeper.requests.ImmutableCreatureRequest;
import com.personal.creaturekeeper.responses.CreaturePayload;
import com.personal.creaturekeeper.responses.ImmutableCreaturePayload;

public class TestUtils {

    public static final int CREATURE_ID_INT = 7;
    public static final long CREATURE_ID = 7;
    public static final String CREATURE_NAME = "test_name";
    public static final String CREATURE_SPECIES = "test_species";
    public static final int CREATURE_AGE = 5;

    public static final CreaturePayload DEFAULT_CREATURE_PAYLOAD = ImmutableCreaturePayload
            .builder()
            .id(CREATURE_ID)
            .name(CREATURE_NAME)
            .species(CREATURE_SPECIES)
            .age(CREATURE_AGE)
            .build();

    public static final CreatureRequest DEFAULT_CREATURE_REQUEST = ImmutableCreatureRequest.builder()
            .name(CREATURE_NAME)
            .species(CREATURE_SPECIES)
            .age(CREATURE_AGE)
            .build();

}
