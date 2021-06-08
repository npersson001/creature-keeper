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
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreatureRepository {

    private static final Logger LOG = LoggerFactory.getLogger(CreatureRepository.class);

    private final DataSource dataSource;

    public CreatureRepository(DataSource dataSource) {
        this.dataSource = dataSource;
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

    /**
     * Uses connection to insert Creature into DB.
     * @param creatureRequest - Json object representing a Creature.  Has name, species, and age.
     * @return CreaturePayload - Contains all data on Creature mapped from DB.
     * @throws SQLException
     */
    public CreaturePayload insertCreature(CreatureRequest creatureRequest) throws SQLException {
        Connection connection = dataSource.getConnection();

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

    /**
     * Uses connection to fetch Creature from DB.
     * @param creatureId - Id that uniquely identifies a Creature.
     * @return CreaturePayload - Contains all data on Creature mapped from DB.
     * @throws SQLException
     * @throws CreatureNotFoundException
     */
    public CreaturePayload queryCreature(int creatureId) throws SQLException,
            CreatureNotFoundException{

        Connection connection = dataSource.getConnection();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement
                .executeQuery(String.format(CREATURES_SELECT_QUERY_BASE, creatureId));

        if (resultSet.next()) { // generally a while loop for multiple returns
            LOG.info("Retrieved from creatures db with id=[{}]", creatureId);

            return ImmutableCreaturePayload.builder()
                    .id(resultSet.getLong(COLUMN_ID))
                    .name(resultSet.getString(COLUMN_NAME))
                    .species(resultSet.getString(COLUMN_SPECIES))
                    .age(resultSet.getInt(COLUMN_AGE))
                    .build();
        } else {
            LOG.info("Creature not found in db with id=[{}]", creatureId);

            throw new CreatureNotFoundException(
                    String.format("Creature with creatureId=[%s] not found", creatureId));
        }
    }

    private long getInsertedId(ResultSet resultSet) throws SQLException {
        resultSet.next(); // navigate to first row of resultSet which contains keys
        return resultSet.getLong(1); // single insert, single column in key row
    }

}
