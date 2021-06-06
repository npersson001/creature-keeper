package com.personal.creaturekeeper.services;

import static org.junit.jupiter.api.Assertions.*;

import com.personal.creaturekeeper.requests.CreatureRequest;
import com.personal.creaturekeeper.requests.ImmutableCreatureRequest;
import org.junit.jupiter.api.Test;

public class CreatureValidatorTest {

    private static final String CREATURE_NAME = "test_name";
    private static final String CREATURE_SPECIES = "test_species";
    private static final int CREATURE_AGE = 5;

    private static final CreatureRequest VALID_CREATURE_REQUEST = ImmutableCreatureRequest.builder()
            .name(CREATURE_NAME)
            .species(CREATURE_SPECIES)
            .age(CREATURE_AGE)
            .build();

    CreatureValidator creatureValidator = new CreatureValidator();

    @Test
    public void successfulValidation() throws Exception {
        // verify no exception is thrown by default.
        creatureValidator.validateCreature(VALID_CREATURE_REQUEST);
    }

}
