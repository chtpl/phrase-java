/*
 * Phrase API Reference
 * Phrase is a translation management platform for software projects. You can collaborate on language file translation with your team or order translations through our platform. The API allows you to import locale files, download locale files, tag keys or interact in other ways with the localization data stored in Phrase for your account.  ## API Endpoint  <div class=\"resource__code--outer\">   <div class=\"code-section\">     <pre><code>https://api.phrase.com/v2/</code></pre>   </div> </div>  The API is only accessible via HTTPS, the base URL is <code>https://api.phrase.com/</code>, and the current version is <code>v2</code> which results in the base URL for all requests: <code>https://api.phrase.com/v2/</code>.   ## Usage  [curl](http://curl.haxx.se/) is used primarily to send requests to Phrase in the examples. On most you'll find a second variant using the [Phrase API v2 client](https://phrase.com/cli/) that might be more convenient to handle. For further information check its [documentation](https://help.phrase.com/help/phrase-in-your-terminal).   ## Use of HTTP Verbs  Phrase API v2 tries to use the appropriate HTTP verb for accessing each endpoint according to REST specification where possible:  <div class=\"table-responsive\">   <table class=\"basic-table\">     <thead>       <tr class=\"basic-table__row basic-table__row--header\">         <th class=\"basic-table__cell basic-table__cell--header\">Verb</th>         <th class=\"basic-table__cell basic-table__cell--header\">Description</th>       </tr>     </thead>     <tbody>       <tr>         <td class=\"basic-table__cell\">GET</td>         <td class=\"basic-table__cell\">Retrieve one or multiple resources</td>       </tr>       <tr>         <td class=\"basic-table__cell\">POST</td>         <td class=\"basic-table__cell\">Create a resource</td>       </tr>       <tr>         <td class=\"basic-table__cell\">PUT</td>         <td class=\"basic-table__cell\">Update a resource</td>       </tr>       <tr>         <td class=\"basic-table__cell\">PATCH</td>         <td class=\"basic-table__cell\">Update a resource (partially)</td>       </tr>       <tr>         <td class=\"basic-table__cell\">DELETE</td>         <td class=\"basic-table__cell\">Delete a resource</td>       </tr>     </tbody>   </table> </div>   ## Identification via User-Agent  You must include the User-Agent header with the name of your application or project. It might be a good idea to include some sort of contact information  as well, so that we can get in touch if necessary (e.g. to warn you about Rate-Limiting or badly formed requests). Examples of excellent User-Agent headers:  <pre><code>User-Agent: Frederiks Mobile App (frederik@phrase.com) User-Agent: ACME Inc Python Client (http://example.com/contact)</code></pre>  If you don't send this header, you will receive a response with 400 Bad Request.   ## Lists  When you request a list of resources, the API will typically only return an array of resources including their most important attributes. For a detailed representation of the resource you should request its detailed representation.  Lists are usually [paginated](#pagination).   ## Parameters  Many endpoints support additional parameters, e.g. for pagination. When passing them in a GET request you can send them as HTTP query string parameters:  <pre><code>$ curl -u EMAIL_OR_ACCESS_TOKEN \"https://api.phrase.com/v2/projects?page=2\"</code></pre>  When performing a POST, PUT, PATCH or DELETE request, we recommend sending parameters that are not already included in the URL, as JSON body:  <pre><code>$ curl -H 'Content-Type: application/json' -d '{\"name\":\"My new project\"}' -u EMAIL_OR_ACCESS_TOKEN https://api.phrase.com/v2/projects</code></pre>  Encoding parameters as JSON means better support for types (boolean, integer) and usually better readability. Don't forget to set the correct Content-Type for your request.  *The Content-Type header is omitted in some of the following examples for better readbility.*   ## Errors   ### Request Errors  If a request contains invalid JSON or is missing a required parameter (besides resource attributes), the status `400 Bad Request` is returned:  <pre><code>{   \"message\": \"JSON could not be parsed\" }</code></pre>   ### Validation Errors  When the validation for a resource fails, the status `422 Unprocessable Entity` is returned, along with information on the affected fields:  <pre><code>{   \"message\": \"Validation Failed\",   \"errors\": [     {       \"resource\": \"Project\",       \"field\": \"name\",       \"message\": \"can't be blank\"     }   ] }</code></pre>   ## Date Format  Times and dates are returned and expected in [ISO 8601](http://en.wikipedia.org/wiki/ISO_8601) date format:  <pre><code>YYYY-MM-DDTHH:MM:SSZ</code></pre>  Instead of 'Z' for UTC time zone you can specify your time zone's locale offset using the following notation:  <pre><code>YYYY-MM-DDTHH:MM:SS¬±hh:mm</code></pre>  Example for CET (1 hour behind UTC):  <pre><code>2015-03-31T13:00+01:00</code></pre>  Please note that in HTTP headers, we will use the appropriate recommended date formats instead of ISO 8601.   ## Authentication  <div class=\"alert alert-info\">For more detailed information on authentication, check out the <a href=\"#authentication\">API v2 Authentication Guide</a>.</div>  There are two different ways to authenticate when performing API requests:  * E-Mail and password * Oauth Access Token   ### E-Mail and password  To get started easily, you can use HTTP Basic authentication with your email and password:  <pre><code>$ curl -u username:password \"https://api.phrase.com/v2/projects\"</code></pre>   ### OAuth via Access Tokens  You can create and manage access tokens in your [profile settings](https://app.phrase.com/settings/oauth_access_tokens) in Translation Center or via the [Authorizations API](#authorizations).  Simply pass the access token as the username of your request:  <pre><code>$ curl -u ACCESS_TOKEN: \"https://api.phrase.com/v2/projects\"</code></pre>  or send the access token via the `Authorization` header field:  <pre><code>$ curl -H \"Authorization: token ACCESS_TOKEN\" https://api.phrase.com/v2/projects</code></pre>  For more detailed information on authentication, check out the <a href=\"#authentication\">API v2 Authentication Guide</a>.  #### Send via parameter  As JSONP (and other) requests cannot send HTTP Basic Auth credentials, a special query parameter `access_token` can be used:  <pre><code>curl \"https://api.phrase.com/v2/projects?access_token=ACCESS_TOKEN\"</code></pre>  You should only use this transport method if sending the authentication via header or Basic authentication is not possible.  ### Two-Factor-Authentication  Users with Two-Factor-Authentication enabled have to send a valid token along their request with certain authentication methods (such as Basic authentication). The necessity of a Two-Factor-Authentication token is indicated by the `X-PhraseApp-OTP: required; :MFA-type` header in the response. The `:MFA-type`field indicates the source of the token, e.g. `app` (refers to your Authenticator application):  <pre><code>X-PhraseApp-OTP: required; app</code></pre>  To provide a Two-Factor-Authentication token you can simply send it in the header of the request:  <pre><code>curl -H \"X-PhraseApp-OTP: MFA-TOKEN\" -u EMAIL https://api.phrase.com/v2/projects</code></pre>  Since Two-Factor-Authentication tokens usually expire quickly, we recommend using an alternative authentication method such as OAuth access tokens.  ### Multiple Accounts  Some endpoints require the account ID to be specified if the authenticated user is a member of multiple accounts. You can find the eight-digit account ID inside <a href=\"https://app.phrase.com/\" target=\"_blank\">Translation Center</a> by switching to the desired account and then visiting the account details page. If required, you can specify the account just like a normal parameter within the request.  ## Pagination  Endpoints that return a list or resources will usually return paginated results and include 25 items by default. To access further pages, use the `page` parameter:  <pre><code>$ curl -u EMAIL_OR_ACCESS_TOKEN \"https://api.phrase.com/v2/projects?page=2\"</code></pre>  Some endpoints also allow a custom page size by using the `per_page` parameter:  <pre><code>$ curl -u EMAIL_OR_ACCESS_TOKEN \"https://api.phrase.com/v2/projects?page=2&per_page=50\"</code></pre>  Unless specified otherwise in the description of the respective endpoint, `per_page` allows you to specify a page size up to 100 items.   ## Link-Headers  We provide you with pagination URLs in the [Link Header field](http://tools.ietf.org/html/rfc5988). Make use of this information to avoid building pagination URLs yourself.  <pre><code>Link: <https://api.phrase.com/v2/projects?page=1>; rel=\"first\", <https://api.phrase.com/v2/projects?page=3>; rel=\"prev\", <https://api.phrase.com/v2/projects?page=5>; rel=\"next\", <https://api.phrase.com/v2/projects?page=9>; rel=\"last\"</code></pre>  Possible `rel` values are:  <div class=\"table-responsive\">   <table class=\"basic-table\">     <thead>       <tr class=\"basic-table__row basic-table__row--header\">         <th class=\"basic-table__cell basic-table__cell--header\">Value</th>         <th class=\"basic-table__cell basic-table__cell--header\">Description</th>       </tr>     </thead>     <tbody>       <tr>         <td class=\"basic-table__cell\">next</td>         <td class=\"basic-table__cell\">URL of the next page of results</td>       </tr>       <tr>         <td class=\"basic-table__cell\">last</td>         <td class=\"basic-table__cell\">URL of the last page of results</td>       </tr>       <tr>         <td class=\"basic-table__cell\">first</td>         <td class=\"basic-table__cell\">URL of the first page of results</td>       </tr>       <tr>         <td class=\"basic-table__cell\">prev</td>         <td class=\"basic-table__cell\">URL of the previous page of results</td>       </tr>     </tbody>   </table> </div>  ## Rate Limiting  All API endpoints are subject to rate limiting to ensure good performance for all customers. The rate limit is calculated per user:  * 1000 requests per 5 minutes * 4 concurrent (parallel) requests  For your convenience we send information on the current rate limit within the response headers:  <div class=\"table-responsive\">   <table class=\"basic-table\">     <thead>       <tr class=\"basic-table__row basic-table__row--header\">         <th class=\"basic-table__cell basic-table__cell--header\">Header</th>         <th class=\"basic-table__cell basic-table__cell--header\">Description</th>       </tr>     </thead>     <tbody>       <tr>         <td class=\"basic-table__cell\" style=\"white-space: nowrap;\"><code>X-Rate-Limit-Limit</code></td>         <td class=\"basic-table__cell\">Number of max requests allowed in the current time period</td>       </tr>       <tr>         <td class=\"basic-table__cell\" style=\"white-space: nowrap;\"><code>X-Rate-Limit-Remaining</code></td>         <td class=\"basic-table__cell\">Number of remaining requests in the current time period</td>       </tr>       <tr>         <td class=\"basic-table__cell\" style=\"white-space: nowrap;\"><code>X-Rate-Limit-Reset</code></td>         <td class=\"basic-table__cell\">Timestamp of end of current time period as UNIX timestamp</td>       </tr>     </tbody>   </table> </div>  If you should run into the rate limit, you will receive the HTTP status code `429: Too many requests`.  If you should need higher rate limits, [contact us](https://phrase.com/contact).   ## Conditional GET requests / HTTP Caching  <div class=\"alert alert-info\"><p><strong>Note:</strong> Conditional GET requests are currently only supported for <a href=\"#locales_download\">locales#download</a> and <a href=\"#translations_index\">translations#index</a></p></div>  We will return an ETag or Last-Modified header with most GET requests. When you request a resource we recommend to store this value and submit them on subsequent requests as `If-Modified-Since` and `If-None-Match` headers. If the resource has not changed in the meantime, we will return the status `304 Not Modified` instead of rendering and returning the resource again. In most cases this is less time-consuming and makes your application/integration faster.  Please note that all conditional requests that return a response with status 304 don't count against your rate limits.  <pre><code>$ curl -i -u EMAIL_OR_ACCESS_TOKEN \"https://api.phrase.com/v2/projects/1234abcd1234abcdefefabcd1234efab/locales/en/download\" HTTP/1.1 200 OK ETag: \"abcd1234abcdefefabcd1234efab1234\" Last-Modified: Wed, 28 Jan 2015 15:31:30 UTC Status: 200 OK  $ curl -i -u EMAIL_OR_ACCESS_TOKEN \"https://api.phrase.com/v2/projects/1234abcd1234abcdefefabcd1234efab/locales/en/download\" -H 'If-None-Match: \"abcd1234abcdefefabcd1234efab1234\"' HTTP/1.1 304 Not Modified ETag: \"abcd1234abcdefefabcd1234efab1234\" Last-Modified: Wed, 28 Jan 2015 15:31:30 UTC Status: 304 Not Modified  $ curl -i -u EMAIL_OR_ACCESS_TOKEN \"https://api.phrase.com/v2/projects/1234abcd1234abcdefefabcd1234efab/locales/en/download\" -H \"If-Modified-Since: Wed, 28 Jan 2015 15:31:30 UTC\" HTTP/1.1 304 Not Modified Last-Modified: Wed, 28 Jan 2015 15:31:30 UTC Status: 304 Not Modified</code></pre>   ## JSONP  The Phrase API supports [JSONP](http://en.wikipedia.org/wiki/JSONP) for all GET requests in order to deal with cross-domain request issues. Just send a `?callback` parameter along with the request to specify the Javascript function name to be called with the response content:  <pre><code>$ curl \"https://api.phrase.com/v2/projects?callback=myFunction\"</code></pre>  The response will include the normal output for that endpoint, along with a `meta` section including header data:  <pre><code>myFunction({   {     \"meta\": {       \"status\": 200,       ...     },     \"data\": [       {         \"id\": \"1234abcd1234abc1234abcd1234abc\"         ...       }     ]   } });</code></pre>  To authenticate a JSONP request, you can send a valid [access token](#authentication) as the `?access_token` parameter along the request:  <pre><code>$ curl \"https://api.phrase.com/v2/projects?callback=myFunction&access_token=ACCESS-TOKEN\"</code></pre> 
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


import org.phrase.client.model.BlacklistedKey;
import org.phrase.client.model.BlacklistedKeyCreateParameters;
import org.phrase.client.model.BlacklistedKeyUpdateParameters;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlacklistedKeysApi {
    private ApiClient localVarApiClient;

    public BlacklistedKeysApi() {
        this(Configuration.getDefaultApiClient());
    }

    public BlacklistedKeysApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for blacklistedKeyCreate
     * @param projectId Project ID (required)
     * @param blacklistedKeyCreateParameters  (required)
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
    public okhttp3.Call blacklistedKeyCreateCall(String projectId, BlacklistedKeyCreateParameters blacklistedKeyCreateParameters, String xPhraseAppOTP, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = blacklistedKeyCreateParameters;

        // create path and map variables
        String localVarPath = "/projects/{project_id}/blacklisted_keys"
            .replaceAll("\\{" + "project_id" + "\\}", localVarApiClient.escapeString(projectId.toString()));

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
    private okhttp3.Call blacklistedKeyCreateValidateBeforeCall(String projectId, BlacklistedKeyCreateParameters blacklistedKeyCreateParameters, String xPhraseAppOTP, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new ApiException("Missing the required parameter 'projectId' when calling blacklistedKeyCreate(Async)");
        }
        
        // verify the required parameter 'blacklistedKeyCreateParameters' is set
        if (blacklistedKeyCreateParameters == null) {
            throw new ApiException("Missing the required parameter 'blacklistedKeyCreateParameters' when calling blacklistedKeyCreate(Async)");
        }
        

        okhttp3.Call localVarCall = blacklistedKeyCreateCall(projectId, blacklistedKeyCreateParameters, xPhraseAppOTP, _callback);
        return localVarCall;

    }

    /**
     * Create a blacklisted key
     * Create a new rule for blacklisting keys.
     * @param projectId Project ID (required)
     * @param blacklistedKeyCreateParameters  (required)
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
    public void blacklistedKeyCreate(String projectId, BlacklistedKeyCreateParameters blacklistedKeyCreateParameters, String xPhraseAppOTP) throws ApiException {
        blacklistedKeyCreateWithHttpInfo(projectId, blacklistedKeyCreateParameters, xPhraseAppOTP);
    }

    /**
     * Create a blacklisted key
     * Create a new rule for blacklisting keys.
     * @param projectId Project ID (required)
     * @param blacklistedKeyCreateParameters  (required)
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
    public ApiResponse<Void> blacklistedKeyCreateWithHttpInfo(String projectId, BlacklistedKeyCreateParameters blacklistedKeyCreateParameters, String xPhraseAppOTP) throws ApiException {
        okhttp3.Call localVarCall = blacklistedKeyCreateValidateBeforeCall(projectId, blacklistedKeyCreateParameters, xPhraseAppOTP, null);
        return localVarApiClient.execute(localVarCall);
    }

    /**
     * Create a blacklisted key (asynchronously)
     * Create a new rule for blacklisting keys.
     * @param projectId Project ID (required)
     * @param blacklistedKeyCreateParameters  (required)
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
    public okhttp3.Call blacklistedKeyCreateAsync(String projectId, BlacklistedKeyCreateParameters blacklistedKeyCreateParameters, String xPhraseAppOTP, final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = blacklistedKeyCreateValidateBeforeCall(projectId, blacklistedKeyCreateParameters, xPhraseAppOTP, _callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }
    /**
     * Build call for blacklistedKeyDelete
     * @param projectId Project ID (required)
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
    public okhttp3.Call blacklistedKeyDeleteCall(String projectId, String id, String xPhraseAppOTP, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/projects/{project_id}/blacklisted_keys/{id}"
            .replaceAll("\\{" + "project_id" + "\\}", localVarApiClient.escapeString(projectId.toString()))
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
    private okhttp3.Call blacklistedKeyDeleteValidateBeforeCall(String projectId, String id, String xPhraseAppOTP, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new ApiException("Missing the required parameter 'projectId' when calling blacklistedKeyDelete(Async)");
        }
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling blacklistedKeyDelete(Async)");
        }
        

        okhttp3.Call localVarCall = blacklistedKeyDeleteCall(projectId, id, xPhraseAppOTP, _callback);
        return localVarCall;

    }

    /**
     * Delete a blacklisted key
     * Delete an existing rule for blacklisting keys.
     * @param projectId Project ID (required)
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
    public void blacklistedKeyDelete(String projectId, String id, String xPhraseAppOTP) throws ApiException {
        blacklistedKeyDeleteWithHttpInfo(projectId, id, xPhraseAppOTP);
    }

    /**
     * Delete a blacklisted key
     * Delete an existing rule for blacklisting keys.
     * @param projectId Project ID (required)
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
    public ApiResponse<Void> blacklistedKeyDeleteWithHttpInfo(String projectId, String id, String xPhraseAppOTP) throws ApiException {
        okhttp3.Call localVarCall = blacklistedKeyDeleteValidateBeforeCall(projectId, id, xPhraseAppOTP, null);
        return localVarApiClient.execute(localVarCall);
    }

    /**
     * Delete a blacklisted key (asynchronously)
     * Delete an existing rule for blacklisting keys.
     * @param projectId Project ID (required)
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
    public okhttp3.Call blacklistedKeyDeleteAsync(String projectId, String id, String xPhraseAppOTP, final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = blacklistedKeyDeleteValidateBeforeCall(projectId, id, xPhraseAppOTP, _callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }
    /**
     * Build call for blacklistedKeyShow
     * @param projectId Project ID (required)
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
    public okhttp3.Call blacklistedKeyShowCall(String projectId, String id, String xPhraseAppOTP, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/projects/{project_id}/blacklisted_keys/{id}"
            .replaceAll("\\{" + "project_id" + "\\}", localVarApiClient.escapeString(projectId.toString()))
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
    private okhttp3.Call blacklistedKeyShowValidateBeforeCall(String projectId, String id, String xPhraseAppOTP, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new ApiException("Missing the required parameter 'projectId' when calling blacklistedKeyShow(Async)");
        }
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling blacklistedKeyShow(Async)");
        }
        

        okhttp3.Call localVarCall = blacklistedKeyShowCall(projectId, id, xPhraseAppOTP, _callback);
        return localVarCall;

    }

    /**
     * Get a single blacklisted key
     * Get details on a single rule for blacklisting keys for a given project.
     * @param projectId Project ID (required)
     * @param id ID (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @return BlacklistedKey
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
    public BlacklistedKey blacklistedKeyShow(String projectId, String id, String xPhraseAppOTP) throws ApiException {
        ApiResponse<BlacklistedKey> localVarResp = blacklistedKeyShowWithHttpInfo(projectId, id, xPhraseAppOTP);
        return localVarResp.getData();
    }

    /**
     * Get a single blacklisted key
     * Get details on a single rule for blacklisting keys for a given project.
     * @param projectId Project ID (required)
     * @param id ID (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @return ApiResponse&lt;BlacklistedKey&gt;
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
    public ApiResponse<BlacklistedKey> blacklistedKeyShowWithHttpInfo(String projectId, String id, String xPhraseAppOTP) throws ApiException {
        okhttp3.Call localVarCall = blacklistedKeyShowValidateBeforeCall(projectId, id, xPhraseAppOTP, null);
        Type localVarReturnType = new TypeToken<BlacklistedKey>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get a single blacklisted key (asynchronously)
     * Get details on a single rule for blacklisting keys for a given project.
     * @param projectId Project ID (required)
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
    public okhttp3.Call blacklistedKeyShowAsync(String projectId, String id, String xPhraseAppOTP, final ApiCallback<BlacklistedKey> _callback) throws ApiException {

        okhttp3.Call localVarCall = blacklistedKeyShowValidateBeforeCall(projectId, id, xPhraseAppOTP, _callback);
        Type localVarReturnType = new TypeToken<BlacklistedKey>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for blacklistedKeyUpdate
     * @param projectId Project ID (required)
     * @param id ID (required)
     * @param blacklistedKeyUpdateParameters  (required)
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
    public okhttp3.Call blacklistedKeyUpdateCall(String projectId, String id, BlacklistedKeyUpdateParameters blacklistedKeyUpdateParameters, String xPhraseAppOTP, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = blacklistedKeyUpdateParameters;

        // create path and map variables
        String localVarPath = "/projects/{project_id}/blacklisted_keys/{id}"
            .replaceAll("\\{" + "project_id" + "\\}", localVarApiClient.escapeString(projectId.toString()))
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
    private okhttp3.Call blacklistedKeyUpdateValidateBeforeCall(String projectId, String id, BlacklistedKeyUpdateParameters blacklistedKeyUpdateParameters, String xPhraseAppOTP, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new ApiException("Missing the required parameter 'projectId' when calling blacklistedKeyUpdate(Async)");
        }
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling blacklistedKeyUpdate(Async)");
        }
        
        // verify the required parameter 'blacklistedKeyUpdateParameters' is set
        if (blacklistedKeyUpdateParameters == null) {
            throw new ApiException("Missing the required parameter 'blacklistedKeyUpdateParameters' when calling blacklistedKeyUpdate(Async)");
        }
        

        okhttp3.Call localVarCall = blacklistedKeyUpdateCall(projectId, id, blacklistedKeyUpdateParameters, xPhraseAppOTP, _callback);
        return localVarCall;

    }

    /**
     * Update a blacklisted key
     * Update an existing rule for blacklisting keys.
     * @param projectId Project ID (required)
     * @param id ID (required)
     * @param blacklistedKeyUpdateParameters  (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @return BlacklistedKey
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
    public BlacklistedKey blacklistedKeyUpdate(String projectId, String id, BlacklistedKeyUpdateParameters blacklistedKeyUpdateParameters, String xPhraseAppOTP) throws ApiException {
        ApiResponse<BlacklistedKey> localVarResp = blacklistedKeyUpdateWithHttpInfo(projectId, id, blacklistedKeyUpdateParameters, xPhraseAppOTP);
        return localVarResp.getData();
    }

    /**
     * Update a blacklisted key
     * Update an existing rule for blacklisting keys.
     * @param projectId Project ID (required)
     * @param id ID (required)
     * @param blacklistedKeyUpdateParameters  (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @return ApiResponse&lt;BlacklistedKey&gt;
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
    public ApiResponse<BlacklistedKey> blacklistedKeyUpdateWithHttpInfo(String projectId, String id, BlacklistedKeyUpdateParameters blacklistedKeyUpdateParameters, String xPhraseAppOTP) throws ApiException {
        okhttp3.Call localVarCall = blacklistedKeyUpdateValidateBeforeCall(projectId, id, blacklistedKeyUpdateParameters, xPhraseAppOTP, null);
        Type localVarReturnType = new TypeToken<BlacklistedKey>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Update a blacklisted key (asynchronously)
     * Update an existing rule for blacklisting keys.
     * @param projectId Project ID (required)
     * @param id ID (required)
     * @param blacklistedKeyUpdateParameters  (required)
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
    public okhttp3.Call blacklistedKeyUpdateAsync(String projectId, String id, BlacklistedKeyUpdateParameters blacklistedKeyUpdateParameters, String xPhraseAppOTP, final ApiCallback<BlacklistedKey> _callback) throws ApiException {

        okhttp3.Call localVarCall = blacklistedKeyUpdateValidateBeforeCall(projectId, id, blacklistedKeyUpdateParameters, xPhraseAppOTP, _callback);
        Type localVarReturnType = new TypeToken<BlacklistedKey>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for blacklistedKeysList
     * @param projectId Project ID (required)
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
    public okhttp3.Call blacklistedKeysListCall(String projectId, String xPhraseAppOTP, Integer page, Integer perPage, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/projects/{project_id}/blacklisted_keys"
            .replaceAll("\\{" + "project_id" + "\\}", localVarApiClient.escapeString(projectId.toString()));

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
    private okhttp3.Call blacklistedKeysListValidateBeforeCall(String projectId, String xPhraseAppOTP, Integer page, Integer perPage, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new ApiException("Missing the required parameter 'projectId' when calling blacklistedKeysList(Async)");
        }
        

        okhttp3.Call localVarCall = blacklistedKeysListCall(projectId, xPhraseAppOTP, page, perPage, _callback);
        return localVarCall;

    }

    /**
     * List blacklisted keys
     * List all rules for blacklisting keys for the given project.
     * @param projectId Project ID (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @param page Page number (optional)
     * @param perPage allows you to specify a page size up to 100 items, 10 by default (optional)
     * @return List&lt;BlacklistedKey&gt;
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
    public List<BlacklistedKey> blacklistedKeysList(String projectId, String xPhraseAppOTP, Integer page, Integer perPage) throws ApiException {
        ApiResponse<List<BlacklistedKey>> localVarResp = blacklistedKeysListWithHttpInfo(projectId, xPhraseAppOTP, page, perPage);
        return localVarResp.getData();
    }

    /**
     * List blacklisted keys
     * List all rules for blacklisting keys for the given project.
     * @param projectId Project ID (required)
     * @param xPhraseAppOTP Two-Factor-Authentication token (optional) (optional)
     * @param page Page number (optional)
     * @param perPage allows you to specify a page size up to 100 items, 10 by default (optional)
     * @return ApiResponse&lt;List&lt;BlacklistedKey&gt;&gt;
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
    public ApiResponse<List<BlacklistedKey>> blacklistedKeysListWithHttpInfo(String projectId, String xPhraseAppOTP, Integer page, Integer perPage) throws ApiException {
        okhttp3.Call localVarCall = blacklistedKeysListValidateBeforeCall(projectId, xPhraseAppOTP, page, perPage, null);
        Type localVarReturnType = new TypeToken<List<BlacklistedKey>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * List blacklisted keys (asynchronously)
     * List all rules for blacklisting keys for the given project.
     * @param projectId Project ID (required)
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
    public okhttp3.Call blacklistedKeysListAsync(String projectId, String xPhraseAppOTP, Integer page, Integer perPage, final ApiCallback<List<BlacklistedKey>> _callback) throws ApiException {

        okhttp3.Call localVarCall = blacklistedKeysListValidateBeforeCall(projectId, xPhraseAppOTP, page, perPage, _callback);
        Type localVarReturnType = new TypeToken<List<BlacklistedKey>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
