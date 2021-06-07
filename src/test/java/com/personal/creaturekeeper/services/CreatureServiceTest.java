package com.personal.creaturekeeper.services;

import com.personal.creaturekeeper.exceptions.CreatureNotFoundException;
import com.personal.creaturekeeper.repositories.CreatureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.personal.creaturekeeper.TestUtils.CREATURE_ID_INT;
import static com.personal.creaturekeeper.TestUtils.DEFAULT_CREATURE_PAYLOAD;
import static com.personal.creaturekeeper.TestUtils.DEFAULT_CREATURE_REQUEST;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

public class CreatureServiceTest {

    private CreatureValidator mockCreatureValidator = mock(CreatureValidator.class);
    private CreatureRepository mockCreatureRepository = mock(CreatureRepository.class);

    private CreatureService creatureService = new CreatureService(mockCreatureRepository,
            mockCreatureValidator);

    @BeforeEach
    public void beforeEach() throws Exception {
        doNothing().when(mockCreatureValidator).validateCreature(any());
        when(mockCreatureRepository.insertCreature(any())).thenReturn(DEFAULT_CREATURE_PAYLOAD);
        when(mockCreatureRepository.queryCreature(anyInt())).thenReturn(DEFAULT_CREATURE_PAYLOAD);
    }

    @Test
    public void shouldInsertSuccess() throws Exception {
        var result = creatureService.insertCreature(DEFAULT_CREATURE_REQUEST);
        assertEquals(result.getId(), DEFAULT_CREATURE_PAYLOAD.getId());
        assertEquals(result.getName(), DEFAULT_CREATURE_REQUEST.getName());
        assertEquals(result.getSpecies(), DEFAULT_CREATURE_REQUEST.getSpecies());
        assertEquals(result.getAge(), DEFAULT_CREATURE_REQUEST.getAge());
    }

    @Test
    public void shouldQuerySuccess() throws Exception {
        var result = creatureService.queryCreature(CREATURE_ID_INT);
        assertEquals(result.getId(), CREATURE_ID_INT);
        assertEquals(result.getName(), DEFAULT_CREATURE_REQUEST.getName());
        assertEquals(result.getSpecies(), DEFAULT_CREATURE_REQUEST.getSpecies());
        assertEquals(result.getAge(), DEFAULT_CREATURE_REQUEST.getAge());
    }

    @Test
    public void shouldQueryNotFoundFailure() throws Exception {
        when(mockCreatureRepository.queryCreature(anyInt()))
                .thenThrow(new CreatureNotFoundException("not found test"));
        assertThrows(CreatureNotFoundException.class,
                () -> creatureService.queryCreature(71));
    }

}
