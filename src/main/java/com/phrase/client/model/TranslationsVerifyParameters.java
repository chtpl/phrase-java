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
 * TranslationsVerifyParameters
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-06-09T07:13:53.645Z[Etc/UTC]")
public class TranslationsVerifyParameters {
  public static final String SERIALIZED_NAME_BRANCH = "branch";
  @SerializedName(SERIALIZED_NAME_BRANCH)
  private String branch;

  public static final String SERIALIZED_NAME_Q = "q";
  @SerializedName(SERIALIZED_NAME_Q)
  private String q;

  public static final String SERIALIZED_NAME_SORT = "sort";
  @SerializedName(SERIALIZED_NAME_SORT)
  private String sort;

  public static final String SERIALIZED_NAME_ORDER = "order";
  @SerializedName(SERIALIZED_NAME_ORDER)
  private String order;


  public TranslationsVerifyParameters branch(String branch) {
    
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


  public TranslationsVerifyParameters q(String q) {
    
    this.q = q;
    return this;
  }

   /**
   * q_description_placeholder
   * @return q
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "PhraseApp*%20unverified:true%20tags:feature,center", value = "q_description_placeholder")

  public String getQ() {
    return q;
  }


  public void setQ(String q) {
    this.q = q;
  }


  public TranslationsVerifyParameters sort(String sort) {
    
    this.sort = sort;
    return this;
  }

   /**
   * Sort criteria. Can be one of: key_name, created_at, updated_at.
   * @return sort
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "updated_at", value = "Sort criteria. Can be one of: key_name, created_at, updated_at.")

  public String getSort() {
    return sort;
  }


  public void setSort(String sort) {
    this.sort = sort;
  }


  public TranslationsVerifyParameters order(String order) {
    
    this.order = order;
    return this;
  }

   /**
   * Order direction. Can be one of: asc, desc.
   * @return order
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "desc", value = "Order direction. Can be one of: asc, desc.")

  public String getOrder() {
    return order;
  }


  public void setOrder(String order) {
    this.order = order;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TranslationsVerifyParameters translationsVerifyParameters = (TranslationsVerifyParameters) o;
    return Objects.equals(this.branch, translationsVerifyParameters.branch) &&
        Objects.equals(this.q, translationsVerifyParameters.q) &&
        Objects.equals(this.sort, translationsVerifyParameters.sort) &&
        Objects.equals(this.order, translationsVerifyParameters.order);
  }

  @Override
  public int hashCode() {
    return Objects.hash(branch, q, sort, order);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TranslationsVerifyParameters {\n");
    sb.append("    branch: ").append(toIndentedString(branch)).append("\n");
    sb.append("    q: ").append(toIndentedString(q)).append("\n");
    sb.append("    sort: ").append(toIndentedString(sort)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
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

