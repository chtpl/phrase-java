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
import com.phrase.client.model.TranslationVersion;
import com.phrase.client.model.TranslationVersionWithUser;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for VersionsHistoryApi
 */
@Ignore
public class VersionsHistoryApiTest {

    private final VersionsHistoryApi api = new VersionsHistoryApi();

    
    /**
     * Get a single version
     *
     * Get details on a single version.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void versionShowTest() throws ApiException {
        String projectId = null;
        String translationId = null;
        String id = null;
        String xPhraseAppOTP = null;
        String branch = null;
        TranslationVersionWithUser response = api.versionShow(projectId, translationId, id, xPhraseAppOTP, branch);

        // TODO: test validations
    }
    
    /**
     * List all versions
     *
     * List all versions for the given translation.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void versionsListTest() throws ApiException {
        String projectId = null;
        String translationId = null;
        String xPhraseAppOTP = null;
        Integer page = null;
        Integer perPage = null;
        String branch = null;
        List<TranslationVersion> response = api.versionsList(projectId, translationId, xPhraseAppOTP, page, perPage, branch);

        // TODO: test validations
    }
    
}
