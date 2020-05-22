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
import com.phrase.client.model.Screenshot;
import com.phrase.client.model.ScreenshotCreateParameters;
import com.phrase.client.model.ScreenshotUpdateParameters;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ScreenshotsApi
 */
@Ignore
public class ScreenshotsApiTest {

    private final ScreenshotsApi api = new ScreenshotsApi();

    
    /**
     * Create a screenshot
     *
     * Create a new screenshot.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void screenshotCreateTest() throws ApiException {
        String projectId = null;
        ScreenshotCreateParameters screenshotCreateParameters = null;
        String xPhraseAppOTP = null;
        api.screenshotCreate(projectId, screenshotCreateParameters, xPhraseAppOTP);

        // TODO: test validations
    }
    
    /**
     * Delete a screenshot
     *
     * Delete an existing screenshot.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void screenshotDeleteTest() throws ApiException {
        String projectId = null;
        String id = null;
        String xPhraseAppOTP = null;
        api.screenshotDelete(projectId, id, xPhraseAppOTP);

        // TODO: test validations
    }
    
    /**
     * Get a single screenshot
     *
     * Get details on a single screenshot for a given project.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void screenshotShowTest() throws ApiException {
        String projectId = null;
        String id = null;
        String xPhraseAppOTP = null;
        Screenshot response = api.screenshotShow(projectId, id, xPhraseAppOTP);

        // TODO: test validations
    }
    
    /**
     * Update a screenshot
     *
     * Update an existing screenshot.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void screenshotUpdateTest() throws ApiException {
        String projectId = null;
        String id = null;
        ScreenshotUpdateParameters screenshotUpdateParameters = null;
        String xPhraseAppOTP = null;
        Screenshot response = api.screenshotUpdate(projectId, id, screenshotUpdateParameters, xPhraseAppOTP);

        // TODO: test validations
    }
    
    /**
     * List screenshots
     *
     * List all screenshots for the given project.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void screenshotsListTest() throws ApiException {
        String projectId = null;
        String xPhraseAppOTP = null;
        Integer page = null;
        Integer perPage = null;
        List<Screenshot> response = api.screenshotsList(projectId, xPhraseAppOTP, page, perPage);

        // TODO: test validations
    }
    
}