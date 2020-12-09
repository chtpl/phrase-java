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
 * UploadSummary
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-12-09T14:18:49.035Z[Etc/UTC]")
public class UploadSummary {
  public static final String SERIALIZED_NAME_LOCALES_CREATED = "locales_created";
  @SerializedName(SERIALIZED_NAME_LOCALES_CREATED)
  private Integer localesCreated;

  public static final String SERIALIZED_NAME_TRANSLATION_KEYS_CREATED = "translation_keys_created";
  @SerializedName(SERIALIZED_NAME_TRANSLATION_KEYS_CREATED)
  private Integer translationKeysCreated;

  public static final String SERIALIZED_NAME_TRANSLATION_KEYS_UPDATED = "translation_keys_updated";
  @SerializedName(SERIALIZED_NAME_TRANSLATION_KEYS_UPDATED)
  private Integer translationKeysUpdated;

  public static final String SERIALIZED_NAME_TRANSLATION_KEYS_UNMENTIONED = "translation_keys_unmentioned";
  @SerializedName(SERIALIZED_NAME_TRANSLATION_KEYS_UNMENTIONED)
  private Integer translationKeysUnmentioned;

  public static final String SERIALIZED_NAME_TRANSLATIONS_CREATED = "translations_created";
  @SerializedName(SERIALIZED_NAME_TRANSLATIONS_CREATED)
  private Integer translationsCreated;

  public static final String SERIALIZED_NAME_TRANSLATIONS_UPDATED = "translations_updated";
  @SerializedName(SERIALIZED_NAME_TRANSLATIONS_UPDATED)
  private Integer translationsUpdated;

  public static final String SERIALIZED_NAME_TAGS_CREATED = "tags_created";
  @SerializedName(SERIALIZED_NAME_TAGS_CREATED)
  private Integer tagsCreated;

  public static final String SERIALIZED_NAME_TRANSLATION_KEYS_IGNORED = "translation_keys_ignored";
  @SerializedName(SERIALIZED_NAME_TRANSLATION_KEYS_IGNORED)
  private Integer translationKeysIgnored;


  public UploadSummary localesCreated(Integer localesCreated) {
    
    this.localesCreated = localesCreated;
    return this;
  }

   /**
   * Get localesCreated
   * @return localesCreated
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getLocalesCreated() {
    return localesCreated;
  }


  public void setLocalesCreated(Integer localesCreated) {
    this.localesCreated = localesCreated;
  }


  public UploadSummary translationKeysCreated(Integer translationKeysCreated) {
    
    this.translationKeysCreated = translationKeysCreated;
    return this;
  }

   /**
   * Get translationKeysCreated
   * @return translationKeysCreated
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getTranslationKeysCreated() {
    return translationKeysCreated;
  }


  public void setTranslationKeysCreated(Integer translationKeysCreated) {
    this.translationKeysCreated = translationKeysCreated;
  }


  public UploadSummary translationKeysUpdated(Integer translationKeysUpdated) {
    
    this.translationKeysUpdated = translationKeysUpdated;
    return this;
  }

   /**
   * Get translationKeysUpdated
   * @return translationKeysUpdated
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getTranslationKeysUpdated() {
    return translationKeysUpdated;
  }


  public void setTranslationKeysUpdated(Integer translationKeysUpdated) {
    this.translationKeysUpdated = translationKeysUpdated;
  }


  public UploadSummary translationKeysUnmentioned(Integer translationKeysUnmentioned) {
    
    this.translationKeysUnmentioned = translationKeysUnmentioned;
    return this;
  }

   /**
   * Get translationKeysUnmentioned
   * @return translationKeysUnmentioned
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getTranslationKeysUnmentioned() {
    return translationKeysUnmentioned;
  }


  public void setTranslationKeysUnmentioned(Integer translationKeysUnmentioned) {
    this.translationKeysUnmentioned = translationKeysUnmentioned;
  }


  public UploadSummary translationsCreated(Integer translationsCreated) {
    
    this.translationsCreated = translationsCreated;
    return this;
  }

   /**
   * Get translationsCreated
   * @return translationsCreated
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getTranslationsCreated() {
    return translationsCreated;
  }


  public void setTranslationsCreated(Integer translationsCreated) {
    this.translationsCreated = translationsCreated;
  }


  public UploadSummary translationsUpdated(Integer translationsUpdated) {
    
    this.translationsUpdated = translationsUpdated;
    return this;
  }

   /**
   * Get translationsUpdated
   * @return translationsUpdated
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getTranslationsUpdated() {
    return translationsUpdated;
  }


  public void setTranslationsUpdated(Integer translationsUpdated) {
    this.translationsUpdated = translationsUpdated;
  }


  public UploadSummary tagsCreated(Integer tagsCreated) {
    
    this.tagsCreated = tagsCreated;
    return this;
  }

   /**
   * Get tagsCreated
   * @return tagsCreated
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getTagsCreated() {
    return tagsCreated;
  }


  public void setTagsCreated(Integer tagsCreated) {
    this.tagsCreated = tagsCreated;
  }


  public UploadSummary translationKeysIgnored(Integer translationKeysIgnored) {
    
    this.translationKeysIgnored = translationKeysIgnored;
    return this;
  }

   /**
   * Get translationKeysIgnored
   * @return translationKeysIgnored
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getTranslationKeysIgnored() {
    return translationKeysIgnored;
  }


  public void setTranslationKeysIgnored(Integer translationKeysIgnored) {
    this.translationKeysIgnored = translationKeysIgnored;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UploadSummary uploadSummary = (UploadSummary) o;
    return Objects.equals(this.localesCreated, uploadSummary.localesCreated) &&
        Objects.equals(this.translationKeysCreated, uploadSummary.translationKeysCreated) &&
        Objects.equals(this.translationKeysUpdated, uploadSummary.translationKeysUpdated) &&
        Objects.equals(this.translationKeysUnmentioned, uploadSummary.translationKeysUnmentioned) &&
        Objects.equals(this.translationsCreated, uploadSummary.translationsCreated) &&
        Objects.equals(this.translationsUpdated, uploadSummary.translationsUpdated) &&
        Objects.equals(this.tagsCreated, uploadSummary.tagsCreated) &&
        Objects.equals(this.translationKeysIgnored, uploadSummary.translationKeysIgnored);
  }

  @Override
  public int hashCode() {
    return Objects.hash(localesCreated, translationKeysCreated, translationKeysUpdated, translationKeysUnmentioned, translationsCreated, translationsUpdated, tagsCreated, translationKeysIgnored);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UploadSummary {\n");
    sb.append("    localesCreated: ").append(toIndentedString(localesCreated)).append("\n");
    sb.append("    translationKeysCreated: ").append(toIndentedString(translationKeysCreated)).append("\n");
    sb.append("    translationKeysUpdated: ").append(toIndentedString(translationKeysUpdated)).append("\n");
    sb.append("    translationKeysUnmentioned: ").append(toIndentedString(translationKeysUnmentioned)).append("\n");
    sb.append("    translationsCreated: ").append(toIndentedString(translationsCreated)).append("\n");
    sb.append("    translationsUpdated: ").append(toIndentedString(translationsUpdated)).append("\n");
    sb.append("    tagsCreated: ").append(toIndentedString(tagsCreated)).append("\n");
    sb.append("    translationKeysIgnored: ").append(toIndentedString(translationKeysIgnored)).append("\n");
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

