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

    public CreaturePayload insertCreature(CreatureRequest creatureRequest)
            throws SQLException, CreatureValidationException {

        creatureValidator.validateCreature(creatureRequest);
        return creatureRepository.insertCreature(creatureRequest);
    }

    @Cacheable
    public CreaturePayload queryCreature(int creatureId)
            throws SQLException, CreatureNotFoundException {

        return creatureRepository.queryCreature(creatureId);
    }

}
