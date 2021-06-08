package com.personal.creaturekeeper.services;

import com.personal.creaturekeeper.exceptions.CreatureNotFoundException;
import com.personal.creaturekeeper.exceptions.CreatureValidationException;
import com.personal.creaturekeeper.repositories.CreatureRepository;
import com.personal.creaturekeeper.requests.CreatureRequest;
import com.personal.creaturekeeper.responses.CreaturePayload;
import java.sql.SQLException;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = {"creaturePayload"})
public class CreatureService {

    private final CreatureRepository creatureRepository;
    private final CreatureValidator creatureValidator;

    public CreatureService(CreatureRepository creatureRepository,
            CreatureValidator creatureValidator) {
        this.creatureRepository = creatureRepository;
        this.creatureValidator = creatureValidator;
    }

    /**
     * Method that validates CreatureRequest and then uses repository to insert into DB.
     * @param creatureRequest - Json object representing a Creature.  Has name, species, and age.
     * @return CreaturePayload - Contains all data on Creature mapped from DB.
     */
    public CreaturePayload insertCreature(CreatureRequest creatureRequest)
            throws SQLException, CreatureValidationException {

        creatureValidator.validateCreature(creatureRequest);
        return creatureRepository.insertCreature(creatureRequest);
    }

    /**
     * Method to use repository to fetch data from DB.
     * @param creatureId - Id that uniquely identifies a Creature.
     * @return CreaturePayload - Contains all data on Creature mapped from DB.
     */
    @Cacheable
    public CreaturePayload queryCreature(int creatureId)
            throws SQLException, CreatureNotFoundException {

        return creatureRepository.queryCreature(creatureId);
    }

}
