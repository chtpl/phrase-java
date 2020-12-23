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
import com.phrase.client.model.MemberProjectDetailProjectRoles;
import com.phrase.client.model.MemberSpaces;
import com.phrase.client.model.ProjectLocales;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * MemberProjectDetail
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-12-23T13:39:22.535Z[Etc/UTC]")
public class MemberProjectDetail {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_EMAIL = "email";
  @SerializedName(SERIALIZED_NAME_EMAIL)
  private String email;

  public static final String SERIALIZED_NAME_USERNAME = "username";
  @SerializedName(SERIALIZED_NAME_USERNAME)
  private String username;

  public static final String SERIALIZED_NAME_ROLE = "role";
  @SerializedName(SERIALIZED_NAME_ROLE)
  private String role;

  public static final String SERIALIZED_NAME_PROJECTS = "projects";
  @SerializedName(SERIALIZED_NAME_PROJECTS)
  private List<ProjectLocales> projects = null;

  public static final String SERIALIZED_NAME_PERMISSIONS = "permissions";
  @SerializedName(SERIALIZED_NAME_PERMISSIONS)
  private Object permissions;

  public static final String SERIALIZED_NAME_LOCALE_IDS = "locale_ids";
  @SerializedName(SERIALIZED_NAME_LOCALE_IDS)
  private List<String> localeIds = null;

  public static final String SERIALIZED_NAME_DEFAULT_LOCALE_CODES = "default_locale_codes";
  @SerializedName(SERIALIZED_NAME_DEFAULT_LOCALE_CODES)
  private List<String> defaultLocaleCodes = null;

  public static final String SERIALIZED_NAME_SPACES = "spaces";
  @SerializedName(SERIALIZED_NAME_SPACES)
  private List<MemberSpaces> spaces = null;

  public static final String SERIALIZED_NAME_PROJECT_ROLES = "project_roles";
  @SerializedName(SERIALIZED_NAME_PROJECT_ROLES)
  private List<MemberProjectDetailProjectRoles> projectRoles = null;


