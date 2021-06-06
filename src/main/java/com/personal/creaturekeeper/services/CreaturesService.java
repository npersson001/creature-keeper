package com.personal.creaturekeeper.services;

import com.personal.creaturekeeper.exceptions.CreatureValidationException;
import com.personal.creaturekeeper.repositories.CreaturesRepository;
import com.personal.creaturekeeper.requests.CreatureRequest;
import com.personal.creaturekeeper.responses.CreaturePayload;
import java.sql.SQLException;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = {"creaturePayload"})
public class CreaturesService {

    private final CreaturesRepository creaturesRepository;
    private final CreatureValidator creatureValidator;
    private final CacheManager cacheManager;

    public CreaturesService(CreaturesRepository creaturesRepository,
            CreatureValidator creatureValidator,
            CacheManager cacheManager) {
        this.creaturesRepository = creaturesRepository;
        this.creatureValidator = creatureValidator;
        this.cacheManager = cacheManager;
    }

    public CreaturePayload insertCreature(CreatureRequest creatureRequest) throws SQLException {
        try {
            creatureValidator.validateCreature(creatureRequest);
        } catch (CreatureValidationException ex) {

        }

        return creaturesRepository.insertCreature(creatureRequest);
    }

    @Cacheable
    public CreaturePayload queryCreature(int creatureId) throws SQLException {
        return creaturesRepository.queryCreature(creatureId);
    }

}
