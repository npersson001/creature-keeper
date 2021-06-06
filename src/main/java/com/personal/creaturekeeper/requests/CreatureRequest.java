package com.personal.creaturekeeper.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value.Immutable;

@Immutable
@JsonDeserialize(as = ImmutableCreatureRequest.class)
public interface CreatureRequest {

    @JsonProperty("name")
    String getName();

    @JsonProperty("species")
    String getSpecies();

    @JsonProperty("age")
    int getAge();

}
