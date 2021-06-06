package com.personal.creaturekeeper.services;

import com.personal.creaturekeeper.exceptions.CreatureValidationException;
import com.personal.creaturekeeper.requests.CreatureRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CreatureValidator {

    private static final Logger LOG = LoggerFactory.getLogger(CreatureValidator.class);

    private static final int MAX_NAME_LENGTH = 25;
    private static final int MAX_SPECIES_LENGTH = 50;
    private static final int MAX_AGE = 9999;

    public void validateCreature(CreatureRequest creatureRequest)
            throws CreatureValidationException {
        if (creatureRequest.getName().length() > MAX_NAME_LENGTH) {
            throwException(creatureRequest,
                    String.format("Creature name too long (>%s).", MAX_NAME_LENGTH));
        }
        if (creatureRequest.getSpecies().length() > MAX_SPECIES_LENGTH) {
            throwException(creatureRequest,
                    String.format("Creature species too long (>%s).", MAX_SPECIES_LENGTH));
        }
        if (creatureRequest.getAge() > MAX_AGE) {
            throwException(creatureRequest,
                    String.format("Creature too old (>%s).", MAX_AGE));
        }
    }

    private void throwException(CreatureRequest request, String message)
            throws CreatureValidationException {

        LOG.info("Validation failed for creature request: {}", request);
        throw new CreatureValidationException(message);
    }

}
