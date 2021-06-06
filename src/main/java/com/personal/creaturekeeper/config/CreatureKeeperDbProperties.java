package com.personal.creaturekeeper.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("database.creature-keeper")
public class CreatureKeeperDbProperties extends DatabaseProperties {
}
