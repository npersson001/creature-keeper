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
    private final CreaturesService creaturesService;

    public CreatureRequestHandler(CreaturesService creaturesService) {
        this.creaturesService = creaturesService;
    }

    public ResponseEntity createCreature(CreatureRequest creatureRequest) {
        try {
            CreaturePayload creaturePayload = creaturesService.insertCreature(creatureRequest);
            return createSuccessResponse(ImmutableCreatureResponse.builder()
                    .creaturePayload(creaturePayload)
                    .build());
        } catch (Exception ex) {
            return createErrorResponse(ex);
        }
    }

    public ResponseEntity getCreature(int creatureId) {
        try {
            CreaturePayload creaturePayload = creaturesService.queryCreature(creatureId);
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
