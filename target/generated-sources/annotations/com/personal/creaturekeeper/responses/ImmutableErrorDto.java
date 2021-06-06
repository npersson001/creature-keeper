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
 * Immutable implementation of {@link ErrorDto}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableErrorDto.builder()}.
 */
@Generated(from = "ErrorDto", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableErrorDto implements ErrorDto {
  private final int code;
  private final String description;

  private ImmutableErrorDto(int code, String description) {
    this.code = code;
    this.description = description;
  }

  /**
   * @return The value of the {@code code} attribute
   */
  @JsonProperty("code")
  @Override
  public int getCode() {
    return code;
  }

  /**
   * @return The value of the {@code description} attribute
   */
  @JsonProperty("description")
  @Override
  public String getDescription() {
    return description;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ErrorDto#getCode() code} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for code
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableErrorDto withCode(int value) {
    if (this.code == value) return this;
    return new ImmutableErrorDto(value, this.description);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ErrorDto#getDescription() description} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for description
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableErrorDto withDescription(String value) {
    String newValue = Objects.requireNonNull(value, "description");
    if (this.description.equals(newValue)) return this;
    return new ImmutableErrorDto(this.code, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableErrorDto} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableErrorDto
        && equalTo((ImmutableErrorDto) another);
  }

  private boolean equalTo(ImmutableErrorDto another) {
    return code == another.code
        && description.equals(another.description);
  }

  /**
   * Computes a hash code from attributes: {@code code}, {@code description}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + code;
    h += (h << 5) + description.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code ErrorDto} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "ErrorDto{"
        + "code=" + code
        + ", description=" + description
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "ErrorDto", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements ErrorDto {
    int code;
    boolean codeIsSet;
    String description;
    @JsonProperty("code")
    public void setCode(int code) {
      this.code = code;
      this.codeIsSet = true;
    }
    @JsonProperty("description")
    public void setDescription(String description) {
      this.description = description;
    }
    @Override
    public int getCode() { throw new UnsupportedOperationException(); }
    @Override
    public String getDescription() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableErrorDto fromJson(Json json) {
    ImmutableErrorDto.Builder builder = ImmutableErrorDto.builder();
    if (json.codeIsSet) {
      builder.code(json.code);
    }
    if (json.description != null) {
      builder.description(json.description);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link ErrorDto} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable ErrorDto instance
   */
  public static ImmutableErrorDto copyOf(ErrorDto instance) {
    if (instance instanceof ImmutableErrorDto) {
      return (ImmutableErrorDto) instance;
    }
    return ImmutableErrorDto.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableErrorDto ImmutableErrorDto}.
   * <pre>
   * ImmutableErrorDto.builder()
   *    .code(int) // required {@link ErrorDto#getCode() code}
   *    .description(String) // required {@link ErrorDto#getDescription() description}
   *    .build();
   * </pre>
   * @return A new ImmutableErrorDto builder
   */
  public static ImmutableErrorDto.Builder builder() {
    return new ImmutableErrorDto.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableErrorDto ImmutableErrorDto}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "ErrorDto", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_CODE = 0x1L;
    private static final long INIT_BIT_DESCRIPTION = 0x2L;
    private long initBits = 0x3L;

    private int code;
    private String description;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ErrorDto} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ErrorDto instance) {
      Objects.requireNonNull(instance, "instance");
      code(instance.getCode());
      description(instance.getDescription());
      return this;
    }

    /**
     * Initializes the value for the {@link ErrorDto#getCode() code} attribute.
     * @param code The value for code 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("code")
    public final Builder code(int code) {
      this.code = code;
      initBits &= ~INIT_BIT_CODE;
      return this;
    }

    /**
     * Initializes the value for the {@link ErrorDto#getDescription() description} attribute.
     * @param description The value for description 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("description")
    public final Builder description(String description) {
      this.description = Objects.requireNonNull(description, "description");
      initBits &= ~INIT_BIT_DESCRIPTION;
      return this;
    }

    /**
     * Builds a new {@link ImmutableErrorDto ImmutableErrorDto}.
     * @return An immutable instance of ErrorDto
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableErrorDto build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableErrorDto(code, description);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_CODE) != 0) attributes.add("code");
      if ((initBits & INIT_BIT_DESCRIPTION) != 0) attributes.add("description");
      return "Cannot build ErrorDto, some of required attributes are not set " + attributes;
    }
  }
}
