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
import com.phrase.client.model.ProjectShort;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * BitbucketSync
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-06-09T07:13:53.645Z[Etc/UTC]")
public class BitbucketSync {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_REPOSITORY_NAME = "repository_name";
  @SerializedName(SERIALIZED_NAME_REPOSITORY_NAME)
  private String repositoryName;

  public static final String SERIALIZED_NAME_LAST_EXPORT_TO_BITBUCKET_AT = "last_export_to_bitbucket_at";
  @SerializedName(SERIALIZED_NAME_LAST_EXPORT_TO_BITBUCKET_AT)
  private OffsetDateTime lastExportToBitbucketAt;

  public static final String SERIALIZED_NAME_LAST_IMPORT_FROM_BITBUCKET_AT = "last_import_from_bitbucket_at";
  @SerializedName(SERIALIZED_NAME_LAST_IMPORT_FROM_BITBUCKET_AT)
  private OffsetDateTime lastImportFromBitbucketAt;

  public static final String SERIALIZED_NAME_VALID_PHRASEAPP_YAML = "valid_phraseapp_yaml";
  @SerializedName(SERIALIZED_NAME_VALID_PHRASEAPP_YAML)
  private Boolean validPhraseappYaml;

  public static final String SERIALIZED_NAME_PHRASEAPP_PROJECTS = "phraseapp_projects";
  @SerializedName(SERIALIZED_NAME_PHRASEAPP_PROJECTS)
  private List<ProjectShort> phraseappProjects = null;


  public BitbucketSync id(String id) {
    
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


  public BitbucketSync repositoryName(String repositoryName) {
    
    this.repositoryName = repositoryName;
    return this;
  }

   /**
   * Get repositoryName
   * @return repositoryName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getRepositoryName() {
    return repositoryName;
  }


  public void setRepositoryName(String repositoryName) {
    this.repositoryName = repositoryName;
  }


  public BitbucketSync lastExportToBitbucketAt(OffsetDateTime lastExportToBitbucketAt) {
    
    this.lastExportToBitbucketAt = lastExportToBitbucketAt;
    return this;
  }

   /**
   * Get lastExportToBitbucketAt
   * @return lastExportToBitbucketAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public OffsetDateTime getLastExportToBitbucketAt() {
    return lastExportToBitbucketAt;
  }


  public void setLastExportToBitbucketAt(OffsetDateTime lastExportToBitbucketAt) {
    this.lastExportToBitbucketAt = lastExportToBitbucketAt;
  }


  public BitbucketSync lastImportFromBitbucketAt(OffsetDateTime lastImportFromBitbucketAt) {
    
    this.lastImportFromBitbucketAt = lastImportFromBitbucketAt;
    return this;
  }

   /**
   * Get lastImportFromBitbucketAt
   * @return lastImportFromBitbucketAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public OffsetDateTime getLastImportFromBitbucketAt() {
    return lastImportFromBitbucketAt;
  }


  public void setLastImportFromBitbucketAt(OffsetDateTime lastImportFromBitbucketAt) {
    this.lastImportFromBitbucketAt = lastImportFromBitbucketAt;
  }


  public BitbucketSync validPhraseappYaml(Boolean validPhraseappYaml) {
    
    this.validPhraseappYaml = validPhraseappYaml;
    return this;
  }

   /**
   * Get validPhraseappYaml
   * @return validPhraseappYaml
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getValidPhraseappYaml() {
    return validPhraseappYaml;
  }


  public void setValidPhraseappYaml(Boolean validPhraseappYaml) {
    this.validPhraseappYaml = validPhraseappYaml;
  }


  public BitbucketSync phraseappProjects(List<ProjectShort> phraseappProjects) {
    
    this.phraseappProjects = phraseappProjects;
    return this;
  }

  public BitbucketSync addPhraseappProjectsItem(ProjectShort phraseappProjectsItem) {
    if (this.phraseappProjects == null) {
      this.phraseappProjects = new ArrayList<>();
    }
    this.phraseappProjects.add(phraseappProjectsItem);
    return this;
  }

   /**
   * Get phraseappProjects
   * @return phraseappProjects
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<ProjectShort> getPhraseappProjects() {
    return phraseappProjects;
  }


  public void setPhraseappProjects(List<ProjectShort> phraseappProjects) {
    this.phraseappProjects = phraseappProjects;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BitbucketSync bitbucketSync = (BitbucketSync) o;
    return Objects.equals(this.id, bitbucketSync.id) &&
        Objects.equals(this.repositoryName, bitbucketSync.repositoryName) &&
        Objects.equals(this.lastExportToBitbucketAt, bitbucketSync.lastExportToBitbucketAt) &&
        Objects.equals(this.lastImportFromBitbucketAt, bitbucketSync.lastImportFromBitbucketAt) &&
        Objects.equals(this.validPhraseappYaml, bitbucketSync.validPhraseappYaml) &&
        Objects.equals(this.phraseappProjects, bitbucketSync.phraseappProjects);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, repositoryName, lastExportToBitbucketAt, lastImportFromBitbucketAt, validPhraseappYaml, phraseappProjects);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BitbucketSync {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    repositoryName: ").append(toIndentedString(repositoryName)).append("\n");
    sb.append("    lastExportToBitbucketAt: ").append(toIndentedString(lastExportToBitbucketAt)).append("\n");
    sb.append("    lastImportFromBitbucketAt: ").append(toIndentedString(lastImportFromBitbucketAt)).append("\n");
    sb.append("    validPhraseappYaml: ").append(toIndentedString(validPhraseappYaml)).append("\n");
    sb.append("    phraseappProjects: ").append(toIndentedString(phraseappProjects)).append("\n");
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

