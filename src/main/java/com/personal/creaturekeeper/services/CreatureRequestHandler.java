package com.personal.creaturekeeper.services;

import com.personal.creaturekeeper.exceptions.CreatureKeeperStatus;
import com.personal.creaturekeeper.requests.CreatureRequest;
import com.personal.creaturekeeper.responses.CreaturePayload;
import com.personal.creaturekeeper.responses.CreatureResponse;
import com.personal.creaturekeeper.responses.ImmutableCreatureResponse;
import com.personal.creaturekeeper.responses.ImmutableErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CreatureRequestHandler {
    private final CreatureService creatureService;
    private final EncryptionService encryptionService;

    public CreatureRequestHandler(CreatureService creatureService,
            EncryptionService encryptionService) {
        this.creatureService = creatureService;
        this.encryptionService = encryptionService;
    }

    /**
     * Method to encrypt sensitive parts of request and use CreatureService to create Creature.
     * Centralized spot for consolidating errors and presenting them in response.
     * @param creatureRequest - Json object representing a Creature.  Has name, species, and age.
     * @return ResponseEntity - Body holds CreatureResponse.
     */
    public ResponseEntity createCreature(CreatureRequest creatureRequest) {
        try {
            CreatureRequest encryptedRequest = encryptionService.encryptRequest(creatureRequest);
            CreaturePayload encryptedPayload = creatureService.insertCreature(encryptedRequest);
            CreaturePayload creaturePayload = encryptionService.decryptPayload(encryptedPayload);

            return createSuccessResponse(ImmutableCreatureResponse.builder()
                    .creaturePayload(creaturePayload)
                    .build());
        } catch (Exception ex) {
            return createErrorResponse(ex);
        }
    }

    /**
     * Method to call CreatureService to get the Creature and decrypt its sensitive data.
     * Centralized spot for consolidating errors and presenting them in response.
     * @param creatureId - Id that uniquely identifies a Creature.
     * @return ResponseEntity - Body holds CreatureResponse.
     */
    public ResponseEntity getCreature(int creatureId) {
        try {
            CreaturePayload encryptedPayload = creatureService.queryCreature(creatureId);
            CreaturePayload creaturePayload = encryptionService.decryptPayload(encryptedPayload);

            return createSuccessResponse(ImmutableCreatureResponse.builder()
                    .creaturePayload(creaturePayload)
                    .build());
        } catch (Exception ex) {
            return createErrorResponse(ex);
        }
    }

    private ResponseEntity createErrorResponse(Exception e) {
        CreatureKeeperStatus internalStatus = CreatureKeeperStatus.mapToStatus(e);
        int externalStatus = CreatureKeeperStatus.mapToExternal(internalStatus);
        return ResponseEntity.status(externalStatus)
                .body(ImmutableErrorDto.builder()
                        .code(internalStatus.getValue())
                        .description(e.getMessage())
                        .build());
    }

    private ResponseEntity createSuccessResponse(CreatureResponse creatureResponse) {
        return ResponseEntity.ok().body(creatureResponse);
    }

}
