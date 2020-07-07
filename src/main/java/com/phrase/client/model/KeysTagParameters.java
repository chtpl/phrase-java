/*
 * Phrase API Reference
 *
 * The version of the OpenAPI document: 2.0.0
 * Contact: support@phrase.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.phrase.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * KeysTagParameters
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-07-07T17:26:27.614Z[Etc/UTC]")
public class KeysTagParameters {
  public static final String SERIALIZED_NAME_BRANCH = "branch";
  @SerializedName(SERIALIZED_NAME_BRANCH)
  private String branch;

  public static final String SERIALIZED_NAME_Q = "q";
  @SerializedName(SERIALIZED_NAME_Q)
  private String q;

  public static final String SERIALIZED_NAME_LOCALE_ID = "locale_id";
  @SerializedName(SERIALIZED_NAME_LOCALE_ID)
  private String localeId;

  public static final String SERIALIZED_NAME_TAGS = "tags";
  @SerializedName(SERIALIZED_NAME_TAGS)
  private String tags;


  public KeysTagParameters branch(String branch) {
    
    this.branch = branch;
    return this;
  }

   /**
   * specify the branch to use
   * @return branch
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "my-feature-branch", value = "specify the branch to use")

  public String getBranch() {
    return branch;
  }


  public void setBranch(String branch) {
    this.branch = branch;
  }


  public KeysTagParameters q(String q) {
    
    this.q = q;
    return this;
  }

   /**
   * q_description_placeholder
   * @return q
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "mykey* translated:true", value = "q_description_placeholder")

  public String getQ() {
    return q;
  }


  public void setQ(String q) {
    this.q = q;
  }


  public KeysTagParameters localeId(String localeId) {
    
    this.localeId = localeId;
    return this;
  }

   /**
   * Locale used to determine the translation state of a key when filtering for untranslated or translated keys.
   * @return localeId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "abcd1234abcd1234abcd1234abcd1234", value = "Locale used to determine the translation state of a key when filtering for untranslated or translated keys.")

  public String getLocaleId() {
    return localeId;
  }


  public void setLocaleId(String localeId) {
    this.localeId = localeId;
  }


  public KeysTagParameters tags(String tags) {
    
    this.tags = tags;
    return this;
  }

   /**
   * Tag or comma-separated list of tags to add to the matching collection of keys
   * @return tags
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "landing-page,release-1.2", value = "Tag or comma-separated list of tags to add to the matching collection of keys")

  public String getTags() {
    return tags;
  }


  public void setTags(String tags) {
    this.tags = tags;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KeysTagParameters keysTagParameters = (KeysTagParameters) o;
    return Objects.equals(this.branch, keysTagParameters.branch) &&
        Objects.equals(this.q, keysTagParameters.q) &&
        Objects.equals(this.localeId, keysTagParameters.localeId) &&
        Objects.equals(this.tags, keysTagParameters.tags);
  }

  @Override
  public int hashCode() {
    return Objects.hash(branch, q, localeId, tags);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class KeysTagParameters {\n");
    sb.append("    branch: ").append(toIndentedString(branch)).append("\n");
    sb.append("    q: ").append(toIndentedString(q)).append("\n");
    sb.append("    localeId: ").append(toIndentedString(localeId)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

