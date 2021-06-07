package com.personal.creaturekeeper.services;

import static com.personal.creaturekeeper.TestUtils.CREATURE_AGE;
import static com.personal.creaturekeeper.TestUtils.CREATURE_NAME;
import static com.personal.creaturekeeper.TestUtils.CREATURE_SPECIES;
import static com.personal.creaturekeeper.TestUtils.DEFAULT_CREATURE_REQUEST;
import static org.junit.jupiter.api.Assertions.*;

import com.personal.creaturekeeper.exceptions.CreatureValidationException;
import com.personal.creaturekeeper.requests.ImmutableCreatureRequest;
import org.junit.jupiter.api.Test;

public class CreatureValidatorTest {

    private CreatureValidator creatureValidator = new CreatureValidator();

    @Test
    public void successfulValidation() throws Exception {
        // verify no exception is thrown by default.
        creatureValidator.validateCreature(DEFAULT_CREATURE_REQUEST);
    }

    @Test
    public void nameExceedsLength() {
        assertThrows(CreatureValidationException.class, () -> {
            creatureValidator.validateCreature(
                    ImmutableCreatureRequest.builder()
                            .name(CREATURE_NAME.repeat(20))
                            .species(CREATURE_SPECIES)
                            .age(CREATURE_AGE)
                            .build()
            );
        });
    }

    @Test
    public void speciesExceedsLength() {
        assertThrows(CreatureValidationException.class, () -> {
            creatureValidator.validateCreature(
                    ImmutableCreatureRequest.builder()
                            .name(CREATURE_NAME)
                            .species(CREATURE_SPECIES.repeat(50))
                            .age(CREATURE_AGE)
                            .build()
            );
        });
    }

    @Test
    public void ageExceedsLimit() {
        assertThrows(CreatureValidationException.class, () -> {
            creatureValidator.validateCreature(
                    ImmutableCreatureRequest.builder()
                            .name(CREATURE_NAME)
                            .species(CREATURE_SPECIES)
                            .age(Integer.MAX_VALUE)
                            .build()
            );
        });
    }

}
