package com.personal.creaturekeeper.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value.Immutable;
import org.springframework.lang.Nullable;

@Immutable
@JsonDeserialize(as = ImmutableCreatureResponse.class)
public interface CreatureResponse {

    @JsonProperty("creature")
    @Nullable
    CreaturePayload getCreaturePayload();

    @JsonProperty("error")
    @Nullable
    ErrorDto getError();

}
