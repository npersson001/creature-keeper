package com.personal.creaturekeeper.services;

import com.personal.creaturekeeper.exceptions.CreatureKeeperException;
import com.personal.creaturekeeper.requests.CreatureRequest;
import com.personal.creaturekeeper.responses.CreaturePayload;
import com.personal.creaturekeeper.responses.CreatureResponse;
import com.personal.creaturekeeper.responses.ImmutableCreatureResponse;
import com.personal.creaturekeeper.responses.ImmutableErrorDto;
import org.springframework.stereotype.Component;

@Component
public class CreatureRequestHandler {
    private final CreaturesService creaturesService;

    public CreatureRequestHandler(CreaturesService creaturesService) {
        this.creaturesService = creaturesService;
    }

    public CreatureResponse createCreature(CreatureRequest creatureRequest) {
        try {
            CreaturePayload creaturePayload = creaturesService.insertCreature(creatureRequest);
            return ImmutableCreatureResponse.builder()
                    .creaturePayload(creaturePayload)
                    .build();
        } catch (Exception ex) {
            return createErrorResponse(ex);
        }
    }

    public CreatureResponse getCreature(int creatureId) {
        try {
            CreaturePayload creaturePayload = creaturesService.queryCreature(creatureId);
            return ImmutableCreatureResponse.builder()
                    .creaturePayload(creaturePayload)
                    .build();
        } catch (Exception ex) {
            return createErrorResponse(ex);
        }
    }

    //TODO: fix how we return error codes.
    private CreatureResponse createErrorResponse(Exception e) {
        var errorBuilder = ImmutableErrorDto.builder();
        if (e instanceof CreatureKeeperException) {
            errorBuilder
                    .code(555)
                    .description(e.getMessage());
        } else {
            errorBuilder
                    .code(999)
                    .description("Unknown Error Occurred Internally");
        }

        return ImmutableCreatureResponse.builder()
                .error(errorBuilder.build())
                .build();
    }

}
