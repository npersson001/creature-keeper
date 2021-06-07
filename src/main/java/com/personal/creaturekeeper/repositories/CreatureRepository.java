package com.personal.creaturekeeper.repositories;

import com.personal.creaturekeeper.exceptions.CreatureNotFoundException;
import com.personal.creaturekeeper.requests.CreatureRequest;
import com.personal.creaturekeeper.responses.CreaturePayload;
import com.personal.creaturekeeper.responses.ImmutableCreaturePayload;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreatureRepository {

    private static final Logger LOG = LoggerFactory.getLogger(CreatureRepository.class);

    private final Connection connection;

    public CreatureRepository(Connection connection) {
        this.connection = connection;
    }

    protected static final String COLUMN_ID = "id";
    protected static final String COLUMN_NAME = "name";
    protected static final String COLUMN_SPECIES = "species";
    protected static final String COLUMN_AGE = "age";

    private static final int IDX_NAME = 1;
    private static final int IDX_SPECIES = 2;
    private static final int IDX_AGE = 3;

    private static final String CREATURES_SELECT_QUERY_BASE =
            "SELECT "
                    + "ck.id, "
                    + "ck.name, "
                    + "ck.species, "
                    + "ck.age "
                    + "FROM creatures AS ck "
                    + "WHERE ck.id = %s";

    private static final String CREATURES_INSERT_QUERY_BASE =
            "INSERT INTO creatures (`name`, `species`, `age`) VALUES (?, ?, ?);";

    public CreaturePayload insertCreature(CreatureRequest creatureRequest) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(CREATURES_INSERT_QUERY_BASE,
                Statement.RETURN_GENERATED_KEYS);
        statement.setString(IDX_NAME, creatureRequest.getName());
        statement.setString(IDX_SPECIES, creatureRequest.getSpecies());
        statement.setInt(IDX_AGE, creatureRequest.getAge());

        statement.executeUpdate();
        long id = getInsertedId(statement.getGeneratedKeys());
        LOG.info("Inserted into creatures db with id=[{}]", id);

        return ImmutableCreaturePayload.builder()
                .id(id)
                .name(creatureRequest.getName())
                .species(creatureRequest.getSpecies())
                .age(creatureRequest.getAge())
                .build();
    }

    public CreaturePayload queryCreature(int creatureId)
            throws SQLException, CreatureNotFoundException{
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement
                .executeQuery(String.format(CREATURES_SELECT_QUERY_BASE, creatureId));

        LOG.info("Retrieved from creatures db with id=[{}]", creatureId);

        if (resultSet.next()) { // generally a while loop for multiple returns
            return ImmutableCreaturePayload.builder()
                    .id(resultSet.getLong(COLUMN_ID))
                    .name(resultSet.getString(COLUMN_NAME))
                    .species(resultSet.getString(COLUMN_SPECIES))
                    .age(resultSet.getInt(COLUMN_AGE))
                    .build();
        } else {
            throw new CreatureNotFoundException(
                    String.format("Creature with creatureId=[%s] not found", creatureId));
        }
    }

    private long getInsertedId(ResultSet resultSet) throws SQLException {
        resultSet.next(); // navigate to first row of resultSet which contains keys
        return resultSet.getLong(1); // single insert, single column in key row
    }

}
