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
import com.phrase.client.model.Tag;
import com.phrase.client.model.TagCreateParameters;
import com.phrase.client.model.TagWithStats;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for TagsApi
 */
@Ignore
public class TagsApiTest {

    private final TagsApi api = new TagsApi();

    
    /**
     * Create a tag
     *
     * Create a new tag.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void tagCreateTest() throws ApiException {
        String projectId = null;
        TagCreateParameters tagCreateParameters = null;
        String xPhraseAppOTP = null;
        api.tagCreate(projectId, tagCreateParameters, xPhraseAppOTP);

        // TODO: test validations
    }
    
    /**
     * Delete a tag
     *
     * Delete an existing tag.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void tagDeleteTest() throws ApiException {
        String projectId = null;
        String name = null;
        String xPhraseAppOTP = null;
        String branch = null;
        api.tagDelete(projectId, name, xPhraseAppOTP, branch);

        // TODO: test validations
    }
    
    /**
     * Get a single tag
     *
     * Get details and progress information on a single tag for a given project.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void tagShowTest() throws ApiException {
        String projectId = null;
        String name = null;
        String xPhraseAppOTP = null;
        String branch = null;
        TagWithStats response = api.tagShow(projectId, name, xPhraseAppOTP, branch);

        // TODO: test validations
    }
    
    /**
     * List tags
     *
     * List all tags for the given project.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void tagsListTest() throws ApiException {
        String projectId = null;
        String xPhraseAppOTP = null;
        Integer page = null;
        Integer perPage = null;
        String branch = null;
        List<Tag> response = api.tagsList(projectId, xPhraseAppOTP, page, perPage, branch);

        // TODO: test validations
    }
    
}
