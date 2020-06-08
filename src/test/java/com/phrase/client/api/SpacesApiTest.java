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


package com.phrase.client.api;

import com.phrase.client.ApiException;
import com.phrase.client.model.Project;
import com.phrase.client.model.Space;
import com.phrase.client.model.SpaceCreateParameters;
import com.phrase.client.model.SpaceUpdateParameters;
import com.phrase.client.model.SpacesProjectsCreateParameters;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for SpacesApi
 */
@Ignore
public class SpacesApiTest {

    private final SpacesApi api = new SpacesApi();

    
    /**
     * Create a Space
     *
     * Create a new Space.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void spaceCreateTest() throws ApiException {
        String accountId = null;
        SpaceCreateParameters spaceCreateParameters = null;
        String xPhraseAppOTP = null;
        Space response = api.spaceCreate(accountId, spaceCreateParameters, xPhraseAppOTP);

        // TODO: test validations
    }
    
    /**
     * Delete Space
     *
     * Delete the specified Space.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void spaceDeleteTest() throws ApiException {
        String accountId = null;
        String id = null;
        String xPhraseAppOTP = null;
        api.spaceDelete(accountId, id, xPhraseAppOTP);

        // TODO: test validations
    }
    
    /**
     * Get Space
     *
     * Show the specified Space.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void spaceShowTest() throws ApiException {
        String accountId = null;
        String id = null;
        String xPhraseAppOTP = null;
        Space response = api.spaceShow(accountId, id, xPhraseAppOTP);

        // TODO: test validations
    }
    
    /**
     * Update Space
     *
     * Update the specified Space.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void spaceUpdateTest() throws ApiException {
        String accountId = null;
        String id = null;
        SpaceUpdateParameters spaceUpdateParameters = null;
        String xPhraseAppOTP = null;
        Space response = api.spaceUpdate(accountId, id, spaceUpdateParameters, xPhraseAppOTP);

        // TODO: test validations
    }
    
    /**
     * List Spaces
     *
     * List all Spaces for the given account.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void spacesListTest() throws ApiException {
        String accountId = null;
        String xPhraseAppOTP = null;
        Integer page = null;
        Integer perPage = null;
        List<Space> response = api.spacesList(accountId, xPhraseAppOTP, page, perPage);

        // TODO: test validations
    }
    
    /**
     * Add Project
     *
     * Adds an existing project to the space.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void spacesProjectsCreateTest() throws ApiException {
        String accountId = null;
        String spaceId = null;
        SpacesProjectsCreateParameters spacesProjectsCreateParameters = null;
        String xPhraseAppOTP = null;
        api.spacesProjectsCreate(accountId, spaceId, spacesProjectsCreateParameters, xPhraseAppOTP);

        // TODO: test validations
    }
    
    /**
     * Remove Project
     *
     * Removes a specified project from the specified space.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void spacesProjectsDeleteTest() throws ApiException {
        String accountId = null;
        String spaceId = null;
        String id = null;
        String xPhraseAppOTP = null;
        api.spacesProjectsDelete(accountId, spaceId, id, xPhraseAppOTP);

        // TODO: test validations
    }
    
    /**
     * List Projects
     *
     * List all projects for the specified Space.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void spacesProjectsListTest() throws ApiException {
        String accountId = null;
        String spaceId = null;
        String xPhraseAppOTP = null;
        Integer page = null;
        Integer perPage = null;
        List<Project> response = api.spacesProjectsList(accountId, spaceId, xPhraseAppOTP, page, perPage);

        // TODO: test validations
    }
    
}
