package com.personal.creaturekeeper.config;

import com.personal.creaturekeeper.repositories.CreatureRepository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(CreatureKeeperDbProperties.class)
public class DatabaseConnectionConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(DatabaseConnectionConfiguration.class);

    public static final String CREATURE_KEEPER_DB_CONN = "CreatureKeeperDb";

    @Bean
    @Qualifier(CREATURE_KEEPER_DB_CONN)
    public Connection creatureKeeperDbConnection(CreatureKeeperDbProperties properties,
            @Value("${creature.keeper.db.connection.prefix}") String hostPrefix) throws SQLException {

        // TODO handle this exception thrown
        String host = getHost(properties, hostPrefix);
        LOG.info("Creating connection to: [{}]", host);
        return DriverManager.getConnection(host, properties.getConfiguration());
    }

    private String getHost(CreatureKeeperDbProperties properties, String hostPrefix) {
        return String.format("%s%s:%s/%s", hostPrefix, properties.getHost(), properties.getPort(),
                properties.getDatabase());
    }

    @Bean
    public CreatureRepository creaturesRepository(@Qualifier(CREATURE_KEEPER_DB_CONN)
            Connection connection) {

        return new CreatureRepository(connection);
    }

}
