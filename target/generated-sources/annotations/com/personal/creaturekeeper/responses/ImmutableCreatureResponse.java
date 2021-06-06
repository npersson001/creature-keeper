package com.personal.creaturekeeper.responses;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import org.immutables.value.Generated;
import org.springframework.lang.Nullable;

/**
 * Immutable implementation of {@link CreatureResponse}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableCreatureResponse.builder()}.
 */
@Generated(from = "CreatureResponse", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableCreatureResponse implements CreatureResponse {
  private final @Nullable CreaturePayload creaturePayload;
  private final @Nullable ErrorDto error;

  private ImmutableCreatureResponse(
      @Nullable CreaturePayload creaturePayload,
      @Nullable ErrorDto error) {
    this.creaturePayload = creaturePayload;
    this.error = error;
  }

  /**
   * @return The value of the {@code creaturePayload} attribute
   */
  @JsonProperty("creature")
  @Override
  public @Nullable CreaturePayload getCreaturePayload() {
    return creaturePayload;
  }

  /**
   * @return The value of the {@code error} attribute
   */
  @JsonProperty("error")
  @Override
  public @Nullable ErrorDto getError() {
    return error;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CreatureResponse#getCreaturePayload() creaturePayload} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for creaturePayload (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCreatureResponse withCreaturePayload(@Nullable CreaturePayload value) {
    if (this.creaturePayload == value) return this;
    return new ImmutableCreatureResponse(value, this.error);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CreatureResponse#getError() error} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for error (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCreatureResponse withError(@Nullable ErrorDto value) {
    if (this.error == value) return this;
    return new ImmutableCreatureResponse(this.creaturePayload, value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableCreatureResponse} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableCreatureResponse
        && equalTo((ImmutableCreatureResponse) another);
  }

  private boolean equalTo(ImmutableCreatureResponse another) {
    return Objects.equals(creaturePayload, another.creaturePayload)
        && Objects.equals(error, another.error);
  }

  /**
   * Computes a hash code from attributes: {@code creaturePayload}, {@code error}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + Objects.hashCode(creaturePayload);
    h += (h << 5) + Objects.hashCode(error);
    return h;
  }

  /**
   * Prints the immutable value {@code CreatureResponse} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "CreatureResponse{"
        + "creaturePayload=" + creaturePayload
        + ", error=" + error
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "CreatureResponse", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements CreatureResponse {
    CreaturePayload creaturePayload;
    ErrorDto error;
    @JsonProperty("creature")
    public void setCreaturePayload(@Nullable CreaturePayload creaturePayload) {
      this.creaturePayload = creaturePayload;
    }
    @JsonProperty("error")
    public void setError(@Nullable ErrorDto error) {
      this.error = error;
    }
    @Override
    public CreaturePayload getCreaturePayload() { throw new UnsupportedOperationException(); }
    @Override
    public ErrorDto getError() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableCreatureResponse fromJson(Json json) {
    ImmutableCreatureResponse.Builder builder = ImmutableCreatureResponse.builder();
    if (json.creaturePayload != null) {
      builder.creaturePayload(json.creaturePayload);
    }
    if (json.error != null) {
      builder.error(json.error);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link CreatureResponse} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable CreatureResponse instance
   */
  public static ImmutableCreatureResponse copyOf(CreatureResponse instance) {
    if (instance instanceof ImmutableCreatureResponse) {
      return (ImmutableCreatureResponse) instance;
    }
    return ImmutableCreatureResponse.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableCreatureResponse ImmutableCreatureResponse}.
   * <pre>
   * ImmutableCreatureResponse.builder()
   *    .creaturePayload(com.personal.creaturekeeper.responses.CreaturePayload | null) // nullable {@link CreatureResponse#getCreaturePayload() creaturePayload}
   *    .error(com.personal.creaturekeeper.responses.ErrorDto | null) // nullable {@link CreatureResponse#getError() error}
   *    .build();
   * </pre>
   * @return A new ImmutableCreatureResponse builder
   */
  public static ImmutableCreatureResponse.Builder builder() {
    return new ImmutableCreatureResponse.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableCreatureResponse ImmutableCreatureResponse}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "CreatureResponse", generator = "Immutables")
  public static final class Builder {
    private CreaturePayload creaturePayload;
    private ErrorDto error;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code CreatureResponse} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(CreatureResponse instance) {
      Objects.requireNonNull(instance, "instance");
      CreaturePayload creaturePayloadValue = instance.getCreaturePayload();
      if (creaturePayloadValue != null) {
        creaturePayload(creaturePayloadValue);
      }
      ErrorDto errorValue = instance.getError();
      if (errorValue != null) {
        error(errorValue);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link CreatureResponse#getCreaturePayload() creaturePayload} attribute.
     * @param creaturePayload The value for creaturePayload (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("creature")
    public final Builder creaturePayload(@Nullable CreaturePayload creaturePayload) {
      this.creaturePayload = creaturePayload;
      return this;
    }

    /**
     * Initializes the value for the {@link CreatureResponse#getError() error} attribute.
     * @param error The value for error (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("error")
    public final Builder error(@Nullable ErrorDto error) {
      this.error = error;
      return this;
    }

    /**
     * Builds a new {@link ImmutableCreatureResponse ImmutableCreatureResponse}.
     * @return An immutable instance of CreatureResponse
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableCreatureResponse build() {
      return new ImmutableCreatureResponse(creaturePayload, error);
    }
  }
}
