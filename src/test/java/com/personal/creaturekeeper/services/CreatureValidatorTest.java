package com.personal.creaturekeeper.services;

import static com.personal.creaturekeeper.TestUtils.CREATURE_AGE;
import static com.personal.creaturekeeper.TestUtils.CREATURE_NAME;
import static com.personal.creaturekeeper.TestUtils.CREATURE_SPECIES;
import static com.personal.creaturekeeper.TestUtils.DEFAULT_CREATURE_REQUEST;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.personal.creaturekeeper.exceptions.CreatureValidationException;
import com.personal.creaturekeeper.requests.ImmutableCreatureRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreatureValidatorTest {

    private EncryptionService mockEncryptionService = mock(EncryptionService.class);

    private CreatureValidator creatureValidator = new CreatureValidator(mockEncryptionService);

    @BeforeEach
    public void beforeEach() {
        when(mockEncryptionService.decryptString(anyString())).thenReturn(CREATURE_SPECIES);
    }

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
        final String longSpecies = CREATURE_SPECIES.repeat(50);
        when(mockEncryptionService.decryptString(anyString())).thenReturn(longSpecies);

        assertThrows(CreatureValidationException.class, () -> {
            creatureValidator.validateCreature(
                    ImmutableCreatureRequest.builder()
                            .name(CREATURE_NAME)
                            .species(longSpecies)
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
