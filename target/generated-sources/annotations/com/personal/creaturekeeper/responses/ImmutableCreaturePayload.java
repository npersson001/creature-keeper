package com.personal.creaturekeeper.responses;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link CreaturePayload}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableCreaturePayload.builder()}.
 */
@Generated(from = "CreaturePayload", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableCreaturePayload implements CreaturePayload {
  private final long id;
  private final String name;
  private final String species;
  private final int age;

  private ImmutableCreaturePayload(long id, String name, String species, int age) {
    this.id = id;
    this.name = name;
    this.species = species;
    this.age = age;
  }

  /**
   * @return The value of the {@code id} attribute
   */
  @JsonProperty("id")
  @Override
  public long getId() {
    return id;
  }

  /**
   * @return The value of the {@code name} attribute
   */
  @JsonProperty("name")
  @Override
  public String getName() {
    return name;
  }

  /**
   * @return The value of the {@code species} attribute
   */
  @JsonProperty("species")
  @Override
  public String getSpecies() {
    return species;
  }

  /**
   * @return The value of the {@code age} attribute
   */
  @JsonProperty("age")
  @Override
  public int getAge() {
    return age;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CreaturePayload#getId() id} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for id
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCreaturePayload withId(long value) {
    if (this.id == value) return this;
    return new ImmutableCreaturePayload(value, this.name, this.species, this.age);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CreaturePayload#getName() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCreaturePayload withName(String value) {
    String newValue = Objects.requireNonNull(value, "name");
    if (this.name.equals(newValue)) return this;
    return new ImmutableCreaturePayload(this.id, newValue, this.species, this.age);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CreaturePayload#getSpecies() species} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for species
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCreaturePayload withSpecies(String value) {
    String newValue = Objects.requireNonNull(value, "species");
    if (this.species.equals(newValue)) return this;
    return new ImmutableCreaturePayload(this.id, this.name, newValue, this.age);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CreaturePayload#getAge() age} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for age
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCreaturePayload withAge(int value) {
    if (this.age == value) return this;
    return new ImmutableCreaturePayload(this.id, this.name, this.species, value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableCreaturePayload} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableCreaturePayload
        && equalTo((ImmutableCreaturePayload) another);
  }

  private boolean equalTo(ImmutableCreaturePayload another) {
    return id == another.id
        && name.equals(another.name)
        && species.equals(another.species)
        && age == another.age;
  }

  /**
   * Computes a hash code from attributes: {@code id}, {@code name}, {@code species}, {@code age}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + Long.hashCode(id);
    h += (h << 5) + name.hashCode();
    h += (h << 5) + species.hashCode();
    h += (h << 5) + age;
    return h;
  }

  /**
   * Prints the immutable value {@code CreaturePayload} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "CreaturePayload{"
        + "id=" + id
        + ", name=" + name
        + ", species=" + species
        + ", age=" + age
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "CreaturePayload", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements CreaturePayload {
    long id;
    boolean idIsSet;
    String name;
    String species;
    int age;
    boolean ageIsSet;
    @JsonProperty("id")
    public void setId(long id) {
      this.id = id;
      this.idIsSet = true;
    }
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
    public long getId() { throw new UnsupportedOperationException(); }
    @Override
    public String getName() { throw new UnsupportedOperationException(); }
    @Override
    public String getSpecies() { throw new UnsupportedOperationException(); }
    @Override
    public int getAge() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableCreaturePayload fromJson(Json json) {
    ImmutableCreaturePayload.Builder builder = ImmutableCreaturePayload.builder();
    if (json.idIsSet) {
      builder.id(json.id);
    }
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
   * Creates an immutable copy of a {@link CreaturePayload} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable CreaturePayload instance
   */
  public static ImmutableCreaturePayload copyOf(CreaturePayload instance) {
    if (instance instanceof ImmutableCreaturePayload) {
      return (ImmutableCreaturePayload) instance;
    }
    return ImmutableCreaturePayload.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableCreaturePayload ImmutableCreaturePayload}.
   * <pre>
   * ImmutableCreaturePayload.builder()
   *    .id(long) // required {@link CreaturePayload#getId() id}
   *    .name(String) // required {@link CreaturePayload#getName() name}
   *    .species(String) // required {@link CreaturePayload#getSpecies() species}
   *    .age(int) // required {@link CreaturePayload#getAge() age}
   *    .build();
   * </pre>
   * @return A new ImmutableCreaturePayload builder
   */
  public static ImmutableCreaturePayload.Builder builder() {
    return new ImmutableCreaturePayload.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableCreaturePayload ImmutableCreaturePayload}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "CreaturePayload", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_ID = 0x1L;
    private static final long INIT_BIT_NAME = 0x2L;
    private static final long INIT_BIT_SPECIES = 0x4L;
    private static final long INIT_BIT_AGE = 0x8L;
    private long initBits = 0xfL;

    private long id;
    private String name;
    private String species;
    private int age;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code CreaturePayload} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(CreaturePayload instance) {
      Objects.requireNonNull(instance, "instance");
      id(instance.getId());
      name(instance.getName());
      species(instance.getSpecies());
      age(instance.getAge());
      return this;
    }

    /**
     * Initializes the value for the {@link CreaturePayload#getId() id} attribute.
     * @param id The value for id 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("id")
    public final Builder id(long id) {
      this.id = id;
      initBits &= ~INIT_BIT_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link CreaturePayload#getName() name} attribute.
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
     * Initializes the value for the {@link CreaturePayload#getSpecies() species} attribute.
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
     * Initializes the value for the {@link CreaturePayload#getAge() age} attribute.
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
     * Builds a new {@link ImmutableCreaturePayload ImmutableCreaturePayload}.
     * @return An immutable instance of CreaturePayload
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableCreaturePayload build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableCreaturePayload(id, name, species, age);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_ID) != 0) attributes.add("id");
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      if ((initBits & INIT_BIT_SPECIES) != 0) attributes.add("species");
      if ((initBits & INIT_BIT_AGE) != 0) attributes.add("age");
      return "Cannot build CreaturePayload, some of required attributes are not set " + attributes;
    }
  }
}
