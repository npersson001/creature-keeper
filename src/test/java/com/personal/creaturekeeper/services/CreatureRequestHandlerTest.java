package com.personal.creaturekeeper.services;

import static com.personal.creaturekeeper.TestUtils.CREATURE_ID_INT;
import static com.personal.creaturekeeper.TestUtils.DEFAULT_CREATURE_PAYLOAD;
import static com.personal.creaturekeeper.TestUtils.DEFAULT_CREATURE_REQUEST;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.personal.creaturekeeper.exceptions.CreatureNotFoundException;
import com.personal.creaturekeeper.responses.CreaturePayload;
import com.personal.creaturekeeper.responses.ImmutableCreatureResponse;
import com.personal.creaturekeeper.responses.ImmutableErrorDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

public class CreatureRequestHandlerTest {

    private CreatureService mockCreatureService = mock(CreatureService.class);
    private EncryptionService mockEncryptionService = mock(EncryptionService.class);

    private CreatureRequestHandler creatureRequestHandler =
            new CreatureRequestHandler(mockCreatureService, mockEncryptionService);

    @BeforeEach
    public void beforeEach() throws Exception {
        when(mockCreatureService.insertCreature(any())).thenReturn(DEFAULT_CREATURE_PAYLOAD);
        when(mockCreatureService.queryCreature(anyInt())).thenReturn(DEFAULT_CREATURE_PAYLOAD);
        when(mockEncryptionService.encryptRequest(any())).thenReturn(DEFAULT_CREATURE_REQUEST);
        when(mockEncryptionService.decryptPayload(any())).thenReturn(DEFAULT_CREATURE_PAYLOAD);
    }

    @Test
    public void shouldCreateCreatureSuccess() throws Exception {
        var result = creatureRequestHandler.createCreature(DEFAULT_CREATURE_REQUEST);
        verify(mockCreatureService, times(1)).insertCreature(any());
        confirmPayload(result);
    }

    @Test
    public void shouldGetCreatureSuccess() throws Exception {
        var result = creatureRequestHandler.getCreature(CREATURE_ID_INT);
        verify(mockCreatureService, times(1)).queryCreature(anyInt());
        confirmPayload(result);
    }

    @Test
    public void shouldGetNotFoundFailure() throws Exception {
        when(mockCreatureService.queryCreature(anyInt()))
                .thenThrow(new CreatureNotFoundException("test not found"));
        var result = creatureRequestHandler.getCreature(CREATURE_ID_INT);
        ImmutableErrorDto errorDto = (ImmutableErrorDto) result.getBody();
        verify(mockCreatureService, times(1)).queryCreature(anyInt());
    }

    private void confirmPayload(ResponseEntity responseEntity) {
        ImmutableCreatureResponse response = (ImmutableCreatureResponse) responseEntity.getBody();
        CreaturePayload creaturePayload = response.getCreaturePayload();
        assertEquals(creaturePayload.getId(), DEFAULT_CREATURE_PAYLOAD.getId());
        assertEquals(creaturePayload.getName(), DEFAULT_CREATURE_REQUEST.getName());
        assertEquals(creaturePayload.getSpecies(), DEFAULT_CREATURE_REQUEST.getSpecies());
        assertEquals(creaturePayload.getAge(), DEFAULT_CREATURE_REQUEST.getAge());
    }

}
