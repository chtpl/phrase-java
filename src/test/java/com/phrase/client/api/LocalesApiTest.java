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
import com.phrase.client.model.Locale;
import com.phrase.client.model.LocaleCreateParameters;
import com.phrase.client.model.LocaleDetails;
import com.phrase.client.model.LocaleUpdateParameters;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for LocalesApi
 */
@Ignore
public class LocalesApiTest {

    private final LocalesApi api = new LocalesApi();

    
    /**
     * Create a locale
     *
     * Create a new locale.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void localeCreateTest() throws ApiException {
        String projectId = null;
        LocaleCreateParameters localeCreateParameters = null;
        String xPhraseAppOTP = null;
        api.localeCreate(projectId, localeCreateParameters, xPhraseAppOTP);

        // TODO: test validations
    }
    
    /**
     * Delete a locale
     *
     * Delete an existing locale.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void localeDeleteTest() throws ApiException {
        String projectId = null;
        String id = null;
        String xPhraseAppOTP = null;
        String branch = null;
        api.localeDelete(projectId, id, xPhraseAppOTP, branch);

        // TODO: test validations
    }
    
    /**
     * Download a locale
     *
     * Download a locale in a specific file format.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void localeDownloadTest() throws ApiException {
        String projectId = null;
        String id = null;
        String xPhraseAppOTP = null;
        String branch = null;
        String fileFormat = null;
        String tags = null;
        String tag = null;
        Boolean includeEmptyTranslations = null;
        Boolean includeTranslatedKeys = null;
        Boolean keepNotranslateTags = null;
        Boolean convertEmoji = null;
        Map<String, String> formatOptions = null;
        String encoding = null;
        Boolean skipUnverifiedTranslations = null;
        Boolean includeUnverifiedTranslations = null;
        Boolean useLastReviewedVersion = null;
        String fallbackLocaleId = null;
        api.localeDownload(projectId, id, xPhraseAppOTP, branch, fileFormat, tags, tag, includeEmptyTranslations, includeTranslatedKeys, keepNotranslateTags, convertEmoji, formatOptions, encoding, skipUnverifiedTranslations, includeUnverifiedTranslations, useLastReviewedVersion, fallbackLocaleId);

        // TODO: test validations
    }
    
    /**
     * Get a single locale
     *
     * Get details on a single locale for a given project.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void localeShowTest() throws ApiException {
        String projectId = null;
        String id = null;
        String xPhraseAppOTP = null;
        String branch = null;
        LocaleDetails response = api.localeShow(projectId, id, xPhraseAppOTP, branch);

        // TODO: test validations
    }
    
    /**
     * Update a locale
     *
     * Update an existing locale.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void localeUpdateTest() throws ApiException {
        String projectId = null;
        String id = null;
        LocaleUpdateParameters localeUpdateParameters = null;
        String xPhraseAppOTP = null;
        LocaleDetails response = api.localeUpdate(projectId, id, localeUpdateParameters, xPhraseAppOTP);

        // TODO: test validations
    }
    
    /**
     * List locales
     *
     * List all locales for the given project.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void localesListTest() throws ApiException {
        String projectId = null;
        String xPhraseAppOTP = null;
        Integer page = null;
        Integer perPage = null;
        String branch = null;
        List<Locale> response = api.localesList(projectId, xPhraseAppOTP, page, perPage, branch);

        // TODO: test validations
    }
    
}