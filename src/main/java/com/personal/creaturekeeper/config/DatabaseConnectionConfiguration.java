package com.personal.creaturekeeper.config;

import com.personal.creaturekeeper.repositories.CreaturesRepository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(CreatureKeeperDbProperties.class)
public class DatabaseConnectionConfiguration {

    public static final String CREATURE_KEEPER_DB_CONN = "CreatureKeeperDb";

    @Bean
    @Qualifier(CREATURE_KEEPER_DB_CONN)
    public Connection creatureKeeperDbConnection(CreatureKeeperDbProperties properties,
            @Value("${creature.keeper.db.connection.prefix}") String hostPrefix)
            throws SQLException {

        // TODO handle this exception thrown
        System.out.println("attempting connection to: " + getHost(properties, hostPrefix));
        return DriverManager.getConnection(
                getHost(properties, hostPrefix), properties.getConfiguration());
    }

    private String getHost(CreatureKeeperDbProperties properties, String hostPrefix) {
        return String.format("%s%s:%s/%s", hostPrefix, properties.getHost(), properties.getPort(),
                properties.getDatabase());
    }

    @Bean
    public CreaturesRepository creaturesRepository(@Qualifier(CREATURE_KEEPER_DB_CONN)
            Connection connection) {

        return new CreaturesRepository(connection);
    }

}
