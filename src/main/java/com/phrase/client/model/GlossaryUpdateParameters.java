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
import java.util.ArrayList;
import java.util.List;

/**
 * GlossaryUpdateParameters
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-08-27T10:00:47.126Z[Etc/UTC]")
public class GlossaryUpdateParameters {
  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_PROJECT_IDS = "project_ids";
  @SerializedName(SERIALIZED_NAME_PROJECT_IDS)
  private String projectIds;

  public static final String SERIALIZED_NAME_SPACE_IDS = "space_ids";
  @SerializedName(SERIALIZED_NAME_SPACE_IDS)
  private List<String> spaceIds = null;


  public GlossaryUpdateParameters name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Name of the glossary
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "My glossary", value = "Name of the glossary")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public GlossaryUpdateParameters projectIds(String projectIds) {
    
    this.projectIds = projectIds;
    return this;
  }

   /**
   * List of project ids the glossary should be assigned to.
   * @return projectIds
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "abcd1234abcd1234abcd1234,abcd1234abcd1234abcd1235", value = "List of project ids the glossary should be assigned to.")

  public String getProjectIds() {
    return projectIds;
  }


  public void setProjectIds(String projectIds) {
    this.projectIds = projectIds;
  }


  public GlossaryUpdateParameters spaceIds(List<String> spaceIds) {
    
    this.spaceIds = spaceIds;
    return this;
  }

  public GlossaryUpdateParameters addSpaceIdsItem(String spaceIdsItem) {
    if (this.spaceIds == null) {
      this.spaceIds = new ArrayList<>();
    }
    this.spaceIds.add(spaceIdsItem);
    return this;
  }

   /**
   * List of space ids the glossary should be assigned to.
   * @return spaceIds
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "[\"abcd1234abcd1234abcd1234\",\"abcd1234abcd1234abcd1235\"]", value = "List of space ids the glossary should be assigned to.")

  public List<String> getSpaceIds() {
    return spaceIds;
  }


  public void setSpaceIds(List<String> spaceIds) {
    this.spaceIds = spaceIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GlossaryUpdateParameters glossaryUpdateParameters = (GlossaryUpdateParameters) o;
    return Objects.equals(this.name, glossaryUpdateParameters.name) &&
        Objects.equals(this.projectIds, glossaryUpdateParameters.projectIds) &&
        Objects.equals(this.spaceIds, glossaryUpdateParameters.spaceIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, projectIds, spaceIds);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GlossaryUpdateParameters {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    projectIds: ").append(toIndentedString(projectIds)).append("\n");
    sb.append("    spaceIds: ").append(toIndentedString(spaceIds)).append("\n");
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