  public MemberProjectDetail id(String id) {
    
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


  public MemberProjectDetail email(String email) {
    
    this.email = email;
    return this;
  }

   /**
   * Get email
   * @return email
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getEmail() {
    return email;
  }


  public void setEmail(String email) {
    this.email = email;
  }


  public MemberProjectDetail username(String username) {
    
    this.username = username;
    return this;
  }

   /**
   * Get username
   * @return username
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getUsername() {
    return username;
  }


  public void setUsername(String username) {
    this.username = username;
  }


  public MemberProjectDetail role(String role) {
    
    this.role = role;
    return this;
  }

   /**
   * Get role
   * @return role
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getRole() {
    return role;
  }


  public void setRole(String role) {
    this.role = role;
  }


  public MemberProjectDetail projects(List<ProjectLocales> projects) {
    
    this.projects = projects;
    return this;
  }

  public MemberProjectDetail addProjectsItem(ProjectLocales projectsItem) {
    if (this.projects == null) {
      this.projects = new ArrayList<>();
    }
    this.projects.add(projectsItem);
    return this;
  }

   /**
   * Get projects
   * @return projects
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<ProjectLocales> getProjects() {
    return projects;
  }


  public void setProjects(List<ProjectLocales> projects) {
    this.projects = projects;
  }


  public MemberProjectDetail permissions(Object permissions) {
    
    this.permissions = permissions;
    return this;
  }

   /**
   * Get permissions
   * @return permissions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Object getPermissions() {
    return permissions;
  }


  public void setPermissions(Object permissions) {
    this.permissions = permissions;
  }


  public MemberProjectDetail localeIds(List<String> localeIds) {
    
    this.localeIds = localeIds;
    return this;
  }

  public MemberProjectDetail addLocaleIdsItem(String localeIdsItem) {
    if (this.localeIds == null) {
      this.localeIds = new ArrayList<>();
    }
    this.localeIds.add(localeIdsItem);
    return this;
  }

   /**
   * Get localeIds
   * @return localeIds
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<String> getLocaleIds() {
    return localeIds;
  }


  public void setLocaleIds(List<String> localeIds) {
    this.localeIds = localeIds;
  }


  public MemberProjectDetail defaultLocaleCodes(List<String> defaultLocaleCodes) {
    
    this.defaultLocaleCodes = defaultLocaleCodes;
    return this;
  }

  public MemberProjectDetail addDefaultLocaleCodesItem(String defaultLocaleCodesItem) {
    if (this.defaultLocaleCodes == null) {
      this.defaultLocaleCodes = new ArrayList<>();
    }
    this.defaultLocaleCodes.add(defaultLocaleCodesItem);
    return this;
  }

   /**
   * Get defaultLocaleCodes
   * @return defaultLocaleCodes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<String> getDefaultLocaleCodes() {
    return defaultLocaleCodes;
  }


  public void setDefaultLocaleCodes(List<String> defaultLocaleCodes) {
    this.defaultLocaleCodes = defaultLocaleCodes;
  }


  public MemberProjectDetail spaces(List<MemberSpaces> spaces) {
    
    this.spaces = spaces;
    return this;
  }

  public MemberProjectDetail addSpacesItem(MemberSpaces spacesItem) {
    if (this.spaces == null) {
      this.spaces = new ArrayList<>();
    }
    this.spaces.add(spacesItem);
    return this;
  }

   /**
   * Get spaces
   * @return spaces
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<MemberSpaces> getSpaces() {
    return spaces;
  }


  public void setSpaces(List<MemberSpaces> spaces) {
    this.spaces = spaces;
  }


  public MemberProjectDetail projectRoles(List<MemberProjectDetailProjectRoles> projectRoles) {
    
    this.projectRoles = projectRoles;
    return this;
  }

  public MemberProjectDetail addProjectRolesItem(MemberProjectDetailProjectRoles projectRolesItem) {
    if (this.projectRoles == null) {
      this.projectRoles = new ArrayList<>();
    }
    this.projectRoles.add(projectRolesItem);
    return this;
  }

   /**
   * Get projectRoles
   * @return projectRoles
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<MemberProjectDetailProjectRoles> getProjectRoles() {
    return projectRoles;
  }


  public void setProjectRoles(List<MemberProjectDetailProjectRoles> projectRoles) {
    this.projectRoles = projectRoles;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MemberProjectDetail memberProjectDetail = (MemberProjectDetail) o;
    return Objects.equals(this.id, memberProjectDetail.id) &&
        Objects.equals(this.email, memberProjectDetail.email) &&
        Objects.equals(this.username, memberProjectDetail.username) &&
        Objects.equals(this.role, memberProjectDetail.role) &&
        Objects.equals(this.projects, memberProjectDetail.projects) &&
        Objects.equals(this.permissions, memberProjectDetail.permissions) &&
        Objects.equals(this.localeIds, memberProjectDetail.localeIds) &&
        Objects.equals(this.defaultLocaleCodes, memberProjectDetail.defaultLocaleCodes) &&
        Objects.equals(this.spaces, memberProjectDetail.spaces) &&
        Objects.equals(this.projectRoles, memberProjectDetail.projectRoles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, email, username, role, projects, permissions, localeIds, defaultLocaleCodes, spaces, projectRoles);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MemberProjectDetail {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    projects: ").append(toIndentedString(projects)).append("\n");
    sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
    sb.append("    localeIds: ").append(toIndentedString(localeIds)).append("\n");
    sb.append("    defaultLocaleCodes: ").append(toIndentedString(defaultLocaleCodes)).append("\n");
    sb.append("    spaces: ").append(toIndentedString(spaces)).append("\n");
    sb.append("    projectRoles: ").append(toIndentedString(projectRoles)).append("\n");
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

