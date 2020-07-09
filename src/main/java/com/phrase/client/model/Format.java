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
 * Format
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-07-09T13:51:48.019Z[Etc/UTC]")
public class Format {
  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_API_NAME = "api_name";
  @SerializedName(SERIALIZED_NAME_API_NAME)
  private String apiName;

  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_EXTENSION = "extension";
  @SerializedName(SERIALIZED_NAME_EXTENSION)
  private String extension;

  public static final String SERIALIZED_NAME_DEFAULT_ENCODING = "default_encoding";
  @SerializedName(SERIALIZED_NAME_DEFAULT_ENCODING)
  private String defaultEncoding;

  public static final String SERIALIZED_NAME_IMPORTABLE = "importable";
  @SerializedName(SERIALIZED_NAME_IMPORTABLE)
  private Boolean importable;

  public static final String SERIALIZED_NAME_EXPORTABLE = "exportable";
  @SerializedName(SERIALIZED_NAME_EXPORTABLE)
  private Boolean exportable;

  public static final String SERIALIZED_NAME_DEFAULT_FILE = "default_file";
  @SerializedName(SERIALIZED_NAME_DEFAULT_FILE)
  private String defaultFile;

  public static final String SERIALIZED_NAME_RENDERS_DEFAULT_LOCALE = "renders_default_locale";
  @SerializedName(SERIALIZED_NAME_RENDERS_DEFAULT_LOCALE)
  private Boolean rendersDefaultLocale;

  public static final String SERIALIZED_NAME_INCLUDES_LOCALE_INFORMATION = "includes_locale_information";
  @SerializedName(SERIALIZED_NAME_INCLUDES_LOCALE_INFORMATION)
  private Boolean includesLocaleInformation;


  public Format name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public Format apiName(String apiName) {
    
    this.apiName = apiName;
    return this;
  }

   /**
   * Get apiName
   * @return apiName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getApiName() {
    return apiName;
  }


  public void setApiName(String apiName) {
    this.apiName = apiName;
  }


  public Format description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    this.description = description;
  }


  public Format extension(String extension) {
    
    this.extension = extension;
    return this;
  }

   /**
   * Get extension
   * @return extension
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getExtension() {
    return extension;
  }


  public void setExtension(String extension) {
    this.extension = extension;
  }


  public Format defaultEncoding(String defaultEncoding) {
    
    this.defaultEncoding = defaultEncoding;
    return this;
  }

   /**
   * Get defaultEncoding
   * @return defaultEncoding
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getDefaultEncoding() {
    return defaultEncoding;
  }


  public void setDefaultEncoding(String defaultEncoding) {
    this.defaultEncoding = defaultEncoding;
  }


  public Format importable(Boolean importable) {
    
    this.importable = importable;
    return this;
  }

   /**
   * Get importable
   * @return importable
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getImportable() {
    return importable;
  }


  public void setImportable(Boolean importable) {
    this.importable = importable;
  }


  public Format exportable(Boolean exportable) {
    
    this.exportable = exportable;
    return this;
  }

   /**
   * Get exportable
   * @return exportable
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getExportable() {
    return exportable;
  }


  public void setExportable(Boolean exportable) {
    this.exportable = exportable;
  }


  public Format defaultFile(String defaultFile) {
    
    this.defaultFile = defaultFile;
    return this;
  }

   /**
   * Get defaultFile
   * @return defaultFile
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getDefaultFile() {
    return defaultFile;
  }


  public void setDefaultFile(String defaultFile) {
    this.defaultFile = defaultFile;
  }


  public Format rendersDefaultLocale(Boolean rendersDefaultLocale) {
    
    this.rendersDefaultLocale = rendersDefaultLocale;
    return this;
  }

   /**
   * Get rendersDefaultLocale
   * @return rendersDefaultLocale
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getRendersDefaultLocale() {
    return rendersDefaultLocale;
  }


  public void setRendersDefaultLocale(Boolean rendersDefaultLocale) {
    this.rendersDefaultLocale = rendersDefaultLocale;
  }


  public Format includesLocaleInformation(Boolean includesLocaleInformation) {
    
    this.includesLocaleInformation = includesLocaleInformation;
    return this;
  }

   /**
   * Get includesLocaleInformation
   * @return includesLocaleInformation
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getIncludesLocaleInformation() {
    return includesLocaleInformation;
  }


  public void setIncludesLocaleInformation(Boolean includesLocaleInformation) {
    this.includesLocaleInformation = includesLocaleInformation;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Format format = (Format) o;
    return Objects.equals(this.name, format.name) &&
        Objects.equals(this.apiName, format.apiName) &&
        Objects.equals(this.description, format.description) &&
        Objects.equals(this.extension, format.extension) &&
        Objects.equals(this.defaultEncoding, format.defaultEncoding) &&
        Objects.equals(this.importable, format.importable) &&
        Objects.equals(this.exportable, format.exportable) &&
        Objects.equals(this.defaultFile, format.defaultFile) &&
        Objects.equals(this.rendersDefaultLocale, format.rendersDefaultLocale) &&
        Objects.equals(this.includesLocaleInformation, format.includesLocaleInformation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, apiName, description, extension, defaultEncoding, importable, exportable, defaultFile, rendersDefaultLocale, includesLocaleInformation);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Format {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    apiName: ").append(toIndentedString(apiName)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    extension: ").append(toIndentedString(extension)).append("\n");
    sb.append("    defaultEncoding: ").append(toIndentedString(defaultEncoding)).append("\n");
    sb.append("    importable: ").append(toIndentedString(importable)).append("\n");
    sb.append("    exportable: ").append(toIndentedString(exportable)).append("\n");
    sb.append("    defaultFile: ").append(toIndentedString(defaultFile)).append("\n");
    sb.append("    rendersDefaultLocale: ").append(toIndentedString(rendersDefaultLocale)).append("\n");
    sb.append("    includesLocaleInformation: ").append(toIndentedString(includesLocaleInformation)).append("\n");
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

