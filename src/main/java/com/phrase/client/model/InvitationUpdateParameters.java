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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * InvitationUpdateParameters
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-05-22T07:41:42.962Z[Etc/UTC]")
public class InvitationUpdateParameters {
  public static final String SERIALIZED_NAME_ROLE = "role";
  @SerializedName(SERIALIZED_NAME_ROLE)
  private String role;

  public static final String SERIALIZED_NAME_PROJECT_IDS = "project_ids";
  @SerializedName(SERIALIZED_NAME_PROJECT_IDS)
  private String projectIds;

  public static final String SERIALIZED_NAME_LOCALE_IDS = "locale_ids";
  @SerializedName(SERIALIZED_NAME_LOCALE_IDS)
  private String localeIds;

  public static final String SERIALIZED_NAME_PERMISSIONS = "permissions";
  @SerializedName(SERIALIZED_NAME_PERMISSIONS)
  private Map<String, String> permissions = null;


  public InvitationUpdateParameters role(String role) {
    
    this.role = role;
    return this;
  }

   /**
   * Invitiation role, can be any of Manager, Developer, Translator
   * @return role
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Invitiation role", value = "Invitiation role, can be any of Manager, Developer, Translator")

  public String getRole() {
    return role;
  }


  public void setRole(String role) {
    this.role = role;
  }


  public InvitationUpdateParameters projectIds(String projectIds) {
    
    this.projectIds = projectIds;
    return this;
  }

   /**
   * List of project ids the invited user has access to
   * @return projectIds
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "abcd1234abcd1234abcd1234,abcd1234abcd1234abcd1235", value = "List of project ids the invited user has access to")

  public String getProjectIds() {
    return projectIds;
  }


  public void setProjectIds(String projectIds) {
    this.projectIds = projectIds;
  }


  public InvitationUpdateParameters localeIds(String localeIds) {
    
    this.localeIds = localeIds;
    return this;
  }

   /**
   * List of locale ids the invited user has access to
   * @return localeIds
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "abcd1234abcd1234abcd1234,abcd1234abcd1234abcd1235", value = "List of locale ids the invited user has access to")

  public String getLocaleIds() {
    return localeIds;
  }


  public void setLocaleIds(String localeIds) {
    this.localeIds = localeIds;
  }


  public InvitationUpdateParameters permissions(Map<String, String> permissions) {
    
    this.permissions = permissions;
    return this;
  }

  public InvitationUpdateParameters putPermissionsItem(String key, String permissionsItem) {
    if (this.permissions == null) {
      this.permissions = new HashMap<String, String>();
    }
    this.permissions.put(key, permissionsItem);
    return this;
  }

   /**
   * Additional permissions depending on invitation role.
   * @return permissions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "{\"create_upload\":true}", value = "Additional permissions depending on invitation role.")

  public Map<String, String> getPermissions() {
    return permissions;
  }


  public void setPermissions(Map<String, String> permissions) {
    this.permissions = permissions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InvitationUpdateParameters invitationUpdateParameters = (InvitationUpdateParameters) o;
    return Objects.equals(this.role, invitationUpdateParameters.role) &&
        Objects.equals(this.projectIds, invitationUpdateParameters.projectIds) &&
        Objects.equals(this.localeIds, invitationUpdateParameters.localeIds) &&
        Objects.equals(this.permissions, invitationUpdateParameters.permissions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(role, projectIds, localeIds, permissions);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InvitationUpdateParameters {\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    projectIds: ").append(toIndentedString(projectIds)).append("\n");
    sb.append("    localeIds: ").append(toIndentedString(localeIds)).append("\n");
    sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
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

