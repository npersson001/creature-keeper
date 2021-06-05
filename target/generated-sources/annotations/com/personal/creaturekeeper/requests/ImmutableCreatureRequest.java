package com.personal.creaturekeeper.requests;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link CreatureRequest}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableCreatureRequest.builder()}.
 */
@Generated(from = "CreatureRequest", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableCreatureRequest implements CreatureRequest {
  private final String name;
  private final String species;
  private final int age;

  private ImmutableCreatureRequest(String name, String species, int age) {
    this.name = name;
    this.species = species;
    this.age = age;
  }

  /**
   * @return The value of the {@code name} attribute
   */
  @JsonProperty("name")
  @Override
  public String name() {
    return name;
  }

  /**
   * @return The value of the {@code species} attribute
   */
  @JsonProperty("species")
  @Override
  public String species() {
    return species;
  }

  /**
   * @return The value of the {@code age} attribute
   */
  @JsonProperty("age")
  @Override
  public int age() {
    return age;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CreatureRequest#name() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCreatureRequest withName(String value) {
    String newValue = Objects.requireNonNull(value, "name");
    if (this.name.equals(newValue)) return this;
    return new ImmutableCreatureRequest(newValue, this.species, this.age);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CreatureRequest#species() species} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for species
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCreatureRequest withSpecies(String value) {
    String newValue = Objects.requireNonNull(value, "species");
    if (this.species.equals(newValue)) return this;
    return new ImmutableCreatureRequest(this.name, newValue, this.age);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CreatureRequest#age() age} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for age
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCreatureRequest withAge(int value) {
    if (this.age == value) return this;
    return new ImmutableCreatureRequest(this.name, this.species, value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableCreatureRequest} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableCreatureRequest
        && equalTo((ImmutableCreatureRequest) another);
  }

  private boolean equalTo(ImmutableCreatureRequest another) {
    return name.equals(another.name)
        && species.equals(another.species)
        && age == another.age;
  }

  /**
   * Computes a hash code from attributes: {@code name}, {@code species}, {@code age}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + name.hashCode();
    h += (h << 5) + species.hashCode();
    h += (h << 5) + age;
    return h;
  }

  /**
   * Prints the immutable value {@code CreatureRequest} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "CreatureRequest{"
        + "name=" + name
        + ", species=" + species
        + ", age=" + age
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "CreatureRequest", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements CreatureRequest {
    String name;
    String species;
    int age;
    boolean ageIsSet;
    @JsonProperty("name")
    public void setName(String name) {
      this.name = name;
    }
    @JsonProperty("species")
    public void setSpecies(String species) {
      this.species = species;
    }
    @JsonProperty("age")
    public void setAge(int age) {
      this.age = age;
      this.ageIsSet = true;
    }
    @Override
    public String name() { throw new UnsupportedOperationException(); }
    @Override
    public String species() { throw new UnsupportedOperationException(); }
    @Override
    public int age() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableCreatureRequest fromJson(Json json) {
    ImmutableCreatureRequest.Builder builder = ImmutableCreatureRequest.builder();
    if (json.name != null) {
      builder.name(json.name);
    }
    if (json.species != null) {
      builder.species(json.species);
    }
    if (json.ageIsSet) {
      builder.age(json.age);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link CreatureRequest} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable CreatureRequest instance
   */
  public static ImmutableCreatureRequest copyOf(CreatureRequest instance) {
    if (instance instanceof ImmutableCreatureRequest) {
      return (ImmutableCreatureRequest) instance;
    }
    return ImmutableCreatureRequest.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableCreatureRequest ImmutableCreatureRequest}.
   * <pre>
   * ImmutableCreatureRequest.builder()
   *    .name(String) // required {@link CreatureRequest#name() name}
   *    .species(String) // required {@link CreatureRequest#species() species}
   *    .age(int) // required {@link CreatureRequest#age() age}
   *    .build();
   * </pre>
   * @return A new ImmutableCreatureRequest builder
   */
  public static ImmutableCreatureRequest.Builder builder() {
    return new ImmutableCreatureRequest.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableCreatureRequest ImmutableCreatureRequest}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "CreatureRequest", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_NAME = 0x1L;
    private static final long INIT_BIT_SPECIES = 0x2L;
    private static final long INIT_BIT_AGE = 0x4L;
    private long initBits = 0x7L;

    private String name;
    private String species;
    private int age;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code CreatureRequest} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(CreatureRequest instance) {
      Objects.requireNonNull(instance, "instance");
      name(instance.name());
      species(instance.species());
      age(instance.age());
      return this;
    }

    /**
     * Initializes the value for the {@link CreatureRequest#name() name} attribute.
     * @param name The value for name 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("name")
    public final Builder name(String name) {
      this.name = Objects.requireNonNull(name, "name");
      initBits &= ~INIT_BIT_NAME;
      return this;
    }

    /**
     * Initializes the value for the {@link CreatureRequest#species() species} attribute.
     * @param species The value for species 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("species")
    public final Builder species(String species) {
      this.species = Objects.requireNonNull(species, "species");
      initBits &= ~INIT_BIT_SPECIES;
      return this;
    }

    /**
     * Initializes the value for the {@link CreatureRequest#age() age} attribute.
     * @param age The value for age 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("age")
    public final Builder age(int age) {
      this.age = age;
      initBits &= ~INIT_BIT_AGE;
      return this;
    }

    /**
     * Builds a new {@link ImmutableCreatureRequest ImmutableCreatureRequest}.
     * @return An immutable instance of CreatureRequest
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableCreatureRequest build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableCreatureRequest(name, species, age);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      if ((initBits & INIT_BIT_SPECIES) != 0) attributes.add("species");
      if ((initBits & INIT_BIT_AGE) != 0) attributes.add("age");
      return "Cannot build CreatureRequest, some of required attributes are not set " + attributes;
    }
  }
}