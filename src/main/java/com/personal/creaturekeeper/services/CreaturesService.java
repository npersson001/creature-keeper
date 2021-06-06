package com.personal.creaturekeeper.services;

import com.personal.creaturekeeper.exceptions.CreatureValidationException;
import com.personal.creaturekeeper.repositories.CreaturesRepository;
import com.personal.creaturekeeper.requests.CreatureRequest;
import com.personal.creaturekeeper.responses.CreaturePayload;
import java.sql.SQLException;
import org.springframework.stereotype.Service;

@Service
public class CreaturesService {

    private final CreaturesRepository creaturesRepository;
    private final CreatureValidator creatureValidator;

    public CreaturesService(CreaturesRepository creaturesRepository,
            CreatureValidator creatureValidator) {
        this.creaturesRepository = creaturesRepository;
        this.creatureValidator = creatureValidator;
    }

    public CreaturePayload insertCreature(CreatureRequest creatureRequest) throws SQLException {
        try {
            creatureValidator.validateCreature(creatureRequest);
        } catch (CreatureValidationException ex) {

        }

        return creaturesRepository.insertCreature(creatureRequest);
    }

    public CreaturePayload queryCreature(int creatureId) throws SQLException {
        return creaturesRepository.queryCreature(creatureId);
    }

}
