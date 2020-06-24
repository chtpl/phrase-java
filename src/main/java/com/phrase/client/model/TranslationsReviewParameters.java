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
 * TranslationsReviewParameters
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-06-24T13:17:24.117Z[Etc/UTC]")
public class TranslationsReviewParameters {
  public static final String SERIALIZED_NAME_BRANCH = "branch";
  @SerializedName(SERIALIZED_NAME_BRANCH)
  private String branch;

  public static final String SERIALIZED_NAME_Q = "q";
  @SerializedName(SERIALIZED_NAME_Q)
  private String q;


  public TranslationsReviewParameters branch(String branch) {
    
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


  public TranslationsReviewParameters q(String q) {
    
    this.q = q;
    return this;
  }

   /**
   * q_description_placeholder
   * @return q
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "PhraseApp*%reviewed:false%20tags:feature,center", value = "q_description_placeholder")

  public String getQ() {
    return q;
  }


  public void setQ(String q) {
    this.q = q;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TranslationsReviewParameters translationsReviewParameters = (TranslationsReviewParameters) o;
    return Objects.equals(this.branch, translationsReviewParameters.branch) &&
        Objects.equals(this.q, translationsReviewParameters.q);
  }

  @Override
  public int hashCode() {
    return Objects.hash(branch, q);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TranslationsReviewParameters {\n");
    sb.append("    branch: ").append(toIndentedString(branch)).append("\n");
    sb.append("    q: ").append(toIndentedString(q)).append("\n");
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

