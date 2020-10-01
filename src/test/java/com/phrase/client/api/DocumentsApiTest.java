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
import com.phrase.client.model.Document;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for DocumentsApi
 */
@Ignore
public class DocumentsApiTest {

    private final DocumentsApi api = new DocumentsApi();

    
    /**
     * Delete document
     *
     * Delete an existing document.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void documentDeleteTest() throws ApiException {
        String projectId = null;
        String id = null;
        String xPhraseAppOTP = null;
        api.documentDelete(projectId, id, xPhraseAppOTP);

        // TODO: test validations
    }
    
    /**
     * List documents
     *
     * List all documents the current user has access to.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void documentsListTest() throws ApiException {
        String projectId = null;
        String xPhraseAppOTP = null;
        Integer page = null;
        Integer perPage = null;
        List<Document> response = api.documentsList(projectId, xPhraseAppOTP, page, perPage);

        // TODO: test validations
    }
    
}
