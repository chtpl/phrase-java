/*
 * Phrase API Reference
 * Phrase is a translation management platform for software projects. You can collaborate on language file translation with your team or order translations through our platform. The API allows you to import locale files, download locale files, tag keys or interact in other ways with the localization data stored in Phrase for your account.  ## API Endpoint  ``` https://api.phrase.com/v2/ ```  The API is only accessible via HTTPS, the base URL is <code>https://api.phrase.com/</code>, and the current version is <code>v2</code> which results in the base URL for all requests: <code>https://api.phrase.com/v2/</code>.  ## Usage  [curl](http://curl.haxx.se/) is used primarily to send requests to Phrase in the examples. On most you'll find a second variant using the [Phrase API v2 client](https://phrase.com/cli/) that might be more convenient to handle. For further information check its [documentation](https://help.phrase.com/help/phrase-in-your-terminal).  ## Use of HTTP Verbs  Phrase API v2 tries to use the appropriate HTTP verb for accessing each endpoint according to REST specification where possible:  <div class=\"table-responsive\">   <table class=\"basic-table\">     <thead>       <tr class=\"basic-table__row basic-table__row--header\">         <th class=\"basic-table__cell basic-table__cell--header\">Verb</th>         <th class=\"basic-table__cell basic-table__cell--header\">Description</th>       </tr>     </thead>     <tbody>       <tr>         <td class=\"basic-table__cell\">GET</td>         <td class=\"basic-table__cell\">Retrieve one or multiple resources</td>       </tr>       <tr>         <td class=\"basic-table__cell\">POST</td>         <td class=\"basic-table__cell\">Create a resource</td>       </tr>       <tr>         <td class=\"basic-table__cell\">PUT</td>         <td class=\"basic-table__cell\">Update a resource</td>       </tr>       <tr>         <td class=\"basic-table__cell\">PATCH</td>         <td class=\"basic-table__cell\">Update a resource (partially)</td>       </tr>       <tr>         <td class=\"basic-table__cell\">DELETE</td>         <td class=\"basic-table__cell\">Delete a resource</td>       </tr>     </tbody>   </table> </div>   ## Identification via User-Agent  You must include the User-Agent header with the name of your application or project. It might be a good idea to include some sort of contact information  as well, so that we can get in touch if necessary (e.g. to warn you about Rate-Limiting or badly formed requests). Examples of excellent User-Agent headers:  ``` User-Agent: Frederiks Mobile App (frederik@phrase.com) User-Agent: ACME Inc Python Client (http://example.com/contact) ```  If you don't send this header, you will receive a response with 400 Bad Request.   ## Lists  When you request a list of resources, the API will typically only return an array of resources including their most important attributes. For a detailed representation of the resource you should request its detailed representation.  Lists are usually [paginated](#pagination).   ## Parameters  Many endpoints support additional parameters, e.g. for pagination. When passing them in a GET request you can send them as HTTP query string parameters:  ``` $ curl -u EMAIL_OR_ACCESS_TOKEN \"https://api.phrase.com/v2/projects?page=2\" ```  When performing a POST, PUT, PATCH or DELETE request, we recommend sending parameters that are not already included in the URL, as JSON body:  ``` $ curl -H 'Content-Type: application/json' -d '{\"name\":\"My new project\"}' -u EMAIL_OR_ACCESS_TOKEN https://api.phrase.com/v2/projects ```  Encoding parameters as JSON means better support for types (boolean, integer) and usually better readability. Don't forget to set the correct Content-Type for your request.  *The Content-Type header is omitted in some of the following examples for better readbility.*   ## Errors   ### Request Errors  If a request contains invalid JSON or is missing a required parameter (besides resource attributes), the status `400 Bad Request` is returned:  ``` {   \"message\": \"JSON could not be parsed\" } ```   ### Validation Errors  When the validation for a resource fails, the status `422 Unprocessable Entity` is returned, along with information on the affected fields:  ``` {   \"message\": \"Validation Failed\",   \"errors\": [     {       \"resource\": \"Project\",       \"field\": \"name\",       \"message\": \"can't be blank\"     }   ] } ```   ## Date Format  Times and dates are returned and expected in [ISO 8601](http://en.wikipedia.org/wiki/ISO_8601) date format:  ``` YYYY-MM-DDTHH:MM:SSZ ```  Instead of 'Z' for UTC time zone you can specify your time zone's locale offset using the following notation:  ``` YYYY-MM-DDTHH:MM:SS¬±hh:mm ```  Example for CET (1 hour behind UTC):  ``` 2015-03-31T13:00+01:00 ```  Please note that in HTTP headers, we will use the appropriate recommended date formats instead of ISO 8601.   ## Authentication  <div class=\"alert alert-info\">For more detailed information on authentication, check out the <a href=\"#authentication\">API v2 Authentication Guide</a>.</div>  There are two different ways to authenticate when performing API requests:  * E-Mail and password * Oauth Access Token   ### E-Mail and password  To get started easily, you can use HTTP Basic authentication with your email and password:  ``` $ curl -u username:password \"https://api.phrase.com/v2/projects\" ```   ### OAuth via Access Tokens  You can create and manage access tokens in your [profile settings](https://app.phrase.com/settings/oauth_access_tokens) in Translation Center or via the [Authorizations API](#authorizations).  Simply pass the access token as the username of your request:  ``` $ curl -u ACCESS_TOKEN: \"https://api.phrase.com/v2/projects\" ```  or send the access token via the `Authorization` header field:  ``` $ curl -H \"Authorization: token ACCESS_TOKEN\" https://api.phrase.com/v2/projects ```  For more detailed information on authentication, check out the <a href=\"#authentication\">API v2 Authentication Guide</a>.  #### Send via parameter  As JSONP (and other) requests cannot send HTTP Basic Auth credentials, a special query parameter `access_token` can be used:  ``` curl \"https://api.phrase.com/v2/projects?access_token=ACCESS_TOKEN\" ```  You should only use this transport method if sending the authentication via header or Basic authentication is not possible.  ### Two-Factor-Authentication  Users with Two-Factor-Authentication enabled have to send a valid token along their request with certain authentication methods (such as Basic authentication). The necessity of a Two-Factor-Authentication token is indicated by the `X-PhraseApp-OTP: required; :MFA-type` header in the response. The `:MFA-type`field indicates the source of the token, e.g. `app` (refers to your Authenticator application):  ``` X-PhraseApp-OTP: required; app ```  To provide a Two-Factor-Authentication token you can simply send it in the header of the request:  ``` curl -H \"X-PhraseApp-OTP: MFA-TOKEN\" -u EMAIL https://api.phrase.com/v2/projects ```  Since Two-Factor-Authentication tokens usually expire quickly, we recommend using an alternative authentication method such as OAuth access tokens.  ### Multiple Accounts  Some endpoints require the account ID to be specified if the authenticated user is a member of multiple accounts. You can find the eight-digit account ID inside <a href=\"https://app.phrase.com/\" target=\"_blank\">Translation Center</a> by switching to the desired account and then visiting the account details page. If required, you can specify the account just like a normal parameter within the request.  ## Pagination  Endpoints that return a list or resources will usually return paginated results and include 25 items by default. To access further pages, use the `page` parameter:  ``` $ curl -u EMAIL_OR_ACCESS_TOKEN \"https://api.phrase.com/v2/projects?page=2\" ```  Some endpoints also allow a custom page size by using the `per_page` parameter:  ``` $ curl -u EMAIL_OR_ACCESS_TOKEN \"https://api.phrase.com/v2/projects?page=2&per_page=50\" ```  Unless specified otherwise in the description of the respective endpoint, `per_page` allows you to specify a page size up to 100 items.   ## Link-Headers  We provide you with pagination URLs in the [Link Header field](http://tools.ietf.org/html/rfc5988). Make use of this information to avoid building pagination URLs yourself.  ``` Link: <https://api.phrase.com/v2/projects?page=1>; rel=\"first\", <https://api.phrase.com/v2/projects?page=3>; rel=\"prev\", <https://api.phrase.com/v2/projects?page=5>; rel=\"next\", <https://api.phrase.com/v2/projects?page=9>; rel=\"last\" ```  Possible `rel` values are:  <div class=\"table-responsive\">   <table class=\"basic-table\">     <thead>       <tr class=\"basic-table__row basic-table__row--header\">         <th class=\"basic-table__cell basic-table__cell--header\">Value</th>         <th class=\"basic-table__cell basic-table__cell--header\">Description</th>       </tr>     </thead>     <tbody>       <tr>         <td class=\"basic-table__cell\">next</td>         <td class=\"basic-table__cell\">URL of the next page of results</td>       </tr>       <tr>         <td class=\"basic-table__cell\">last</td>         <td class=\"basic-table__cell\">URL of the last page of results</td>       </tr>       <tr>         <td class=\"basic-table__cell\">first</td>         <td class=\"basic-table__cell\">URL of the first page of results</td>       </tr>       <tr>         <td class=\"basic-table__cell\">prev</td>         <td class=\"basic-table__cell\">URL of the previous page of results</td>       </tr>     </tbody>   </table> </div>  ## Rate Limiting  All API endpoints are subject to rate limiting to ensure good performance for all customers. The rate limit is calculated per user:  * 1000 requests per 5 minutes * 4 concurrent (parallel) requests  For your convenience we send information on the current rate limit within the response headers:  <div class=\"table-responsive\">   <table class=\"basic-table\">     <thead>       <tr class=\"basic-table__row basic-table__row--header\">         <th class=\"basic-table__cell basic-table__cell--header\">Header</th>         <th class=\"basic-table__cell basic-table__cell--header\">Description</th>       </tr>     </thead>     <tbody>       <tr>         <td class=\"basic-table__cell\" style=\"white-space: nowrap;\"><code>X-Rate-Limit-Limit</code></td>         <td class=\"basic-table__cell\">Number of max requests allowed in the current time period</td>       </tr>       <tr>         <td class=\"basic-table__cell\" style=\"white-space: nowrap;\"><code>X-Rate-Limit-Remaining</code></td>         <td class=\"basic-table__cell\">Number of remaining requests in the current time period</td>       </tr>       <tr>         <td class=\"basic-table__cell\" style=\"white-space: nowrap;\"><code>X-Rate-Limit-Reset</code></td>         <td class=\"basic-table__cell\">Timestamp of end of current time period as UNIX timestamp</td>       </tr>     </tbody>   </table> </div>  If you should run into the rate limit, you will receive the HTTP status code `429: Too many requests`.  If you should need higher rate limits, [contact us](https://phrase.com/contact).   ## Conditional GET requests / HTTP Caching  <div class=\"alert alert-info\"><p><strong>Note:</strong> Conditional GET requests are currently only supported for <a href=\"#locales_download\">locales#download</a> and <a href=\"#translations_index\">translations#index</a></p></div>  We will return an ETag or Last-Modified header with most GET requests. When you request a resource we recommend to store this value and submit them on subsequent requests as `If-Modified-Since` and `If-None-Match` headers. If the resource has not changed in the meantime, we will return the status `304 Not Modified` instead of rendering and returning the resource again. In most cases this is less time-consuming and makes your application/integration faster.  Please note that all conditional requests that return a response with status 304 don't count against your rate limits.  ``` $ curl -i -u EMAIL_OR_ACCESS_TOKEN \"https://api.phrase.com/v2/projects/1234abcd1234abcdefefabcd1234efab/locales/en/download\" HTTP/1.1 200 OK ETag: \"abcd1234abcdefefabcd1234efab1234\" Last-Modified: Wed, 28 Jan 2015 15:31:30 UTC Status: 200 OK  $ curl -i -u EMAIL_OR_ACCESS_TOKEN \"https://api.phrase.com/v2/projects/1234abcd1234abcdefefabcd1234efab/locales/en/download\" -H 'If-None-Match: \"abcd1234abcdefefabcd1234efab1234\"' HTTP/1.1 304 Not Modified ETag: \"abcd1234abcdefefabcd1234efab1234\" Last-Modified: Wed, 28 Jan 2015 15:31:30 UTC Status: 304 Not Modified  $ curl -i -u EMAIL_OR_ACCESS_TOKEN \"https://api.phrase.com/v2/projects/1234abcd1234abcdefefabcd1234efab/locales/en/download\" -H \"If-Modified-Since: Wed, 28 Jan 2015 15:31:30 UTC\" HTTP/1.1 304 Not Modified Last-Modified: Wed, 28 Jan 2015 15:31:30 UTC Status: 304 Not Modified ```   ## JSONP  The Phrase API supports [JSONP](http://en.wikipedia.org/wiki/JSONP) for all GET requests in order to deal with cross-domain request issues. Just send a `?callback` parameter along with the request to specify the Javascript function name to be called with the response content:  ``` $ curl \"https://api.phrase.com/v2/projects?callback=myFunction\" ```  The response will include the normal output for that endpoint, along with a `meta` section including header data:  ``` myFunction({   {     \"meta\": {       \"status\": 200,       ...     },     \"data\": [       {         \"id\": \"1234abcd1234abc1234abcd1234abc\"         ...       }     ]   } }); ```  To authenticate a JSONP request, you can send a valid [access token](#authentication) as the `?access_token` parameter along the request:  ``` $ curl \"https://api.phrase.com/v2/projects?callback=myFunction&access_token=ACCESS-TOKEN\" ``` 
 *
 * The version of the OpenAPI document: 2.0.0
 * Contact: support@phrase.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.phrase.client.api;

import org.phrase.client.ApiCallback;
import org.phrase.client.ApiClient;
import org.phrase.client.ApiException;
import org.phrase.client.ApiResponse;
import org.phrase.client.Configuration;
import org.phrase.client.Pair;
import org.phrase.client.ProgressRequestBody;
import org.phrase.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import org.phrase.client.model.Project;
import org.phrase.client.model.Space;
import org.phrase.client.model.SpaceCreateParameters;
import org.phrase.client.model.SpaceUpdateParameters;
import org.phrase.client.model.SpacesProjectsCreateParameters;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpacesApi {
    private ApiClient localVarApiClient;

    public SpacesApi() {
        this(Configuration.getDefaultApiClient());
    }

    public SpacesApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for spaceCreate
     * @param accountId Account ID (required)
     * @param spaceCreateParameters  (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> The resource has been created </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 429 </td><td> Rate Limiting </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
     </table>
     */
    public okhttp3.Call spaceCreateCall(String accountId, SpaceCreateParameters spaceCreateParameters, String xPhraseAppOTP, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = spaceCreateParameters;

        // create path and map variables
        String localVarPath = "/accounts/{account_id}/spaces"
            .replaceAll("\\{" + "account_id" + "\\}", localVarApiClient.escapeString(accountId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xPhraseAppOTP != null) {
            localVarHeaderParams.put("X-PhraseApp-OTP", localVarApiClient.parameterToString(xPhraseAppOTP));
        }

        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "Basic", "Token" };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call spaceCreateValidateBeforeCall(String accountId, SpaceCreateParameters spaceCreateParameters, String xPhraseAppOTP, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'accountId' is set
        if (accountId == null) {
            throw new ApiException("Missing the required parameter 'accountId' when calling spaceCreate(Async)");
        }
        
        // verify the required parameter 'spaceCreateParameters' is set
        if (spaceCreateParameters == null) {
            throw new ApiException("Missing the required parameter 'spaceCreateParameters' when calling spaceCreate(Async)");
        }
        

        okhttp3.Call localVarCall = spaceCreateCall(accountId, spaceCreateParameters, xPhraseAppOTP, _callback);
        return localVarCall;

    }

    /**
     * Create a Space
     * Create a new Space.
     * @param accountId Account ID (required)
     * @param spaceCreateParameters  (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> The resource has been created </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 429 </td><td> Rate Limiting </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
     </table>
     */
    public void spaceCreate(String accountId, SpaceCreateParameters spaceCreateParameters, String xPhraseAppOTP) throws ApiException {
        spaceCreateWithHttpInfo(accountId, spaceCreateParameters, xPhraseAppOTP);
    }

    /**
     * Create a Space
     * Create a new Space.
     * @param accountId Account ID (required)
     * @param spaceCreateParameters  (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> The resource has been created </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 429 </td><td> Rate Limiting </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
     </table>
     */
    public ApiResponse<Void> spaceCreateWithHttpInfo(String accountId, SpaceCreateParameters spaceCreateParameters, String xPhraseAppOTP) throws ApiException {
        okhttp3.Call localVarCall = spaceCreateValidateBeforeCall(accountId, spaceCreateParameters, xPhraseAppOTP, null);
        return localVarApiClient.execute(localVarCall);
    }

    /**
     * Create a Space (asynchronously)
     * Create a new Space.
     * @param accountId Account ID (required)
     * @param spaceCreateParameters  (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> The resource has been created </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 429 </td><td> Rate Limiting </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
     </table>
     */
    public okhttp3.Call spaceCreateAsync(String accountId, SpaceCreateParameters spaceCreateParameters, String xPhraseAppOTP, final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = spaceCreateValidateBeforeCall(accountId, spaceCreateParameters, xPhraseAppOTP, _callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }
    /**
     * Build call for spaceDelete
     * @param accountId Account ID (required)
     * @param id ID (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> The resource was deleted successfully. </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 429 </td><td> Rate Limiting </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
     </table>
     */
    public okhttp3.Call spaceDeleteCall(String accountId, String id, String xPhraseAppOTP, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/accounts/{account_id}/spaces/{id}"
            .replaceAll("\\{" + "account_id" + "\\}", localVarApiClient.escapeString(accountId.toString()))
            .replaceAll("\\{" + "id" + "\\}", localVarApiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xPhraseAppOTP != null) {
            localVarHeaderParams.put("X-PhraseApp-OTP", localVarApiClient.parameterToString(xPhraseAppOTP));
        }

        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "Basic", "Token" };
        return localVarApiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call spaceDeleteValidateBeforeCall(String accountId, String id, String xPhraseAppOTP, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'accountId' is set
        if (accountId == null) {
            throw new ApiException("Missing the required parameter 'accountId' when calling spaceDelete(Async)");
        }
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling spaceDelete(Async)");
        }
        

        okhttp3.Call localVarCall = spaceDeleteCall(accountId, id, xPhraseAppOTP, _callback);
        return localVarCall;

    }

    /**
     * Delete Space
     * Delete the specified Space.
     * @param accountId Account ID (required)
     * @param id ID (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> The resource was deleted successfully. </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 429 </td><td> Rate Limiting </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
     </table>
     */
    public void spaceDelete(String accountId, String id, String xPhraseAppOTP) throws ApiException {
        spaceDeleteWithHttpInfo(accountId, id, xPhraseAppOTP);
    }

    /**
     * Delete Space
     * Delete the specified Space.
     * @param accountId Account ID (required)
     * @param id ID (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> The resource was deleted successfully. </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 429 </td><td> Rate Limiting </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
     </table>
     */
    public ApiResponse<Void> spaceDeleteWithHttpInfo(String accountId, String id, String xPhraseAppOTP) throws ApiException {
        okhttp3.Call localVarCall = spaceDeleteValidateBeforeCall(accountId, id, xPhraseAppOTP, null);
        return localVarApiClient.execute(localVarCall);
    }

    /**
     * Delete Space (asynchronously)
     * Delete the specified Space.
     * @param accountId Account ID (required)
     * @param id ID (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> The resource was deleted successfully. </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 429 </td><td> Rate Limiting </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
     </table>
     */
    public okhttp3.Call spaceDeleteAsync(String accountId, String id, String xPhraseAppOTP, final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = spaceDeleteValidateBeforeCall(accountId, id, xPhraseAppOTP, _callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }
    /**
     * Build call for spaceShow
     * @param accountId Account ID (required)
     * @param id ID (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 429 </td><td> Rate Limiting </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
     </table>
     */
    public okhttp3.Call spaceShowCall(String accountId, String id, String xPhraseAppOTP, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/accounts/{account_id}/spaces/{id}"
            .replaceAll("\\{" + "account_id" + "\\}", localVarApiClient.escapeString(accountId.toString()))
            .replaceAll("\\{" + "id" + "\\}", localVarApiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xPhraseAppOTP != null) {
            localVarHeaderParams.put("X-PhraseApp-OTP", localVarApiClient.parameterToString(xPhraseAppOTP));
        }

        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "Basic", "Token" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call spaceShowValidateBeforeCall(String accountId, String id, String xPhraseAppOTP, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'accountId' is set
        if (accountId == null) {
            throw new ApiException("Missing the required parameter 'accountId' when calling spaceShow(Async)");
        }
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling spaceShow(Async)");
        }
        

        okhttp3.Call localVarCall = spaceShowCall(accountId, id, xPhraseAppOTP, _callback);
        return localVarCall;

    }

    /**
     * Get Space
     * Show the specified Space.
     * @param accountId Account ID (required)
     * @param id ID (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @return Space
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 429 </td><td> Rate Limiting </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
     </table>
     */
    public Space spaceShow(String accountId, String id, String xPhraseAppOTP) throws ApiException {
        ApiResponse<Space> localVarResp = spaceShowWithHttpInfo(accountId, id, xPhraseAppOTP);
        return localVarResp.getData();
    }

    /**
     * Get Space
     * Show the specified Space.
     * @param accountId Account ID (required)
     * @param id ID (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @return ApiResponse&lt;Space&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 429 </td><td> Rate Limiting </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
     </table>
     */
    public ApiResponse<Space> spaceShowWithHttpInfo(String accountId, String id, String xPhraseAppOTP) throws ApiException {
        okhttp3.Call localVarCall = spaceShowValidateBeforeCall(accountId, id, xPhraseAppOTP, null);
        Type localVarReturnType = new TypeToken<Space>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get Space (asynchronously)
     * Show the specified Space.
     * @param accountId Account ID (required)
     * @param id ID (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 429 </td><td> Rate Limiting </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
     </table>
     */
    public okhttp3.Call spaceShowAsync(String accountId, String id, String xPhraseAppOTP, final ApiCallback<Space> _callback) throws ApiException {

        okhttp3.Call localVarCall = spaceShowValidateBeforeCall(accountId, id, xPhraseAppOTP, _callback);
        Type localVarReturnType = new TypeToken<Space>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for spaceUpdate
     * @param accountId Account ID (required)
     * @param id ID (required)
     * @param spaceUpdateParameters  (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 429 </td><td> Rate Limiting </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
     </table>
     */
    public okhttp3.Call spaceUpdateCall(String accountId, String id, SpaceUpdateParameters spaceUpdateParameters, String xPhraseAppOTP, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = spaceUpdateParameters;

        // create path and map variables
        String localVarPath = "/accounts/{account_id}/spaces/{id}"
            .replaceAll("\\{" + "account_id" + "\\}", localVarApiClient.escapeString(accountId.toString()))
            .replaceAll("\\{" + "id" + "\\}", localVarApiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xPhraseAppOTP != null) {
            localVarHeaderParams.put("X-PhraseApp-OTP", localVarApiClient.parameterToString(xPhraseAppOTP));
        }

        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "Basic", "Token" };
        return localVarApiClient.buildCall(localVarPath, "PATCH", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call spaceUpdateValidateBeforeCall(String accountId, String id, SpaceUpdateParameters spaceUpdateParameters, String xPhraseAppOTP, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'accountId' is set
        if (accountId == null) {
            throw new ApiException("Missing the required parameter 'accountId' when calling spaceUpdate(Async)");
        }
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling spaceUpdate(Async)");
        }
        
        // verify the required parameter 'spaceUpdateParameters' is set
        if (spaceUpdateParameters == null) {
            throw new ApiException("Missing the required parameter 'spaceUpdateParameters' when calling spaceUpdate(Async)");
        }
        

        okhttp3.Call localVarCall = spaceUpdateCall(accountId, id, spaceUpdateParameters, xPhraseAppOTP, _callback);
        return localVarCall;

    }

    /**
     * Update Space
     * Update the specified Space.
     * @param accountId Account ID (required)
     * @param id ID (required)
     * @param spaceUpdateParameters  (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @return Space
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 429 </td><td> Rate Limiting </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
     </table>
     */
    public Space spaceUpdate(String accountId, String id, SpaceUpdateParameters spaceUpdateParameters, String xPhraseAppOTP) throws ApiException {
        ApiResponse<Space> localVarResp = spaceUpdateWithHttpInfo(accountId, id, spaceUpdateParameters, xPhraseAppOTP);
        return localVarResp.getData();
    }

    /**
     * Update Space
     * Update the specified Space.
     * @param accountId Account ID (required)
     * @param id ID (required)
     * @param spaceUpdateParameters  (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @return ApiResponse&lt;Space&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 429 </td><td> Rate Limiting </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
     </table>
     */
    public ApiResponse<Space> spaceUpdateWithHttpInfo(String accountId, String id, SpaceUpdateParameters spaceUpdateParameters, String xPhraseAppOTP) throws ApiException {
        okhttp3.Call localVarCall = spaceUpdateValidateBeforeCall(accountId, id, spaceUpdateParameters, xPhraseAppOTP, null);
        Type localVarReturnType = new TypeToken<Space>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Update Space (asynchronously)
     * Update the specified Space.
     * @param accountId Account ID (required)
     * @param id ID (required)
     * @param spaceUpdateParameters  (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 429 </td><td> Rate Limiting </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
     </table>
     */
    public okhttp3.Call spaceUpdateAsync(String accountId, String id, SpaceUpdateParameters spaceUpdateParameters, String xPhraseAppOTP, final ApiCallback<Space> _callback) throws ApiException {

        okhttp3.Call localVarCall = spaceUpdateValidateBeforeCall(accountId, id, spaceUpdateParameters, xPhraseAppOTP, _callback);
        Type localVarReturnType = new TypeToken<Space>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for spacesList
     * @param accountId Account ID (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @param page Page number (optional)
     * @param perPage allows you to specify a page size up to 100 items, 10 by default (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  * Link -  <br>  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 429 </td><td> Rate Limiting </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
     </table>
     */
    public okhttp3.Call spacesListCall(String accountId, String xPhraseAppOTP, Integer page, Integer perPage, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/accounts/{account_id}/spaces"
            .replaceAll("\\{" + "account_id" + "\\}", localVarApiClient.escapeString(accountId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (page != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page", page));
        }

        if (perPage != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("per_page", perPage));
        }

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xPhraseAppOTP != null) {
            localVarHeaderParams.put("X-PhraseApp-OTP", localVarApiClient.parameterToString(xPhraseAppOTP));
        }

        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "Basic", "Token" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call spacesListValidateBeforeCall(String accountId, String xPhraseAppOTP, Integer page, Integer perPage, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'accountId' is set
        if (accountId == null) {
            throw new ApiException("Missing the required parameter 'accountId' when calling spacesList(Async)");
        }
        

        okhttp3.Call localVarCall = spacesListCall(accountId, xPhraseAppOTP, page, perPage, _callback);
        return localVarCall;

    }

    /**
     * List Spaces
     * List all Spaces for the given account.
     * @param accountId Account ID (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @param page Page number (optional)
     * @param perPage allows you to specify a page size up to 100 items, 10 by default (optional)
     * @return List&lt;Space&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  * Link -  <br>  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 429 </td><td> Rate Limiting </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
     </table>
     */
    public List<Space> spacesList(String accountId, String xPhraseAppOTP, Integer page, Integer perPage) throws ApiException {
        ApiResponse<List<Space>> localVarResp = spacesListWithHttpInfo(accountId, xPhraseAppOTP, page, perPage);
        return localVarResp.getData();
    }

    /**
     * List Spaces
     * List all Spaces for the given account.
     * @param accountId Account ID (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @param page Page number (optional)
     * @param perPage allows you to specify a page size up to 100 items, 10 by default (optional)
     * @return ApiResponse&lt;List&lt;Space&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  * Link -  <br>  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 429 </td><td> Rate Limiting </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
     </table>
     */
    public ApiResponse<List<Space>> spacesListWithHttpInfo(String accountId, String xPhraseAppOTP, Integer page, Integer perPage) throws ApiException {
        okhttp3.Call localVarCall = spacesListValidateBeforeCall(accountId, xPhraseAppOTP, page, perPage, null);
        Type localVarReturnType = new TypeToken<List<Space>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * List Spaces (asynchronously)
     * List all Spaces for the given account.
     * @param accountId Account ID (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @param page Page number (optional)
     * @param perPage allows you to specify a page size up to 100 items, 10 by default (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  * Link -  <br>  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 429 </td><td> Rate Limiting </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
     </table>
     */
    public okhttp3.Call spacesListAsync(String accountId, String xPhraseAppOTP, Integer page, Integer perPage, final ApiCallback<List<Space>> _callback) throws ApiException {

        okhttp3.Call localVarCall = spacesListValidateBeforeCall(accountId, xPhraseAppOTP, page, perPage, _callback);
        Type localVarReturnType = new TypeToken<List<Space>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for spacesProjectsCreate
     * @param accountId Account ID (required)
     * @param spaceId Space ID (required)
     * @param spacesProjectsCreateParameters  (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> The resource has been created </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 429 </td><td> Rate Limiting </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
     </table>
     */
    public okhttp3.Call spacesProjectsCreateCall(String accountId, String spaceId, SpacesProjectsCreateParameters spacesProjectsCreateParameters, String xPhraseAppOTP, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = spacesProjectsCreateParameters;

        // create path and map variables
        String localVarPath = "/accounts/{account_id}/spaces/{space_id}/projects"
            .replaceAll("\\{" + "account_id" + "\\}", localVarApiClient.escapeString(accountId.toString()))
            .replaceAll("\\{" + "space_id" + "\\}", localVarApiClient.escapeString(spaceId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xPhraseAppOTP != null) {
            localVarHeaderParams.put("X-PhraseApp-OTP", localVarApiClient.parameterToString(xPhraseAppOTP));
        }

        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "Basic", "Token" };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call spacesProjectsCreateValidateBeforeCall(String accountId, String spaceId, SpacesProjectsCreateParameters spacesProjectsCreateParameters, String xPhraseAppOTP, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'accountId' is set
        if (accountId == null) {
            throw new ApiException("Missing the required parameter 'accountId' when calling spacesProjectsCreate(Async)");
        }
        
        // verify the required parameter 'spaceId' is set
        if (spaceId == null) {
            throw new ApiException("Missing the required parameter 'spaceId' when calling spacesProjectsCreate(Async)");
        }
        
        // verify the required parameter 'spacesProjectsCreateParameters' is set
        if (spacesProjectsCreateParameters == null) {
            throw new ApiException("Missing the required parameter 'spacesProjectsCreateParameters' when calling spacesProjectsCreate(Async)");
        }
        

        okhttp3.Call localVarCall = spacesProjectsCreateCall(accountId, spaceId, spacesProjectsCreateParameters, xPhraseAppOTP, _callback);
        return localVarCall;

    }

    /**
     * Add Project
     * Adds an existing project to the space.
     * @param accountId Account ID (required)
     * @param spaceId Space ID (required)
     * @param spacesProjectsCreateParameters  (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> The resource has been created </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 429 </td><td> Rate Limiting </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
     </table>
     */
    public void spacesProjectsCreate(String accountId, String spaceId, SpacesProjectsCreateParameters spacesProjectsCreateParameters, String xPhraseAppOTP) throws ApiException {
        spacesProjectsCreateWithHttpInfo(accountId, spaceId, spacesProjectsCreateParameters, xPhraseAppOTP);
    }

    /**
     * Add Project
     * Adds an existing project to the space.
     * @param accountId Account ID (required)
     * @param spaceId Space ID (required)
     * @param spacesProjectsCreateParameters  (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> The resource has been created </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 429 </td><td> Rate Limiting </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
     </table>
     */
    public ApiResponse<Void> spacesProjectsCreateWithHttpInfo(String accountId, String spaceId, SpacesProjectsCreateParameters spacesProjectsCreateParameters, String xPhraseAppOTP) throws ApiException {
        okhttp3.Call localVarCall = spacesProjectsCreateValidateBeforeCall(accountId, spaceId, spacesProjectsCreateParameters, xPhraseAppOTP, null);
        return localVarApiClient.execute(localVarCall);
    }

    /**
     * Add Project (asynchronously)
     * Adds an existing project to the space.
     * @param accountId Account ID (required)
     * @param spaceId Space ID (required)
     * @param spacesProjectsCreateParameters  (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> The resource has been created </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 429 </td><td> Rate Limiting </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
     </table>
     */
    public okhttp3.Call spacesProjectsCreateAsync(String accountId, String spaceId, SpacesProjectsCreateParameters spacesProjectsCreateParameters, String xPhraseAppOTP, final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = spacesProjectsCreateValidateBeforeCall(accountId, spaceId, spacesProjectsCreateParameters, xPhraseAppOTP, _callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }
    /**
     * Build call for spacesProjectsDelete
     * @param accountId Account ID (required)
     * @param spaceId Space ID (required)
     * @param id ID (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> The resource was deleted successfully. </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 429 </td><td> Rate Limiting </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
     </table>
     */
    public okhttp3.Call spacesProjectsDeleteCall(String accountId, String spaceId, String id, String xPhraseAppOTP, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/accounts/{account_id}/spaces/{space_id}/projects/{id}"
            .replaceAll("\\{" + "account_id" + "\\}", localVarApiClient.escapeString(accountId.toString()))
            .replaceAll("\\{" + "space_id" + "\\}", localVarApiClient.escapeString(spaceId.toString()))
            .replaceAll("\\{" + "id" + "\\}", localVarApiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xPhraseAppOTP != null) {
            localVarHeaderParams.put("X-PhraseApp-OTP", localVarApiClient.parameterToString(xPhraseAppOTP));
        }

        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "Basic", "Token" };
        return localVarApiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call spacesProjectsDeleteValidateBeforeCall(String accountId, String spaceId, String id, String xPhraseAppOTP, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'accountId' is set
        if (accountId == null) {
            throw new ApiException("Missing the required parameter 'accountId' when calling spacesProjectsDelete(Async)");
        }
        
        // verify the required parameter 'spaceId' is set
        if (spaceId == null) {
            throw new ApiException("Missing the required parameter 'spaceId' when calling spacesProjectsDelete(Async)");
        }
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling spacesProjectsDelete(Async)");
        }
        

        okhttp3.Call localVarCall = spacesProjectsDeleteCall(accountId, spaceId, id, xPhraseAppOTP, _callback);
        return localVarCall;

    }

    /**
     * Remove Project
     * Removes a specified project from the specified space.
     * @param accountId Account ID (required)
     * @param spaceId Space ID (required)
     * @param id ID (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> The resource was deleted successfully. </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 429 </td><td> Rate Limiting </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
     </table>
     */
    public void spacesProjectsDelete(String accountId, String spaceId, String id, String xPhraseAppOTP) throws ApiException {
        spacesProjectsDeleteWithHttpInfo(accountId, spaceId, id, xPhraseAppOTP);
    }

    /**
     * Remove Project
     * Removes a specified project from the specified space.
     * @param accountId Account ID (required)
     * @param spaceId Space ID (required)
     * @param id ID (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> The resource was deleted successfully. </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 429 </td><td> Rate Limiting </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
     </table>
     */
    public ApiResponse<Void> spacesProjectsDeleteWithHttpInfo(String accountId, String spaceId, String id, String xPhraseAppOTP) throws ApiException {
        okhttp3.Call localVarCall = spacesProjectsDeleteValidateBeforeCall(accountId, spaceId, id, xPhraseAppOTP, null);
        return localVarApiClient.execute(localVarCall);
    }

    /**
     * Remove Project (asynchronously)
     * Removes a specified project from the specified space.
     * @param accountId Account ID (required)
     * @param spaceId Space ID (required)
     * @param id ID (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> The resource was deleted successfully. </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 429 </td><td> Rate Limiting </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
     </table>
     */
    public okhttp3.Call spacesProjectsDeleteAsync(String accountId, String spaceId, String id, String xPhraseAppOTP, final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = spacesProjectsDeleteValidateBeforeCall(accountId, spaceId, id, xPhraseAppOTP, _callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }
    /**
     * Build call for spacesProjectsList
     * @param accountId Account ID (required)
     * @param spaceId Space ID (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @param page Page number (optional)
     * @param perPage allows you to specify a page size up to 100 items, 10 by default (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  * Link -  <br>  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 429 </td><td> Rate Limiting </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
     </table>
     */
    public okhttp3.Call spacesProjectsListCall(String accountId, String spaceId, String xPhraseAppOTP, Integer page, Integer perPage, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/accounts/{account_id}/spaces/{space_id}/projects"
            .replaceAll("\\{" + "account_id" + "\\}", localVarApiClient.escapeString(accountId.toString()))
            .replaceAll("\\{" + "space_id" + "\\}", localVarApiClient.escapeString(spaceId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (page != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page", page));
        }

        if (perPage != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("per_page", perPage));
        }

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xPhraseAppOTP != null) {
            localVarHeaderParams.put("X-PhraseApp-OTP", localVarApiClient.parameterToString(xPhraseAppOTP));
        }

        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "Basic", "Token" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call spacesProjectsListValidateBeforeCall(String accountId, String spaceId, String xPhraseAppOTP, Integer page, Integer perPage, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'accountId' is set
        if (accountId == null) {
            throw new ApiException("Missing the required parameter 'accountId' when calling spacesProjectsList(Async)");
        }
        
        // verify the required parameter 'spaceId' is set
        if (spaceId == null) {
            throw new ApiException("Missing the required parameter 'spaceId' when calling spacesProjectsList(Async)");
        }
        

        okhttp3.Call localVarCall = spacesProjectsListCall(accountId, spaceId, xPhraseAppOTP, page, perPage, _callback);
        return localVarCall;

    }

    /**
     * List Projects
     * List all projects for the specified Space.
     * @param accountId Account ID (required)
     * @param spaceId Space ID (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @param page Page number (optional)
     * @param perPage allows you to specify a page size up to 100 items, 10 by default (optional)
     * @return List&lt;Project&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  * Link -  <br>  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 429 </td><td> Rate Limiting </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
     </table>
     */
    public List<Project> spacesProjectsList(String accountId, String spaceId, String xPhraseAppOTP, Integer page, Integer perPage) throws ApiException {
        ApiResponse<List<Project>> localVarResp = spacesProjectsListWithHttpInfo(accountId, spaceId, xPhraseAppOTP, page, perPage);
        return localVarResp.getData();
    }

    /**
     * List Projects
     * List all projects for the specified Space.
     * @param accountId Account ID (required)
     * @param spaceId Space ID (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @param page Page number (optional)
     * @param perPage allows you to specify a page size up to 100 items, 10 by default (optional)
     * @return ApiResponse&lt;List&lt;Project&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  * Link -  <br>  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 429 </td><td> Rate Limiting </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
     </table>
     */
    public ApiResponse<List<Project>> spacesProjectsListWithHttpInfo(String accountId, String spaceId, String xPhraseAppOTP, Integer page, Integer perPage) throws ApiException {
        okhttp3.Call localVarCall = spacesProjectsListValidateBeforeCall(accountId, spaceId, xPhraseAppOTP, page, perPage, null);
        Type localVarReturnType = new TypeToken<List<Project>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * List Projects (asynchronously)
     * List all projects for the specified Space.
     * @param accountId Account ID (required)
     * @param spaceId Space ID (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @param page Page number (optional)
     * @param perPage allows you to specify a page size up to 100 items, 10 by default (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  * Link -  <br>  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
        <tr><td> 429 </td><td> Rate Limiting </td><td>  * X-Rate-Limit-Limit -  <br>  * X-Rate-Limit-Remaining -  <br>  * X-Rate-Limit-Reset -  <br>  </td></tr>
     </table>
     */
    public okhttp3.Call spacesProjectsListAsync(String accountId, String spaceId, String xPhraseAppOTP, Integer page, Integer perPage, final ApiCallback<List<Project>> _callback) throws ApiException {

        okhttp3.Call localVarCall = spacesProjectsListValidateBeforeCall(accountId, spaceId, xPhraseAppOTP, page, perPage, _callback);
        Type localVarReturnType = new TypeToken<List<Project>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
