package com.personal.creaturekeeper.repositories;

import com.personal.creaturekeeper.requests.CreatureRequest;
import com.personal.creaturekeeper.responses.CreaturePayload;
import com.personal.creaturekeeper.responses.ImmutableCreaturePayload;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreaturesRepository {

    private final Connection connection;

    public CreaturesRepository(Connection connection) {
        this.connection = connection;
    }

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_SPECIES = "species";
    private static final String COLUMN_AGE = "age";

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

    public void insertCreature(CreatureRequest creatureRequest) {
        try {
            PreparedStatement statement = connection.prepareStatement(CREATURES_INSERT_QUERY_BASE,
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(IDX_NAME, creatureRequest.getName());
            statement.setString(IDX_SPECIES, creatureRequest.getSpecies());
            statement.setInt(IDX_AGE, creatureRequest.getAge());

            statement.executeUpdate();
            long id = getInsertedId(statement.getGeneratedKeys());
            System.out.println("got generated key: ");
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage()); // TODO: Handle this exception.
        }
    }

    public CreaturePayload queryCreature(int creatureId) throws SQLException {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement
                    .executeQuery(String.format(CREATURES_SELECT_QUERY_BASE, creatureId));

            CreaturePayload creature = null;
            if (resultSet.next()) { // generally a while loop for multiple return
                creature = ImmutableCreaturePayload.builder()
                        .id(resultSet.getLong(COLUMN_ID))
                        .name(resultSet.getString(COLUMN_NAME))
                        .species(resultSet.getString(COLUMN_SPECIES))
                        .age(resultSet.getInt(COLUMN_AGE))
                        .build();
            }

            return creature;
        } catch (SQLException e) {
            System.out.println(e.getMessage()); // TODO: Handle this exception.
            throw e;
        }
    }

    private long getInsertedId(ResultSet resultSet) throws SQLException {
        resultSet.next(); // navigate to first row of resultSet which contains keys
        return resultSet.getLong(1); // single insert, single column in key row
    }

}
