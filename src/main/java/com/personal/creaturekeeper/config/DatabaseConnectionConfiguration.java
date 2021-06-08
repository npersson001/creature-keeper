package com.personal.creaturekeeper.config;

import com.personal.creaturekeeper.repositories.CreatureRepository;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
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
    public DataSource creatureKeeperDbConnection(HikariConfig config) {
        return new HikariDataSource(config);
    }

    @Bean
    public HikariConfig hikariConfig(CreatureKeeperDbProperties properties) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(properties.getUrl());
        config.setUsername(properties.getUsername());
        config.setPassword(properties.getPassword());
        config.setDriverClassName(properties.getDriver());
        config.setMaximumPoolSize(properties.getMaxPool());
        config.setMinimumIdle(properties.getMinIdle());

        return config;
    }

    @Bean
    public CreatureRepository creaturesRepository(@Qualifier(CREATURE_KEEPER_DB_CONN)
            DataSource dataSource) {

        return new CreatureRepository(dataSource);
    }

}
