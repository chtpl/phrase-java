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
import com.phrase.client.model.Branch;
import com.phrase.client.model.BranchCreateParameters;
import com.phrase.client.model.BranchMergeParameters;
import com.phrase.client.model.BranchUpdateParameters;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for BranchesApi
 */
@Ignore
public class BranchesApiTest {

    private final BranchesApi api = new BranchesApi();

    
    /**
     * Compare branches
     *
     * Compare branch with main branch.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void branchCompareTest() throws ApiException {
        String projectId = null;
        String name = null;
        String xPhraseAppOTP = null;
        api.branchCompare(projectId, name, xPhraseAppOTP);

        // TODO: test validations
    }
    
    /**
     * Create a branch
     *
     * Create a new branch.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void branchCreateTest() throws ApiException {
        String projectId = null;
        BranchCreateParameters branchCreateParameters = null;
        String xPhraseAppOTP = null;
        api.branchCreate(projectId, branchCreateParameters, xPhraseAppOTP);

        // TODO: test validations
    }
    
    /**
     * Delete a branch
     *
     * Delete an existing branch.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void branchDeleteTest() throws ApiException {
        String projectId = null;
        String name = null;
        String xPhraseAppOTP = null;
        api.branchDelete(projectId, name, xPhraseAppOTP);

        // TODO: test validations
    }
    
    /**
     * Merge a branch
     *
     * Merge an existing branch.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void branchMergeTest() throws ApiException {
        String projectId = null;
        String name = null;
        BranchMergeParameters branchMergeParameters = null;
        String xPhraseAppOTP = null;
        api.branchMerge(projectId, name, branchMergeParameters, xPhraseAppOTP);

        // TODO: test validations
    }
    
    /**
     * Get a single branch
     *
     * Get details on a single branch for a given project.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void branchShowTest() throws ApiException {
        String projectId = null;
        String name = null;
        String xPhraseAppOTP = null;
        Branch response = api.branchShow(projectId, name, xPhraseAppOTP);

        // TODO: test validations
    }
    
    /**
     * Update a branch
     *
     * Update an existing branch.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void branchUpdateTest() throws ApiException {
        String projectId = null;
        String name = null;
        BranchUpdateParameters branchUpdateParameters = null;
        String xPhraseAppOTP = null;
        Branch response = api.branchUpdate(projectId, name, branchUpdateParameters, xPhraseAppOTP);

        // TODO: test validations
    }
    
    /**
     * List branches
     *
     * List all branches the of the current project.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void branchesListTest() throws ApiException {
        String projectId = null;
        String xPhraseAppOTP = null;
        Integer page = null;
        Integer perPage = null;
        List<Branch> response = api.branchesList(projectId, xPhraseAppOTP, page, perPage);

        // TODO: test validations
    }
    
}