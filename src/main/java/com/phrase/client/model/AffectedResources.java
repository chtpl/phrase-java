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
 * AffectedResources
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-06-23T12:08:25.449Z[Etc/UTC]")
public class AffectedResources {
  public static final String SERIALIZED_NAME_RECORDS_AFFECTED = "records_affected";
  @SerializedName(SERIALIZED_NAME_RECORDS_AFFECTED)
  private Integer recordsAffected;


  public AffectedResources recordsAffected(Integer recordsAffected) {
    
    this.recordsAffected = recordsAffected;
    return this;
  }

   /**
   * Get recordsAffected
   * @return recordsAffected
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getRecordsAffected() {
    return recordsAffected;
  }


  public void setRecordsAffected(Integer recordsAffected) {
    this.recordsAffected = recordsAffected;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AffectedResources affectedResources = (AffectedResources) o;
    return Objects.equals(this.recordsAffected, affectedResources.recordsAffected);
  }

  @Override
  public int hashCode() {
    return Objects.hash(recordsAffected);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AffectedResources {\n");
    sb.append("    recordsAffected: ").append(toIndentedString(recordsAffected)).append("\n");
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

