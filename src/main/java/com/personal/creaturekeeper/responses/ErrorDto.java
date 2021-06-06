package com.personal.creaturekeeper.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value.Immutable;
import org.springframework.lang.Nullable;

@Immutable
@JsonDeserialize(as = ImmutableErrorDto.class)
public interface ErrorDto {

    @JsonProperty("code")
    int getCode();

    @JsonProperty("description")
    String getDescription();

}
