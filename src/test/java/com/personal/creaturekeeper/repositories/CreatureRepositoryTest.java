package com.personal.creaturekeeper.repositories;

import static com.personal.creaturekeeper.TestUtils.CREATURE_AGE;
import static com.personal.creaturekeeper.TestUtils.CREATURE_ID;
import static com.personal.creaturekeeper.TestUtils.CREATURE_ID_INT;
import static com.personal.creaturekeeper.TestUtils.CREATURE_NAME;
import static com.personal.creaturekeeper.TestUtils.CREATURE_SPECIES;
import static com.personal.creaturekeeper.TestUtils.DEFAULT_CREATURE_PAYLOAD;
import static com.personal.creaturekeeper.TestUtils.DEFAULT_CREATURE_REQUEST;
import static com.personal.creaturekeeper.repositories.CreatureRepository.COLUMN_AGE;
import static com.personal.creaturekeeper.repositories.CreatureRepository.COLUMN_ID;
import static com.personal.creaturekeeper.repositories.CreatureRepository.COLUMN_NAME;
import static com.personal.creaturekeeper.repositories.CreatureRepository.COLUMN_SPECIES;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.personal.creaturekeeper.responses.CreaturePayload;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreatureRepositoryTest {

    private HikariDataSource mockDatasource = mock(HikariDataSource.class);
    private Connection mockConnection = mock(Connection.class);
    private Statement mockStatement = mock(Statement.class);
    private PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
    private ResultSet mockResultSet = mock(ResultSet.class);

    private CreatureRepository creatureRepository = new CreatureRepository(mockDatasource);

    @BeforeEach
    public void beforeEach() throws Exception {
        when(mockDatasource.getConnection()).thenReturn(mockConnection);
        when(mockConnection.createStatement()).thenReturn(mockStatement);

        when(mockStatement.executeQuery(any())).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getLong(eq(COLUMN_ID))).thenReturn(CREATURE_ID);
        when(mockResultSet.getString(eq(COLUMN_NAME))).thenReturn(CREATURE_NAME);
        when(mockResultSet.getString(eq(COLUMN_SPECIES))).thenReturn(CREATURE_SPECIES);
        when(mockResultSet.getInt(eq(COLUMN_AGE))).thenReturn(CREATURE_AGE);

        when(mockConnection.prepareStatement(any(), anyInt())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.getGeneratedKeys()).thenReturn(mockResultSet);
        when(mockResultSet.getLong(anyInt())).thenReturn(CREATURE_ID);
    }

    @Test
    public void shouldQuerySuccess() throws Exception {
        var result = creatureRepository.queryCreature(CREATURE_ID_INT);
        verify(mockConnection, times(1)).createStatement();
        verify(mockStatement, times(1)).executeQuery(any());
        confirmPayload(result);
    }

    @Test
    public void shouldInsertSuccess() throws Exception {
        var result = creatureRepository.insertCreature(DEFAULT_CREATURE_REQUEST);
        verify(mockConnection, times(1)).prepareStatement(any(), anyInt());
        verify(mockPreparedStatement, times(2)).setString(anyInt(), any());
        verify(mockPreparedStatement, times(1)).setInt(anyInt(), anyInt());
        verify(mockPreparedStatement, times(1)).executeUpdate();
        confirmPayload(result);
    }

    private void confirmPayload(CreaturePayload creaturePayload) {
        assertEquals(creaturePayload.getId(), DEFAULT_CREATURE_PAYLOAD.getId());
        assertEquals(creaturePayload.getName(), DEFAULT_CREATURE_PAYLOAD.getName());
        assertEquals(creaturePayload.getSpecies(), DEFAULT_CREATURE_PAYLOAD.getSpecies());
        assertEquals(creaturePayload.getAge(), DEFAULT_CREATURE_PAYLOAD.getAge());
    }

}
