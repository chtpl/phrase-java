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
import com.phrase.client.model.GlossaryTerm;
import com.phrase.client.model.GlossaryTermCreateParameters;
import com.phrase.client.model.GlossaryTermUpdateParameters;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for GlossaryTermsApi
 */
@Ignore
public class GlossaryTermsApiTest {

    private final GlossaryTermsApi api = new GlossaryTermsApi();

    
    /**
     * Create a glossary term
     *
     * Create a new glossary term.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void glossaryTermCreateTest() throws ApiException {
        String accountId = null;
        String glossaryId = null;
        GlossaryTermCreateParameters glossaryTermCreateParameters = null;
        String xPhraseAppOTP = null;
        api.glossaryTermCreate(accountId, glossaryId, glossaryTermCreateParameters, xPhraseAppOTP);

        // TODO: test validations
    }
    
    /**
     * Delete a glossary term
     *
     * Delete an existing glossary term.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void glossaryTermDeleteTest() throws ApiException {
        String accountId = null;
        String glossaryId = null;
        String id = null;
        String xPhraseAppOTP = null;
        api.glossaryTermDelete(accountId, glossaryId, id, xPhraseAppOTP);

        // TODO: test validations
    }
    
    /**
     * Get a single glossary term
     *
     * Get details on a single glossary term.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void glossaryTermShowTest() throws ApiException {
        String accountId = null;
        String glossaryId = null;
        String id = null;
        String xPhraseAppOTP = null;
        GlossaryTerm response = api.glossaryTermShow(accountId, glossaryId, id, xPhraseAppOTP);

        // TODO: test validations
    }
    
    /**
     * Update a glossary term
     *
     * Update an existing glossary term.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void glossaryTermUpdateTest() throws ApiException {
        String accountId = null;
        String glossaryId = null;
        String id = null;
        GlossaryTermUpdateParameters glossaryTermUpdateParameters = null;
        String xPhraseAppOTP = null;
        GlossaryTerm response = api.glossaryTermUpdate(accountId, glossaryId, id, glossaryTermUpdateParameters, xPhraseAppOTP);

        // TODO: test validations
    }
    
    /**
     * List glossary terms
     *
     * List all glossary terms the current user has access to.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void glossaryTermsListTest() throws ApiException {
        String accountId = null;
        String glossaryId = null;
        String xPhraseAppOTP = null;
        Integer page = null;
        Integer perPage = null;
        List<GlossaryTerm> response = api.glossaryTermsList(accountId, glossaryId, xPhraseAppOTP, page, perPage);

        // TODO: test validations
    }
    
}
