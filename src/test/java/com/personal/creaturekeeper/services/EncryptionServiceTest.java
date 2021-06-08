package com.personal.creaturekeeper.services;

import static com.personal.creaturekeeper.TestUtils.DEFAULT_CREATURE_PAYLOAD;
import static com.personal.creaturekeeper.TestUtils.DEFAULT_CREATURE_REQUEST;
import static org.junit.jupiter.api.Assertions.*;

import com.personal.creaturekeeper.responses.CreaturePayload;
import com.personal.creaturekeeper.responses.ImmutableCreaturePayload;
import org.junit.jupiter.api.Test;

public class EncryptionServiceTest {

    private static final String KEY = "encrypt";

    private EncryptionService encryptionService = new EncryptionService(KEY);

    @Test
    public void shouldEncryptRequest() {
        var result = encryptionService.encryptRequest(DEFAULT_CREATURE_REQUEST);
        assertNotEquals(DEFAULT_CREATURE_REQUEST.getSpecies(), result.getSpecies());
    }

    @Test
    public void shouldDecryptPayload() {
        CreaturePayload encryptedPayload = ImmutableCreaturePayload.builder()
                .from(DEFAULT_CREATURE_PAYLOAD)
                .species(encryptionService.encryptString(DEFAULT_CREATURE_PAYLOAD.getSpecies()))
                .build();

        var result = encryptionService.decryptPayload(encryptedPayload);
        assertEquals(DEFAULT_CREATURE_PAYLOAD.getSpecies(), result.getSpecies());
    }

}
