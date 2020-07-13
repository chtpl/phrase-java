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
import com.phrase.client.model.UserPreview;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * TranslationKeyDetails1
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-07-13T12:59:33.611Z[Etc/UTC]")
public class TranslationKeyDetails1 {
  public static final String SERIALIZED_NAME_NAME_PLURAL = "name_plural";
  @SerializedName(SERIALIZED_NAME_NAME_PLURAL)
  private String namePlural;

  public static final String SERIALIZED_NAME_COMMENTS_COUNT = "comments_count";
  @SerializedName(SERIALIZED_NAME_COMMENTS_COUNT)
  private Integer commentsCount;

  public static final String SERIALIZED_NAME_MAX_CHARACTERS_ALLOWED = "max_characters_allowed";
  @SerializedName(SERIALIZED_NAME_MAX_CHARACTERS_ALLOWED)
  private Integer maxCharactersAllowed;

  public static final String SERIALIZED_NAME_SCREENSHOT_URL = "screenshot_url";
  @SerializedName(SERIALIZED_NAME_SCREENSHOT_URL)
  private String screenshotUrl;

  public static final String SERIALIZED_NAME_UNFORMATTED = "unformatted";
  @SerializedName(SERIALIZED_NAME_UNFORMATTED)
  private Boolean unformatted;

  public static final String SERIALIZED_NAME_XML_SPACE_PRESERVE = "xml_space_preserve";
  @SerializedName(SERIALIZED_NAME_XML_SPACE_PRESERVE)
  private Boolean xmlSpacePreserve;

  public static final String SERIALIZED_NAME_ORIGINAL_FILE = "original_file";
  @SerializedName(SERIALIZED_NAME_ORIGINAL_FILE)
  private String originalFile;

  public static final String SERIALIZED_NAME_FORMAT_VALUE_TYPE = "format_value_type";
  @SerializedName(SERIALIZED_NAME_FORMAT_VALUE_TYPE)
  private String formatValueType;

  public static final String SERIALIZED_NAME_CREATOR = "creator";
  @SerializedName(SERIALIZED_NAME_CREATOR)
  private UserPreview creator;


  public TranslationKeyDetails1 namePlural(String namePlural) {
    
    this.namePlural = namePlural;
    return this;
  }

   /**
   * Get namePlural
   * @return namePlural
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getNamePlural() {
    return namePlural;
  }


  public void setNamePlural(String namePlural) {
    this.namePlural = namePlural;
  }


  public TranslationKeyDetails1 commentsCount(Integer commentsCount) {
    
    this.commentsCount = commentsCount;
    return this;
  }

   /**
   * Get commentsCount
   * @return commentsCount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getCommentsCount() {
    return commentsCount;
  }


  public void setCommentsCount(Integer commentsCount) {
    this.commentsCount = commentsCount;
  }


  public TranslationKeyDetails1 maxCharactersAllowed(Integer maxCharactersAllowed) {
    
    this.maxCharactersAllowed = maxCharactersAllowed;
    return this;
  }

   /**
   * Get maxCharactersAllowed
   * @return maxCharactersAllowed
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getMaxCharactersAllowed() {
    return maxCharactersAllowed;
  }


  public void setMaxCharactersAllowed(Integer maxCharactersAllowed) {
    this.maxCharactersAllowed = maxCharactersAllowed;
  }


  public TranslationKeyDetails1 screenshotUrl(String screenshotUrl) {
    
    this.screenshotUrl = screenshotUrl;
    return this;
  }

   /**
   * Get screenshotUrl
   * @return screenshotUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getScreenshotUrl() {
    return screenshotUrl;
  }


  public void setScreenshotUrl(String screenshotUrl) {
    this.screenshotUrl = screenshotUrl;
  }


  public TranslationKeyDetails1 unformatted(Boolean unformatted) {
    
    this.unformatted = unformatted;
    return this;
  }

   /**
   * Get unformatted
   * @return unformatted
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getUnformatted() {
    return unformatted;
  }


  public void setUnformatted(Boolean unformatted) {
    this.unformatted = unformatted;
  }


  public TranslationKeyDetails1 xmlSpacePreserve(Boolean xmlSpacePreserve) {
    
    this.xmlSpacePreserve = xmlSpacePreserve;
    return this;
  }

   /**
   * Get xmlSpacePreserve
   * @return xmlSpacePreserve
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getXmlSpacePreserve() {
    return xmlSpacePreserve;
  }


  public void setXmlSpacePreserve(Boolean xmlSpacePreserve) {
    this.xmlSpacePreserve = xmlSpacePreserve;
  }


  public TranslationKeyDetails1 originalFile(String originalFile) {
    
    this.originalFile = originalFile;
    return this;
  }

   /**
   * Get originalFile
   * @return originalFile
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getOriginalFile() {
    return originalFile;
  }


  public void setOriginalFile(String originalFile) {
    this.originalFile = originalFile;
  }


  public TranslationKeyDetails1 formatValueType(String formatValueType) {
    
    this.formatValueType = formatValueType;
    return this;
  }

   /**
   * Get formatValueType
   * @return formatValueType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getFormatValueType() {
    return formatValueType;
  }


  public void setFormatValueType(String formatValueType) {
    this.formatValueType = formatValueType;
  }


  public TranslationKeyDetails1 creator(UserPreview creator) {
    
    this.creator = creator;
    return this;
  }

   /**
   * Get creator
   * @return creator
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public UserPreview getCreator() {
    return creator;
  }


  public void setCreator(UserPreview creator) {
    this.creator = creator;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TranslationKeyDetails1 translationKeyDetails1 = (TranslationKeyDetails1) o;
    return Objects.equals(this.namePlural, translationKeyDetails1.namePlural) &&
        Objects.equals(this.commentsCount, translationKeyDetails1.commentsCount) &&
        Objects.equals(this.maxCharactersAllowed, translationKeyDetails1.maxCharactersAllowed) &&
        Objects.equals(this.screenshotUrl, translationKeyDetails1.screenshotUrl) &&
        Objects.equals(this.unformatted, translationKeyDetails1.unformatted) &&
        Objects.equals(this.xmlSpacePreserve, translationKeyDetails1.xmlSpacePreserve) &&
        Objects.equals(this.originalFile, translationKeyDetails1.originalFile) &&
        Objects.equals(this.formatValueType, translationKeyDetails1.formatValueType) &&
        Objects.equals(this.creator, translationKeyDetails1.creator);
  }

  @Override
  public int hashCode() {
    return Objects.hash(namePlural, commentsCount, maxCharactersAllowed, screenshotUrl, unformatted, xmlSpacePreserve, originalFile, formatValueType, creator);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TranslationKeyDetails1 {\n");
    sb.append("    namePlural: ").append(toIndentedString(namePlural)).append("\n");
    sb.append("    commentsCount: ").append(toIndentedString(commentsCount)).append("\n");
    sb.append("    maxCharactersAllowed: ").append(toIndentedString(maxCharactersAllowed)).append("\n");
    sb.append("    screenshotUrl: ").append(toIndentedString(screenshotUrl)).append("\n");
    sb.append("    unformatted: ").append(toIndentedString(unformatted)).append("\n");
    sb.append("    xmlSpacePreserve: ").append(toIndentedString(xmlSpacePreserve)).append("\n");
    sb.append("    originalFile: ").append(toIndentedString(originalFile)).append("\n");
    sb.append("    formatValueType: ").append(toIndentedString(formatValueType)).append("\n");
    sb.append("    creator: ").append(toIndentedString(creator)).append("\n");
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

