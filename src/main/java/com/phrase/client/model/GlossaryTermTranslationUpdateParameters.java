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
 * GlossaryTermTranslationUpdateParameters
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-07-16T13:58:45.757Z[Etc/UTC]")
public class GlossaryTermTranslationUpdateParameters {
  public static final String SERIALIZED_NAME_LOCALE_CODE = "locale_code";
  @SerializedName(SERIALIZED_NAME_LOCALE_CODE)
  private String localeCode;

  public static final String SERIALIZED_NAME_CONTENT = "content";
  @SerializedName(SERIALIZED_NAME_CONTENT)
  private String content;


  public GlossaryTermTranslationUpdateParameters localeCode(String localeCode) {
    
    this.localeCode = localeCode;
    return this;
  }

   /**
   * Identifies the language for this translation
   * @return localeCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "en-US", value = "Identifies the language for this translation")

  public String getLocaleCode() {
    return localeCode;
  }


  public void setLocaleCode(String localeCode) {
    this.localeCode = localeCode;
  }


  public GlossaryTermTranslationUpdateParameters content(String content) {
    
    this.content = content;
    return this;
  }

   /**
   * The content of the translation
   * @return content
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "My translated term", value = "The content of the translation")

  public String getContent() {
    return content;
  }


  public void setContent(String content) {
    this.content = content;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GlossaryTermTranslationUpdateParameters glossaryTermTranslationUpdateParameters = (GlossaryTermTranslationUpdateParameters) o;
    return Objects.equals(this.localeCode, glossaryTermTranslationUpdateParameters.localeCode) &&
        Objects.equals(this.content, glossaryTermTranslationUpdateParameters.content);
  }

  @Override
  public int hashCode() {
    return Objects.hash(localeCode, content);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GlossaryTermTranslationUpdateParameters {\n");
    sb.append("    localeCode: ").append(toIndentedString(localeCode)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
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

