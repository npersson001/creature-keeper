package com.personal.creaturekeeper.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value.Immutable;

@Immutable
@JsonDeserialize(as = ImmutableCreaturePayload.class)
public interface CreaturePayload {

    @JsonProperty("id")
    long getId();

    @JsonProperty("name")
    String getName();

    @JsonProperty("species")
    String getSpecies();

    @JsonProperty("age")
    int getAge();

}