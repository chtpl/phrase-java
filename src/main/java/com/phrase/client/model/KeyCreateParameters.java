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
import java.io.File;
import java.io.IOException;

/**
 * KeyCreateParameters
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-12-10T13:03:36.113Z[Etc/UTC]")
public class KeyCreateParameters {
  public static final String SERIALIZED_NAME_BRANCH = "branch";
  @SerializedName(SERIALIZED_NAME_BRANCH)
  private String branch;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_PLURAL = "plural";
  @SerializedName(SERIALIZED_NAME_PLURAL)
  private Boolean plural;

  public static final String SERIALIZED_NAME_NAME_PLURAL = "name_plural";
  @SerializedName(SERIALIZED_NAME_NAME_PLURAL)
  private String namePlural;

  public static final String SERIALIZED_NAME_DATA_TYPE = "data_type";
  @SerializedName(SERIALIZED_NAME_DATA_TYPE)
  private String dataType;

  public static final String SERIALIZED_NAME_TAGS = "tags";
  @SerializedName(SERIALIZED_NAME_TAGS)
  private String tags;

  public static final String SERIALIZED_NAME_MAX_CHARACTERS_ALLOWED = "max_characters_allowed";
  @SerializedName(SERIALIZED_NAME_MAX_CHARACTERS_ALLOWED)
  private Integer maxCharactersAllowed;

  public static final String SERIALIZED_NAME_SCREENSHOT = "screenshot";
  @SerializedName(SERIALIZED_NAME_SCREENSHOT)
  private File screenshot;

  public static final String SERIALIZED_NAME_REMOVE_SCREENSHOT = "remove_screenshot";
  @SerializedName(SERIALIZED_NAME_REMOVE_SCREENSHOT)
  private Boolean removeScreenshot;

  public static final String SERIALIZED_NAME_UNFORMATTED = "unformatted";
  @SerializedName(SERIALIZED_NAME_UNFORMATTED)
  private Boolean unformatted;

  public static final String SERIALIZED_NAME_XML_SPACE_PRESERVE = "xml_space_preserve";
  @SerializedName(SERIALIZED_NAME_XML_SPACE_PRESERVE)
  private Boolean xmlSpacePreserve;

  public static final String SERIALIZED_NAME_ORIGINAL_FILE = "original_file";
  @SerializedName(SERIALIZED_NAME_ORIGINAL_FILE)
  private String originalFile;

  public static final String SERIALIZED_NAME_LOCALIZED_FORMAT_STRING = "localized_format_string";
  @SerializedName(SERIALIZED_NAME_LOCALIZED_FORMAT_STRING)
  private String localizedFormatString;

  public static final String SERIALIZED_NAME_LOCALIZED_FORMAT_KEY = "localized_format_key";
  @SerializedName(SERIALIZED_NAME_LOCALIZED_FORMAT_KEY)
  private String localizedFormatKey;


  public KeyCreateParameters branch(String branch) {
    
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


  public KeyCreateParameters name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Key name
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "home.index.headline", value = "Key name")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public KeyCreateParameters description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * Key description (usually includes contextual information for translators)
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Some description worth knowing...", value = "Key description (usually includes contextual information for translators)")

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    this.description = description;
  }


  public KeyCreateParameters plural(Boolean plural) {
    
    this.plural = plural;
    return this;
  }

   /**
   * Indicates whether key supports pluralization
   * @return plural
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Indicates whether key supports pluralization")

  public Boolean getPlural() {
    return plural;
  }


  public void setPlural(Boolean plural) {
    this.plural = plural;
  }


  public KeyCreateParameters namePlural(String namePlural) {
    
    this.namePlural = namePlural;
    return this;
  }

   /**
   * Plural name for the key (used in some file formats, e.g. Gettext)
   * @return namePlural
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "home.index.headlines", value = "Plural name for the key (used in some file formats, e.g. Gettext)")

  public String getNamePlural() {
    return namePlural;
  }


  public void setNamePlural(String namePlural) {
    this.namePlural = namePlural;
  }


  public KeyCreateParameters dataType(String dataType) {
    
    this.dataType = dataType;
    return this;
  }

   /**
   * Type of the key. Can be one of the following: string, number, boolean, array, markdown.
   * @return dataType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "number", value = "Type of the key. Can be one of the following: string, number, boolean, array, markdown.")

  public String getDataType() {
    return dataType;
  }


  public void setDataType(String dataType) {
    this.dataType = dataType;
  }


  public KeyCreateParameters tags(String tags) {
    
    this.tags = tags;
    return this;
  }

   /**
   * List of tags separated by comma to be associated with the key.
   * @return tags
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "awesome-feature,needs-proofreading", value = "List of tags separated by comma to be associated with the key.")

  public String getTags() {
    return tags;
  }


  public void setTags(String tags) {
    this.tags = tags;
  }


  public KeyCreateParameters maxCharactersAllowed(Integer maxCharactersAllowed) {
    
    this.maxCharactersAllowed = maxCharactersAllowed;
    return this;
  }

   /**
   * Max. number of characters translations for this key can have.
   * @return maxCharactersAllowed
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "140", value = "Max. number of characters translations for this key can have.")

  public Integer getMaxCharactersAllowed() {
    return maxCharactersAllowed;
  }


  public void setMaxCharactersAllowed(Integer maxCharactersAllowed) {
    this.maxCharactersAllowed = maxCharactersAllowed;
  }


  public KeyCreateParameters screenshot(File screenshot) {
    
    this.screenshot = screenshot;
    return this;
  }

   /**
   * Screenshot/image for the key. This parameter is deprecated. Please use the Screenshots endpoint instead.
   * @return screenshot
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Screenshot/image for the key. This parameter is deprecated. Please use the Screenshots endpoint instead.")

  public File getScreenshot() {
    return screenshot;
  }


  public void setScreenshot(File screenshot) {
    this.screenshot = screenshot;
  }


  public KeyCreateParameters removeScreenshot(Boolean removeScreenshot) {
    
    this.removeScreenshot = removeScreenshot;
    return this;
  }

   /**
   * Indicates whether the screenshot will be deleted. This parameter is deprecated. Please use the Screenshots endpoint instead.
   * @return removeScreenshot
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Indicates whether the screenshot will be deleted. This parameter is deprecated. Please use the Screenshots endpoint instead.")

  public Boolean getRemoveScreenshot() {
    return removeScreenshot;
  }


  public void setRemoveScreenshot(Boolean removeScreenshot) {
    this.removeScreenshot = removeScreenshot;
  }


  public KeyCreateParameters unformatted(Boolean unformatted) {
    
    this.unformatted = unformatted;
    return this;
  }

   /**
   * Indicates whether the key should be exported as \&quot;unformatted\&quot;. Supported by Android XML and other formats.
   * @return unformatted
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Indicates whether the key should be exported as \"unformatted\". Supported by Android XML and other formats.")

  public Boolean getUnformatted() {
    return unformatted;
  }


  public void setUnformatted(Boolean unformatted) {
    this.unformatted = unformatted;
  }


  public KeyCreateParameters xmlSpacePreserve(Boolean xmlSpacePreserve) {
    
    this.xmlSpacePreserve = xmlSpacePreserve;
    return this;
  }

   /**
   * Indicates whether the key should be exported with \&quot;xml:space&#x3D;preserve\&quot;. Supported by several XML-based formats.
   * @return xmlSpacePreserve
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Indicates whether the key should be exported with \"xml:space=preserve\". Supported by several XML-based formats.")

  public Boolean getXmlSpacePreserve() {
    return xmlSpacePreserve;
  }


  public void setXmlSpacePreserve(Boolean xmlSpacePreserve) {
    this.xmlSpacePreserve = xmlSpacePreserve;
  }


  public KeyCreateParameters originalFile(String originalFile) {
    
    this.originalFile = originalFile;
    return this;
  }

   /**
   * Original file attribute. Used in some formats, e.g. XLIFF.
   * @return originalFile
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Original file attribute. Used in some formats, e.g. XLIFF.")

  public String getOriginalFile() {
    return originalFile;
  }


  public void setOriginalFile(String originalFile) {
    this.originalFile = originalFile;
  }


  public KeyCreateParameters localizedFormatString(String localizedFormatString) {
    
    this.localizedFormatString = localizedFormatString;
    return this;
  }

   /**
   * NSStringLocalizedFormatKey attribute. Used in .stringsdict format.
   * @return localizedFormatString
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "NSStringLocalizedFormatKey attribute. Used in .stringsdict format.")

  public String getLocalizedFormatString() {
    return localizedFormatString;
  }


  public void setLocalizedFormatString(String localizedFormatString) {
    this.localizedFormatString = localizedFormatString;
  }


  public KeyCreateParameters localizedFormatKey(String localizedFormatKey) {
    
    this.localizedFormatKey = localizedFormatKey;
    return this;
  }

   /**
   * NSStringLocalizedFormatKey attribute. Used in .stringsdict format.
   * @return localizedFormatKey
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "NSStringLocalizedFormatKey attribute. Used in .stringsdict format.")

  public String getLocalizedFormatKey() {
    return localizedFormatKey;
  }


  public void setLocalizedFormatKey(String localizedFormatKey) {
    this.localizedFormatKey = localizedFormatKey;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KeyCreateParameters keyCreateParameters = (KeyCreateParameters) o;
    return Objects.equals(this.branch, keyCreateParameters.branch) &&
        Objects.equals(this.name, keyCreateParameters.name) &&
        Objects.equals(this.description, keyCreateParameters.description) &&
        Objects.equals(this.plural, keyCreateParameters.plural) &&
        Objects.equals(this.namePlural, keyCreateParameters.namePlural) &&
        Objects.equals(this.dataType, keyCreateParameters.dataType) &&
        Objects.equals(this.tags, keyCreateParameters.tags) &&
        Objects.equals(this.maxCharactersAllowed, keyCreateParameters.maxCharactersAllowed) &&
        Objects.equals(this.screenshot, keyCreateParameters.screenshot) &&
        Objects.equals(this.removeScreenshot, keyCreateParameters.removeScreenshot) &&
        Objects.equals(this.unformatted, keyCreateParameters.unformatted) &&
        Objects.equals(this.xmlSpacePreserve, keyCreateParameters.xmlSpacePreserve) &&
        Objects.equals(this.originalFile, keyCreateParameters.originalFile) &&
        Objects.equals(this.localizedFormatString, keyCreateParameters.localizedFormatString) &&
        Objects.equals(this.localizedFormatKey, keyCreateParameters.localizedFormatKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(branch, name, description, plural, namePlural, dataType, tags, maxCharactersAllowed, screenshot, removeScreenshot, unformatted, xmlSpacePreserve, originalFile, localizedFormatString, localizedFormatKey);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class KeyCreateParameters {\n");
    sb.append("    branch: ").append(toIndentedString(branch)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    plural: ").append(toIndentedString(plural)).append("\n");
    sb.append("    namePlural: ").append(toIndentedString(namePlural)).append("\n");
    sb.append("    dataType: ").append(toIndentedString(dataType)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    maxCharactersAllowed: ").append(toIndentedString(maxCharactersAllowed)).append("\n");
    sb.append("    screenshot: ").append(toIndentedString(screenshot)).append("\n");
    sb.append("    removeScreenshot: ").append(toIndentedString(removeScreenshot)).append("\n");
    sb.append("    unformatted: ").append(toIndentedString(unformatted)).append("\n");
    sb.append("    xmlSpacePreserve: ").append(toIndentedString(xmlSpacePreserve)).append("\n");
    sb.append("    originalFile: ").append(toIndentedString(originalFile)).append("\n");
    sb.append("    localizedFormatString: ").append(toIndentedString(localizedFormatString)).append("\n");
    sb.append("    localizedFormatKey: ").append(toIndentedString(localizedFormatKey)).append("\n");
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

