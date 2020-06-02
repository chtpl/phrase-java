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
 * ProjectUpdateParameters
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-06-02T13:24:37.023Z[Etc/UTC]")
public class ProjectUpdateParameters {
  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_MAIN_FORMAT = "main_format";
  @SerializedName(SERIALIZED_NAME_MAIN_FORMAT)
  private String mainFormat;

  public static final String SERIALIZED_NAME_SHARES_TRANSLATION_MEMORY = "shares_translation_memory";
  @SerializedName(SERIALIZED_NAME_SHARES_TRANSLATION_MEMORY)
  private Boolean sharesTranslationMemory;

  public static final String SERIALIZED_NAME_PROJECT_IMAGE = "project_image";
  @SerializedName(SERIALIZED_NAME_PROJECT_IMAGE)
  private File projectImage;

  public static final String SERIALIZED_NAME_REMOVE_PROJECT_IMAGE = "remove_project_image";
  @SerializedName(SERIALIZED_NAME_REMOVE_PROJECT_IMAGE)
  private Boolean removeProjectImage;

  public static final String SERIALIZED_NAME_ACCOUNT_ID = "account_id";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_ID)
  private String accountId;


  public ProjectUpdateParameters name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Name of the project
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "My Android Project", value = "Name of the project")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public ProjectUpdateParameters mainFormat(String mainFormat) {
    
    this.mainFormat = mainFormat;
    return this;
  }

   /**
   * Main file format specified by its API Extension name. Used for locale downloads if no format is specified. For API Extension names of available file formats see &lt;a href&#x3D;\&quot;https://help.phrase.com/help/supported-platforms-and-formats\&quot;&gt;Format Guide&lt;/a&gt; or our &lt;a href&#x3D;\&quot;#formats\&quot;&gt;Formats API Endpoint&lt;/a&gt;.
   * @return mainFormat
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "yml", value = "Main file format specified by its API Extension name. Used for locale downloads if no format is specified. For API Extension names of available file formats see <a href=\"https://help.phrase.com/help/supported-platforms-and-formats\">Format Guide</a> or our <a href=\"#formats\">Formats API Endpoint</a>.")

  public String getMainFormat() {
    return mainFormat;
  }


  public void setMainFormat(String mainFormat) {
    this.mainFormat = mainFormat;
  }


  public ProjectUpdateParameters sharesTranslationMemory(Boolean sharesTranslationMemory) {
    
    this.sharesTranslationMemory = sharesTranslationMemory;
    return this;
  }

   /**
   * Indicates whether the project should share the account&#39;s translation memory
   * @return sharesTranslationMemory
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "true", value = "Indicates whether the project should share the account's translation memory")

  public Boolean getSharesTranslationMemory() {
    return sharesTranslationMemory;
  }


  public void setSharesTranslationMemory(Boolean sharesTranslationMemory) {
    this.sharesTranslationMemory = sharesTranslationMemory;
  }


  public ProjectUpdateParameters projectImage(File projectImage) {
    
    this.projectImage = projectImage;
    return this;
  }

   /**
   * Image to identify the project
   * @return projectImage
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Image to identify the project")

  public File getProjectImage() {
    return projectImage;
  }


  public void setProjectImage(File projectImage) {
    this.projectImage = projectImage;
  }


  public ProjectUpdateParameters removeProjectImage(Boolean removeProjectImage) {
    
    this.removeProjectImage = removeProjectImage;
    return this;
  }

   /**
   * Indicates whether the project image should be deleted.
   * @return removeProjectImage
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Indicates whether the project image should be deleted.")

  public Boolean getRemoveProjectImage() {
    return removeProjectImage;
  }


  public void setRemoveProjectImage(Boolean removeProjectImage) {
    this.removeProjectImage = removeProjectImage;
  }


  public ProjectUpdateParameters accountId(String accountId) {
    
    this.accountId = accountId;
    return this;
  }

   /**
   * Account ID to specify the actual account the project should be created in. Required if the requesting user is a member of multiple accounts.
   * @return accountId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "abcd1234", value = "Account ID to specify the actual account the project should be created in. Required if the requesting user is a member of multiple accounts.")

  public String getAccountId() {
    return accountId;
  }


  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProjectUpdateParameters projectUpdateParameters = (ProjectUpdateParameters) o;
    return Objects.equals(this.name, projectUpdateParameters.name) &&
        Objects.equals(this.mainFormat, projectUpdateParameters.mainFormat) &&
        Objects.equals(this.sharesTranslationMemory, projectUpdateParameters.sharesTranslationMemory) &&
        Objects.equals(this.projectImage, projectUpdateParameters.projectImage) &&
        Objects.equals(this.removeProjectImage, projectUpdateParameters.removeProjectImage) &&
        Objects.equals(this.accountId, projectUpdateParameters.accountId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, mainFormat, sharesTranslationMemory, projectImage, removeProjectImage, accountId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProjectUpdateParameters {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    mainFormat: ").append(toIndentedString(mainFormat)).append("\n");
    sb.append("    sharesTranslationMemory: ").append(toIndentedString(sharesTranslationMemory)).append("\n");
    sb.append("    projectImage: ").append(toIndentedString(projectImage)).append("\n");
    sb.append("    removeProjectImage: ").append(toIndentedString(removeProjectImage)).append("\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
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

