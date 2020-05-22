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
import com.phrase.client.model.TranslationKey;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.time.OffsetDateTime;

/**
 * ScreenshotMarker
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-05-22T13:14:31.005Z[Etc/UTC]")
public class ScreenshotMarker {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_PRESENTATION = "presentation";
  @SerializedName(SERIALIZED_NAME_PRESENTATION)
  private String presentation;

  public static final String SERIALIZED_NAME_PRESENTATION_TYPE = "presentation_type";
  @SerializedName(SERIALIZED_NAME_PRESENTATION_TYPE)
  private String presentationType;

  public static final String SERIALIZED_NAME_CREATED_AT = "created_at";
  @SerializedName(SERIALIZED_NAME_CREATED_AT)
  private OffsetDateTime createdAt;

  public static final String SERIALIZED_NAME_UPDATED_AT = "updated_at";
  @SerializedName(SERIALIZED_NAME_UPDATED_AT)
  private OffsetDateTime updatedAt;

  public static final String SERIALIZED_NAME_TRANSLATION_KEY = "translation_key";
  @SerializedName(SERIALIZED_NAME_TRANSLATION_KEY)
  private TranslationKey translationKey;


  public ScreenshotMarker id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public ScreenshotMarker presentation(String presentation) {
    
    this.presentation = presentation;
    return this;
  }

   /**
   * Get presentation
   * @return presentation
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getPresentation() {
    return presentation;
  }


  public void setPresentation(String presentation) {
    this.presentation = presentation;
  }


  public ScreenshotMarker presentationType(String presentationType) {
    
    this.presentationType = presentationType;
    return this;
  }

   /**
   * Get presentationType
   * @return presentationType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getPresentationType() {
    return presentationType;
  }


  public void setPresentationType(String presentationType) {
    this.presentationType = presentationType;
  }


  public ScreenshotMarker createdAt(OffsetDateTime createdAt) {
    
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Get createdAt
   * @return createdAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }


  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }


  public ScreenshotMarker updatedAt(OffsetDateTime updatedAt) {
    
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * Get updatedAt
   * @return updatedAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public OffsetDateTime getUpdatedAt() {
    return updatedAt;
  }


  public void setUpdatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }


  public ScreenshotMarker translationKey(TranslationKey translationKey) {
    
    this.translationKey = translationKey;
    return this;
  }

   /**
   * Get translationKey
   * @return translationKey
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public TranslationKey getTranslationKey() {
    return translationKey;
  }


  public void setTranslationKey(TranslationKey translationKey) {
    this.translationKey = translationKey;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ScreenshotMarker screenshotMarker = (ScreenshotMarker) o;
    return Objects.equals(this.id, screenshotMarker.id) &&
        Objects.equals(this.presentation, screenshotMarker.presentation) &&
        Objects.equals(this.presentationType, screenshotMarker.presentationType) &&
        Objects.equals(this.createdAt, screenshotMarker.createdAt) &&
        Objects.equals(this.updatedAt, screenshotMarker.updatedAt) &&
        Objects.equals(this.translationKey, screenshotMarker.translationKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, presentation, presentationType, createdAt, updatedAt, translationKey);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ScreenshotMarker {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    presentation: ").append(toIndentedString(presentation)).append("\n");
    sb.append("    presentationType: ").append(toIndentedString(presentationType)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    translationKey: ").append(toIndentedString(translationKey)).append("\n");
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
