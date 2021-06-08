package com.personal.creaturekeeper.services;

import com.personal.creaturekeeper.exceptions.CreatureKeeperStatus;
import com.personal.creaturekeeper.requests.CreatureRequest;
import com.personal.creaturekeeper.requests.ImmutableCreatureRequest;
import com.personal.creaturekeeper.responses.CreaturePayload;
import com.personal.creaturekeeper.responses.CreatureResponse;
import com.personal.creaturekeeper.responses.ImmutableCreaturePayload;
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

    public ResponseEntity getCreature(int creatureId) {
        try {
            CreaturePayload creaturePayload = creatureService.queryCreature(creatureId);
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
