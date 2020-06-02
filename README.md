# phraseJava

Phrase API Reference
- API version: 2.0.0
  - Build date: 2020-06-02T13:24:37.023Z[Etc/UTC]

Phrase is a translation management platform for software projects. You can collaborate on language file translation with your team or order translations through our platform. The API allows you to import locale files, download locale files, tag keys or interact in other ways with the localization data stored in Phrase for your account.

## API Endpoint

```
https://api.phrase.com/v2/
```

The API is only accessible via HTTPS, the base URL is <code>https://api.phrase.com/</code>, and the current version is <code>v2</code> which results in the base URL for all requests: <code>https://api.phrase.com/v2/</code>.

## Usage

[curl](http://curl.haxx.se/) is used primarily to send requests to Phrase in the examples. On most you'll find a second variant using the [Phrase API v2 client](https://phrase.com/cli/) that might be more convenient to handle. For further information check its [documentation](https://help.phrase.com/help/phrase-in-your-terminal).

## Use of HTTP Verbs

Phrase API v2 tries to use the appropriate HTTP verb for accessing each endpoint according to REST specification where possible:

<div class=\"table-responsive\">
  <table class=\"basic-table\">
    <thead>
      <tr class=\"basic-table__row basic-table__row--header\">
        <th class=\"basic-table__cell basic-table__cell--header\">Verb</th>
        <th class=\"basic-table__cell basic-table__cell--header\">Description</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td class=\"basic-table__cell\">GET</td>
        <td class=\"basic-table__cell\">Retrieve one or multiple resources</td>
      </tr>
      <tr>
        <td class=\"basic-table__cell\">POST</td>
        <td class=\"basic-table__cell\">Create a resource</td>
      </tr>
      <tr>
        <td class=\"basic-table__cell\">PUT</td>
        <td class=\"basic-table__cell\">Update a resource</td>
      </tr>
      <tr>
        <td class=\"basic-table__cell\">PATCH</td>
        <td class=\"basic-table__cell\">Update a resource (partially)</td>
      </tr>
      <tr>
        <td class=\"basic-table__cell\">DELETE</td>
        <td class=\"basic-table__cell\">Delete a resource</td>
      </tr>
    </tbody>
  </table>
</div>


## Identification via User-Agent

You must include the User-Agent header with the name of your application or project. It might be a good idea to include some sort of contact information  as well, so that we can get in touch if necessary (e.g. to warn you about Rate-Limiting or badly formed requests). Examples of excellent User-Agent headers:

```
User-Agent: Frederiks Mobile App (frederik@phrase.com)
User-Agent: ACME Inc Python Client (http://example.com/contact)
```

If you don't send this header, you will receive a response with 400 Bad Request.


## Lists

When you request a list of resources, the API will typically only return an array of resources including their most important attributes. For a detailed representation of the resource you should request its detailed representation.

Lists are usually [paginated](#pagination).


## Parameters

Many endpoints support additional parameters, e.g. for pagination. When passing them in a GET request you can send them as HTTP query string parameters:

```
$ curl -u EMAIL_OR_ACCESS_TOKEN \"https://api.phrase.com/v2/projects?page=2\"
```

When performing a POST, PUT, PATCH or DELETE request, we recommend sending parameters that are not already included in the URL, as JSON body:

```
$ curl -H 'Content-Type: application/json' -d '{\"name\":\"My new project\"}' -u EMAIL_OR_ACCESS_TOKEN https://api.phrase.com/v2/projects
```

Encoding parameters as JSON means better support for types (boolean, integer) and usually better readability. Don't forget to set the correct Content-Type for your request.

*The Content-Type header is omitted in some of the following examples for better readbility.*


## Errors


### Request Errors

If a request contains invalid JSON or is missing a required parameter (besides resource attributes), the status `400 Bad Request` is returned:

```
{
  \"message\": \"JSON could not be parsed\"
}
```


### Validation Errors

When the validation for a resource fails, the status `422 Unprocessable Entity` is returned, along with information on the affected fields:

```
{
  \"message\": \"Validation Failed\",
  \"errors\": [
    {
      \"resource\": \"Project\",
      \"field\": \"name\",
      \"message\": \"can't be blank\"
    }
  ]
}
```


## Date Format

Times and dates are returned and expected in [ISO 8601](http://en.wikipedia.org/wiki/ISO_8601) date format:

```
YYYY-MM-DDTHH:MM:SSZ
```

Instead of 'Z' for UTC time zone you can specify your time zone's locale offset using the following notation:

```
YYYY-MM-DDTHH:MM:SS¬±hh:mm
```

Example for CET (1 hour behind UTC):

```
2015-03-31T13:00+01:00
```

Please note that in HTTP headers, we will use the appropriate recommended date formats instead of ISO 8601.


## Authentication

<div class=\"alert alert-info\">For more detailed information on authentication, check out the <a href=\"#authentication\">API v2 Authentication Guide</a>.</div>

There are two different ways to authenticate when performing API requests:

* E-Mail and password
* Oauth Access Token


### E-Mail and password

To get started easily, you can use HTTP Basic authentication with your email and password:

```
$ curl -u username:password \"https://api.phrase.com/v2/projects\"
```


### OAuth via Access Tokens

You can create and manage access tokens in your [profile settings](https://app.phrase.com/settings/oauth_access_tokens) in Translation Center or via the [Authorizations API](#authorizations).

Simply pass the access token as the username of your request:

```
$ curl -u ACCESS_TOKEN: \"https://api.phrase.com/v2/projects\"
```

or send the access token via the `Authorization` header field:

```
$ curl -H \"Authorization: token ACCESS_TOKEN\" https://api.phrase.com/v2/projects
```

For more detailed information on authentication, check out the <a href=\"#authentication\">API v2 Authentication Guide</a>.

#### Send via parameter

As JSONP (and other) requests cannot send HTTP Basic Auth credentials, a special query parameter `access_token` can be used:

```
curl \"https://api.phrase.com/v2/projects?access_token=ACCESS_TOKEN\"
```

You should only use this transport method if sending the authentication via header or Basic authentication is not possible.

### Two-Factor-Authentication

Users with Two-Factor-Authentication enabled have to send a valid token along their request with certain authentication methods (such as Basic authentication). The necessity of a Two-Factor-Authentication token is indicated by the `X-PhraseApp-OTP: required; :MFA-type` header in the response. The `:MFA-type`field indicates the source of the token, e.g. `app` (refers to your Authenticator application):

```
X-PhraseApp-OTP: required; app
```

To provide a Two-Factor-Authentication token you can simply send it in the header of the request:

```
curl -H \"X-PhraseApp-OTP: MFA-TOKEN\" -u EMAIL https://api.phrase.com/v2/projects
```

Since Two-Factor-Authentication tokens usually expire quickly, we recommend using an alternative authentication method such as OAuth access tokens.

### Multiple Accounts

Some endpoints require the account ID to be specified if the authenticated user is a member of multiple accounts. You can find the eight-digit account ID inside <a href=\"https://app.phrase.com/\" target=\"_blank\">Translation Center</a> by switching to the desired account and then visiting the account details page. If required, you can specify the account just like a normal parameter within the request.

## Pagination

Endpoints that return a list or resources will usually return paginated results and include 25 items by default. To access further pages, use the `page` parameter:

```
$ curl -u EMAIL_OR_ACCESS_TOKEN \"https://api.phrase.com/v2/projects?page=2\"
```

Some endpoints also allow a custom page size by using the `per_page` parameter:

```
$ curl -u EMAIL_OR_ACCESS_TOKEN \"https://api.phrase.com/v2/projects?page=2&per_page=50\"
```

Unless specified otherwise in the description of the respective endpoint, `per_page` allows you to specify a page size up to 100 items.


## Link-Headers

We provide you with pagination URLs in the [Link Header field](http://tools.ietf.org/html/rfc5988). Make use of this information to avoid building pagination URLs yourself.

```
Link: <https://api.phrase.com/v2/projects?page=1>; rel=\"first\", <https://api.phrase.com/v2/projects?page=3>; rel=\"prev\", <https://api.phrase.com/v2/projects?page=5>; rel=\"next\", <https://api.phrase.com/v2/projects?page=9>; rel=\"last\"
```

Possible `rel` values are:

<div class=\"table-responsive\">
  <table class=\"basic-table\">
    <thead>
      <tr class=\"basic-table__row basic-table__row--header\">
        <th class=\"basic-table__cell basic-table__cell--header\">Value</th>
        <th class=\"basic-table__cell basic-table__cell--header\">Description</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td class=\"basic-table__cell\">next</td>
        <td class=\"basic-table__cell\">URL of the next page of results</td>
      </tr>
      <tr>
        <td class=\"basic-table__cell\">last</td>
        <td class=\"basic-table__cell\">URL of the last page of results</td>
      </tr>
      <tr>
        <td class=\"basic-table__cell\">first</td>
        <td class=\"basic-table__cell\">URL of the first page of results</td>
      </tr>
      <tr>
        <td class=\"basic-table__cell\">prev</td>
        <td class=\"basic-table__cell\">URL of the previous page of results</td>
      </tr>
    </tbody>
  </table>
</div>

## Rate Limiting

All API endpoints are subject to rate limiting to ensure good performance for all customers. The rate limit is calculated per user:

* 1000 requests per 5 minutes
* 4 concurrent (parallel) requests

For your convenience we send information on the current rate limit within the response headers:

<div class=\"table-responsive\">
  <table class=\"basic-table\">
    <thead>
      <tr class=\"basic-table__row basic-table__row--header\">
        <th class=\"basic-table__cell basic-table__cell--header\">Header</th>
        <th class=\"basic-table__cell basic-table__cell--header\">Description</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td class=\"basic-table__cell\" style=\"white-space: nowrap;\"><code>X-Rate-Limit-Limit</code></td>
        <td class=\"basic-table__cell\">Number of max requests allowed in the current time period</td>
      </tr>
      <tr>
        <td class=\"basic-table__cell\" style=\"white-space: nowrap;\"><code>X-Rate-Limit-Remaining</code></td>
        <td class=\"basic-table__cell\">Number of remaining requests in the current time period</td>
      </tr>
      <tr>
        <td class=\"basic-table__cell\" style=\"white-space: nowrap;\"><code>X-Rate-Limit-Reset</code></td>
        <td class=\"basic-table__cell\">Timestamp of end of current time period as UNIX timestamp</td>
      </tr>
    </tbody>
  </table>
</div>

If you should run into the rate limit, you will receive the HTTP status code `429: Too many requests`.

If you should need higher rate limits, [contact us](https://phrase.com/contact).


## Conditional GET requests / HTTP Caching

<div class=\"alert alert-info\"><p><strong>Note:</strong> Conditional GET requests are currently only supported for <a href=\"#locales_download\">locales#download</a> and <a href=\"#translations_index\">translations#index</a></p></div>

We will return an ETag or Last-Modified header with most GET requests. When you request a resource we recommend to store this value and submit them on subsequent requests as `If-Modified-Since` and `If-None-Match` headers. If the resource has not changed in the meantime, we will return the status `304 Not Modified` instead of rendering and returning the resource again. In most cases this is less time-consuming and makes your application/integration faster.

Please note that all conditional requests that return a response with status 304 don't count against your rate limits.

```
$ curl -i -u EMAIL_OR_ACCESS_TOKEN \"https://api.phrase.com/v2/projects/1234abcd1234abcdefefabcd1234efab/locales/en/download\"
HTTP/1.1 200 OK
ETag: \"abcd1234abcdefefabcd1234efab1234\"
Last-Modified: Wed, 28 Jan 2015 15:31:30 UTC
Status: 200 OK

$ curl -i -u EMAIL_OR_ACCESS_TOKEN \"https://api.phrase.com/v2/projects/1234abcd1234abcdefefabcd1234efab/locales/en/download\" -H 'If-None-Match: \"abcd1234abcdefefabcd1234efab1234\"'
HTTP/1.1 304 Not Modified
ETag: \"abcd1234abcdefefabcd1234efab1234\"
Last-Modified: Wed, 28 Jan 2015 15:31:30 UTC
Status: 304 Not Modified

$ curl -i -u EMAIL_OR_ACCESS_TOKEN \"https://api.phrase.com/v2/projects/1234abcd1234abcdefefabcd1234efab/locales/en/download\" -H \"If-Modified-Since: Wed, 28 Jan 2015 15:31:30 UTC\"
HTTP/1.1 304 Not Modified
Last-Modified: Wed, 28 Jan 2015 15:31:30 UTC
Status: 304 Not Modified
```


## JSONP

The Phrase API supports [JSONP](http://en.wikipedia.org/wiki/JSONP) for all GET requests in order to deal with cross-domain request issues. Just send a `?callback` parameter along with the request to specify the Javascript function name to be called with the response content:

```
$ curl \"https://api.phrase.com/v2/projects?callback=myFunction\"
```

The response will include the normal output for that endpoint, along with a `meta` section including header data:

```
myFunction({
  {
    \"meta\": {
      \"status\": 200,
      ...
    },
    \"data\": [
      {
        \"id\": \"1234abcd1234abc1234abcd1234abc\"
        ...
      }
    ]
  }
});
```

To authenticate a JSONP request, you can send a valid [access token](#authentication) as the `?access_token` parameter along the request:

```
$ curl \"https://api.phrase.com/v2/projects?callback=myFunction&access_token=ACCESS-TOKEN\"
```


  For more information, please visit [https://developers.phrase.com/api/](https://developers.phrase.com/api/)

*Automatically generated by the [OpenAPI Generator](https://openapi-generator.tech)*


## Requirements

Building the API client library requires:
1. Java 1.8+
2. Maven/Gradle

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.phrase</groupId>
  <artifactId>phraseJava</artifactId>
  <version>1.0.0</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "com.phrase:phraseJava:1.0.0"
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/phraseJava-1.0.0.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

// Import classes:
import com.phrase.client.ApiClient;
import com.phrase.client.ApiException;
import com.phrase.client.Configuration;
import com.phrase.client.auth.*;
import com.phrase.client.models.*;
import com.phrase.client.api.AccountsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.phrase.com/v2");
    
    // Configure HTTP basic authorization: Basic
    HttpBasicAuth Basic = (HttpBasicAuth) defaultClient.getAuthentication("Basic");
    Basic.setUsername("YOUR USERNAME");
    Basic.setPassword("YOUR PASSWORD");

    // Configure API key authorization: Token
    ApiKeyAuth Token = (ApiKeyAuth) defaultClient.getAuthentication("Token");
    Token.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //Token.setApiKeyPrefix("Token");

    AccountsApi apiInstance = new AccountsApi(defaultClient);
    String id = "id_example"; // String | ID
    String xPhraseAppOTP = "xPhraseAppOTP_example"; // String | Two-Factor-Authentication token (optional)
    try {
      AccountDetails result = apiInstance.accountShow(id, xPhraseAppOTP);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AccountsApi#accountShow");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://api.phrase.com/v2*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AccountsApi* | [**accountShow**](docs/AccountsApi.md#accountShow) | **GET** /accounts/{id} | Get a single account
*AccountsApi* | [**accountsList**](docs/AccountsApi.md#accountsList) | **GET** /accounts | List accounts
*AuthorizationsApi* | [**authorizationCreate**](docs/AuthorizationsApi.md#authorizationCreate) | **POST** /authorizations | Create an authorization
*AuthorizationsApi* | [**authorizationDelete**](docs/AuthorizationsApi.md#authorizationDelete) | **DELETE** /authorizations/{id} | Delete an authorization
*AuthorizationsApi* | [**authorizationShow**](docs/AuthorizationsApi.md#authorizationShow) | **GET** /authorizations/{id} | Get a single authorization
*AuthorizationsApi* | [**authorizationUpdate**](docs/AuthorizationsApi.md#authorizationUpdate) | **PATCH** /authorizations/{id} | Update an authorization
*AuthorizationsApi* | [**authorizationsList**](docs/AuthorizationsApi.md#authorizationsList) | **GET** /authorizations | List authorizations
*BitbucketSyncApi* | [**bitbucketSyncExport**](docs/BitbucketSyncApi.md#bitbucketSyncExport) | **POST** /bitbucket_syncs/{id}/export | Export from Phrase to Bitbucket
*BitbucketSyncApi* | [**bitbucketSyncImport**](docs/BitbucketSyncApi.md#bitbucketSyncImport) | **POST** /bitbucket_syncs/{id}/import | Import to Phrase from Bitbucket
*BitbucketSyncApi* | [**bitbucketSyncsList**](docs/BitbucketSyncApi.md#bitbucketSyncsList) | **GET** /bitbucket_syncs | List Bitbucket syncs
*BlacklistedKeysApi* | [**blacklistedKeyCreate**](docs/BlacklistedKeysApi.md#blacklistedKeyCreate) | **POST** /projects/{project_id}/blacklisted_keys | Create a blacklisted key
*BlacklistedKeysApi* | [**blacklistedKeyDelete**](docs/BlacklistedKeysApi.md#blacklistedKeyDelete) | **DELETE** /projects/{project_id}/blacklisted_keys/{id} | Delete a blacklisted key
*BlacklistedKeysApi* | [**blacklistedKeyShow**](docs/BlacklistedKeysApi.md#blacklistedKeyShow) | **GET** /projects/{project_id}/blacklisted_keys/{id} | Get a single blacklisted key
*BlacklistedKeysApi* | [**blacklistedKeyUpdate**](docs/BlacklistedKeysApi.md#blacklistedKeyUpdate) | **PATCH** /projects/{project_id}/blacklisted_keys/{id} | Update a blacklisted key
*BlacklistedKeysApi* | [**blacklistedKeysList**](docs/BlacklistedKeysApi.md#blacklistedKeysList) | **GET** /projects/{project_id}/blacklisted_keys | List blacklisted keys
*BranchesApi* | [**branchCompare**](docs/BranchesApi.md#branchCompare) | **GET** /projects/{project_id}/branches/{name}/compare | Compare branches
*BranchesApi* | [**branchCreate**](docs/BranchesApi.md#branchCreate) | **POST** /projects/{project_id}/branches | Create a branch
*BranchesApi* | [**branchDelete**](docs/BranchesApi.md#branchDelete) | **DELETE** /projects/{project_id}/branches/{name} | Delete a branch
*BranchesApi* | [**branchMerge**](docs/BranchesApi.md#branchMerge) | **PATCH** /projects/{project_id}/branches/{name}/merge | Merge a branch
*BranchesApi* | [**branchShow**](docs/BranchesApi.md#branchShow) | **GET** /projects/{project_id}/branches/{name} | Get a single branch
*BranchesApi* | [**branchUpdate**](docs/BranchesApi.md#branchUpdate) | **PATCH** /projects/{project_id}/branches/{name} | Update a branch
*BranchesApi* | [**branchesList**](docs/BranchesApi.md#branchesList) | **GET** /projects/{project_id}/branches | List branches
*CommentsApi* | [**commentCreate**](docs/CommentsApi.md#commentCreate) | **POST** /projects/{project_id}/keys/{key_id}/comments | Create a comment
*CommentsApi* | [**commentDelete**](docs/CommentsApi.md#commentDelete) | **DELETE** /projects/{project_id}/keys/{key_id}/comments/{id} | Delete a comment
*CommentsApi* | [**commentMarkCheck**](docs/CommentsApi.md#commentMarkCheck) | **GET** /projects/{project_id}/keys/{key_id}/comments/{id}/read | Check if comment is read
*CommentsApi* | [**commentMarkRead**](docs/CommentsApi.md#commentMarkRead) | **PATCH** /projects/{project_id}/keys/{key_id}/comments/{id}/read | Mark a comment as read
*CommentsApi* | [**commentMarkUnread**](docs/CommentsApi.md#commentMarkUnread) | **DELETE** /projects/{project_id}/keys/{key_id}/comments/{id}/read | Mark a comment as unread
*CommentsApi* | [**commentShow**](docs/CommentsApi.md#commentShow) | **GET** /projects/{project_id}/keys/{key_id}/comments/{id} | Get a single comment
*CommentsApi* | [**commentUpdate**](docs/CommentsApi.md#commentUpdate) | **PATCH** /projects/{project_id}/keys/{key_id}/comments/{id} | Update a comment
*CommentsApi* | [**commentsList**](docs/CommentsApi.md#commentsList) | **GET** /projects/{project_id}/keys/{key_id}/comments | List comments
*DistributionsApi* | [**distributionCreate**](docs/DistributionsApi.md#distributionCreate) | **POST** /accounts/{account_id}/distributions | Create a distribution
*DistributionsApi* | [**distributionDelete**](docs/DistributionsApi.md#distributionDelete) | **DELETE** /accounts/{account_id}/distributions/{id} | Delete a distribution
*DistributionsApi* | [**distributionShow**](docs/DistributionsApi.md#distributionShow) | **GET** /accounts/{account_id}/distributions/{id} | Get a single distribution
*DistributionsApi* | [**distributionUpdate**](docs/DistributionsApi.md#distributionUpdate) | **PATCH** /accounts/{account_id}/distributions/{id} | Update a distribution
*DistributionsApi* | [**distributionsList**](docs/DistributionsApi.md#distributionsList) | **GET** /accounts/{account_id}/distributions | List distributions
*FormatsApi* | [**formatsList**](docs/FormatsApi.md#formatsList) | **GET** /formats | List formats
*GitLabSyncApi* | [**gitlabSyncDelete**](docs/GitLabSyncApi.md#gitlabSyncDelete) | **DELETE** /gitlab_syncs/{id} | Delete single Sync Setting
*GitLabSyncApi* | [**gitlabSyncExport**](docs/GitLabSyncApi.md#gitlabSyncExport) | **POST** /gitlab_syncs/{gitlab_sync_id}/export | Export from Phrase to GitLab
*GitLabSyncApi* | [**gitlabSyncHistory**](docs/GitLabSyncApi.md#gitlabSyncHistory) | **GET** /gitlab_syncs/{gitlab_sync_id}/history | History of single Sync Setting
*GitLabSyncApi* | [**gitlabSyncImport**](docs/GitLabSyncApi.md#gitlabSyncImport) | **POST** /gitlab_syncs/{gitlab_sync_id}/import | Import from GitLab to Phrase
*GitLabSyncApi* | [**gitlabSyncList**](docs/GitLabSyncApi.md#gitlabSyncList) | **GET** /gitlab_syncs | List GitLab syncs
*GitLabSyncApi* | [**gitlabSyncShow**](docs/GitLabSyncApi.md#gitlabSyncShow) | **GET** /gitlab_syncs/{id} | Get single Sync Setting
*GitLabSyncApi* | [**gitlabSyncUpdate**](docs/GitLabSyncApi.md#gitlabSyncUpdate) | **PUT** /gitlab_syncs/{id} | Update single Sync Setting
*GlossaryApi* | [**glossariesList**](docs/GlossaryApi.md#glossariesList) | **GET** /accounts/{account_id}/glossaries | List glossaries
*GlossaryApi* | [**glossaryCreate**](docs/GlossaryApi.md#glossaryCreate) | **POST** /accounts/{account_id}/glossaries | Create a glossary
*GlossaryApi* | [**glossaryDelete**](docs/GlossaryApi.md#glossaryDelete) | **DELETE** /accounts/{account_id}/glossaries/{id} | Delete a glossary
*GlossaryApi* | [**glossaryShow**](docs/GlossaryApi.md#glossaryShow) | **GET** /accounts/{account_id}/glossaries/{id} | Get a single glossary
*GlossaryApi* | [**glossaryUpdate**](docs/GlossaryApi.md#glossaryUpdate) | **PATCH** /accounts/{account_id}/glossaries/{id} | Update a glossary
*GlossaryTermTranslationsApi* | [**glossaryTermTranslationCreate**](docs/GlossaryTermTranslationsApi.md#glossaryTermTranslationCreate) | **POST** /accounts/{account_id}/glossaries/{glossary_id}/terms/{term_id}/translations | Create a glossary term translation
*GlossaryTermTranslationsApi* | [**glossaryTermTranslationDelete**](docs/GlossaryTermTranslationsApi.md#glossaryTermTranslationDelete) | **DELETE** /accounts/{account_id}/glossaries/{glossary_id}/terms/{term_id}/translations/{id} | Delete a glossary term translation
*GlossaryTermTranslationsApi* | [**glossaryTermTranslationUpdate**](docs/GlossaryTermTranslationsApi.md#glossaryTermTranslationUpdate) | **PATCH** /accounts/{account_id}/glossaries/{glossary_id}/terms/{term_id}/translations/{id} | Update a glossary term translation
*GlossaryTermsApi* | [**glossaryTermCreate**](docs/GlossaryTermsApi.md#glossaryTermCreate) | **POST** /accounts/{account_id}/glossaries/{glossary_id}/terms | Create a glossary term
*GlossaryTermsApi* | [**glossaryTermDelete**](docs/GlossaryTermsApi.md#glossaryTermDelete) | **DELETE** /accounts/{account_id}/glossaries/{glossary_id}/terms/{id} | Delete a glossary term
*GlossaryTermsApi* | [**glossaryTermShow**](docs/GlossaryTermsApi.md#glossaryTermShow) | **GET** /accounts/{account_id}/glossaries/{glossary_id}/terms/{id} | Get a single glossary term
*GlossaryTermsApi* | [**glossaryTermUpdate**](docs/GlossaryTermsApi.md#glossaryTermUpdate) | **PATCH** /accounts/{account_id}/glossaries/{glossary_id}/terms/{id} | Update a glossary term
*GlossaryTermsApi* | [**glossaryTermsList**](docs/GlossaryTermsApi.md#glossaryTermsList) | **GET** /accounts/{account_id}/glossaries/{glossary_id}/terms | List glossary terms
*InvitationsApi* | [**invitationCreate**](docs/InvitationsApi.md#invitationCreate) | **POST** /accounts/{account_id}/invitations | Create a new invitation
*InvitationsApi* | [**invitationDelete**](docs/InvitationsApi.md#invitationDelete) | **DELETE** /accounts/{account_id}/invitations/{id} | Delete an invitation
*InvitationsApi* | [**invitationResend**](docs/InvitationsApi.md#invitationResend) | **POST** /accounts/{account_id}/invitations/{id}/resend | Resend an invitation
*InvitationsApi* | [**invitationShow**](docs/InvitationsApi.md#invitationShow) | **GET** /accounts/{account_id}/invitations/{id} | Get a single invitation
*InvitationsApi* | [**invitationUpdate**](docs/InvitationsApi.md#invitationUpdate) | **PATCH** /accounts/{account_id}/invitations/{id} | Update an invitation
*InvitationsApi* | [**invitationsList**](docs/InvitationsApi.md#invitationsList) | **GET** /accounts/{account_id}/invitations | List invitations
*JobLocalesApi* | [**jobLocaleComplete**](docs/JobLocalesApi.md#jobLocaleComplete) | **POST** /projects/{project_id}/jobs/{job_id}/locales/{id}/complete | Complete a job locale
*JobLocalesApi* | [**jobLocaleDelete**](docs/JobLocalesApi.md#jobLocaleDelete) | **DELETE** /projects/{project_id}/jobs/{job_id}/locales/{id} | Delete a job locale
*JobLocalesApi* | [**jobLocaleReopen**](docs/JobLocalesApi.md#jobLocaleReopen) | **POST** /projects/{project_id}/jobs/{job_id}/locales/{id}/reopen | Reopen a job locale
*JobLocalesApi* | [**jobLocaleShow**](docs/JobLocalesApi.md#jobLocaleShow) | **GET** /projects/{project_id}/jobs/{job_id}/locale/{id} | Get a single job locale
*JobLocalesApi* | [**jobLocaleUpdate**](docs/JobLocalesApi.md#jobLocaleUpdate) | **PATCH** /projects/{project_id}/jobs/{job_id}/locales/{id} | Update a job locale
*JobLocalesApi* | [**jobLocalesCreate**](docs/JobLocalesApi.md#jobLocalesCreate) | **POST** /projects/{project_id}/jobs/{job_id}/locales | Create a job locale
*JobLocalesApi* | [**jobLocalesList**](docs/JobLocalesApi.md#jobLocalesList) | **GET** /projects/{project_id}/jobs/{job_id}/locales | List job locales
*JobsApi* | [**jobComplete**](docs/JobsApi.md#jobComplete) | **POST** /projects/{project_id}/jobs/{id}/complete | Complete a job
*JobsApi* | [**jobCreate**](docs/JobsApi.md#jobCreate) | **POST** /projects/{project_id}/jobs | Create a job
*JobsApi* | [**jobDelete**](docs/JobsApi.md#jobDelete) | **DELETE** /projects/{project_id}/jobs/{id} | Delete a job
*JobsApi* | [**jobKeysCreate**](docs/JobsApi.md#jobKeysCreate) | **POST** /projects/{project_id}/jobs/{id}/keys | Add keys to job
*JobsApi* | [**jobKeysDelete**](docs/JobsApi.md#jobKeysDelete) | **DELETE** /projects/{project_id}/jobs/{id}/keys | Remove keys from job
*JobsApi* | [**jobReopen**](docs/JobsApi.md#jobReopen) | **POST** /projects/{project_id}/jobs/{id}/reopen | Reopen a job
*JobsApi* | [**jobShow**](docs/JobsApi.md#jobShow) | **GET** /projects/{project_id}/jobs/{id} | Get a single job
*JobsApi* | [**jobStart**](docs/JobsApi.md#jobStart) | **POST** /projects/{project_id}/jobs/{id}/start | Start a job
*JobsApi* | [**jobUpdate**](docs/JobsApi.md#jobUpdate) | **PATCH** /projects/{project_id}/jobs/{id} | Update a job
*JobsApi* | [**jobsList**](docs/JobsApi.md#jobsList) | **GET** /projects/{project_id}/jobs | List jobs
*KeysApi* | [**keyCreate**](docs/KeysApi.md#keyCreate) | **POST** /projects/{project_id}/keys | Create a key
*KeysApi* | [**keyDelete**](docs/KeysApi.md#keyDelete) | **DELETE** /projects/{project_id}/keys/{id} | Delete a key
*KeysApi* | [**keyShow**](docs/KeysApi.md#keyShow) | **GET** /projects/{project_id}/keys/{id} | Get a single key
*KeysApi* | [**keyUpdate**](docs/KeysApi.md#keyUpdate) | **PATCH** /projects/{project_id}/keys/{id} | Update a key
*KeysApi* | [**keysDelete**](docs/KeysApi.md#keysDelete) | **DELETE** /projects/{project_id}/keys | Delete collection of keys
*KeysApi* | [**keysList**](docs/KeysApi.md#keysList) | **GET** /projects/{project_id}/keys | List keys
*KeysApi* | [**keysSearch**](docs/KeysApi.md#keysSearch) | **POST** /projects/{project_id}/keys/search | Search keys
*KeysApi* | [**keysTag**](docs/KeysApi.md#keysTag) | **PATCH** /projects/{project_id}/keys/tag | Add tags to collection of keys
*KeysApi* | [**keysUntag**](docs/KeysApi.md#keysUntag) | **PATCH** /projects/{project_id}/keys/untag | Remove tags from collection of keys
*LocalesApi* | [**localeCreate**](docs/LocalesApi.md#localeCreate) | **POST** /projects/{project_id}/locales | Create a locale
*LocalesApi* | [**localeDelete**](docs/LocalesApi.md#localeDelete) | **DELETE** /projects/{project_id}/locales/{id} | Delete a locale
*LocalesApi* | [**localeDownload**](docs/LocalesApi.md#localeDownload) | **GET** /projects/{project_id}/locales/{id}/download | Download a locale
*LocalesApi* | [**localeShow**](docs/LocalesApi.md#localeShow) | **GET** /projects/{project_id}/locales/{id} | Get a single locale
*LocalesApi* | [**localeUpdate**](docs/LocalesApi.md#localeUpdate) | **PATCH** /projects/{project_id}/locales/{id} | Update a locale
*LocalesApi* | [**localesList**](docs/LocalesApi.md#localesList) | **GET** /projects/{project_id}/locales | List locales
*MembersApi* | [**memberDelete**](docs/MembersApi.md#memberDelete) | **DELETE** /accounts/{account_id}/members/{id} | Remove a user from the account
*MembersApi* | [**memberShow**](docs/MembersApi.md#memberShow) | **GET** /accounts/{account_id}/members/{id} | Get single member
*MembersApi* | [**memberUpdate**](docs/MembersApi.md#memberUpdate) | **PATCH** /accounts/{account_id}/members/{id} | Update a member
*MembersApi* | [**membersList**](docs/MembersApi.md#membersList) | **GET** /accounts/{account_id}/members | List members
*OrdersApi* | [**orderConfirm**](docs/OrdersApi.md#orderConfirm) | **PATCH** /projects/{project_id}/orders/{id}/confirm | Confirm an order
*OrdersApi* | [**orderCreate**](docs/OrdersApi.md#orderCreate) | **POST** /projects/{project_id}/orders | Create a new order
*OrdersApi* | [**orderDelete**](docs/OrdersApi.md#orderDelete) | **DELETE** /projects/{project_id}/orders/{id} | Cancel an order
*OrdersApi* | [**orderShow**](docs/OrdersApi.md#orderShow) | **GET** /projects/{project_id}/orders/{id} | Get a single order
*OrdersApi* | [**ordersList**](docs/OrdersApi.md#ordersList) | **GET** /projects/{project_id}/orders | List orders
*ProjectsApi* | [**projectCreate**](docs/ProjectsApi.md#projectCreate) | **POST** /projects | Create a project
*ProjectsApi* | [**projectDelete**](docs/ProjectsApi.md#projectDelete) | **DELETE** /projects/{id} | Delete a project
*ProjectsApi* | [**projectShow**](docs/ProjectsApi.md#projectShow) | **GET** /projects/{id} | Get a single project
*ProjectsApi* | [**projectUpdate**](docs/ProjectsApi.md#projectUpdate) | **PATCH** /projects/{id} | Update a project
*ProjectsApi* | [**projectsList**](docs/ProjectsApi.md#projectsList) | **GET** /projects | List projects
*ReleasesApi* | [**releaseCreate**](docs/ReleasesApi.md#releaseCreate) | **POST** /accounts/{account_id}/distributions/{distribution_id}/releases | Create a release
*ReleasesApi* | [**releaseDelete**](docs/ReleasesApi.md#releaseDelete) | **DELETE** /accounts/{account_id}/distributions/{distribution_id}/releases/{id} | Delete a release
*ReleasesApi* | [**releasePublish**](docs/ReleasesApi.md#releasePublish) | **POST** /accounts/{account_id}/distributions/{distribution_id}/releases/{id}/publish | Publish a release
*ReleasesApi* | [**releaseShow**](docs/ReleasesApi.md#releaseShow) | **GET** /accounts/{account_id}/distributions/{distribution_id}/releases/{id} | Get a single release
*ReleasesApi* | [**releaseUpdate**](docs/ReleasesApi.md#releaseUpdate) | **PATCH** /accounts/{account_id}/distributions/{distribution_id}/releases/{id} | Update a release
*ReleasesApi* | [**releasesList**](docs/ReleasesApi.md#releasesList) | **GET** /accounts/{account_id}/distributions/{distribution_id}/releases | List releases
*ScreenshotMarkersApi* | [**screenshotMarkerCreate**](docs/ScreenshotMarkersApi.md#screenshotMarkerCreate) | **POST** /projects/{project_id}/screenshots/{screenshot_id}/markers | Create a screenshot marker
*ScreenshotMarkersApi* | [**screenshotMarkerDelete**](docs/ScreenshotMarkersApi.md#screenshotMarkerDelete) | **DELETE** /projects/{project_id}/screenshots/{screenshot_id}/markers | Delete a screenshot marker
*ScreenshotMarkersApi* | [**screenshotMarkerShow**](docs/ScreenshotMarkersApi.md#screenshotMarkerShow) | **GET** /projects/{project_id}/screenshots/{screenshot_id}/markers/{id} | Get a single screenshot marker
*ScreenshotMarkersApi* | [**screenshotMarkerUpdate**](docs/ScreenshotMarkersApi.md#screenshotMarkerUpdate) | **PATCH** /projects/{project_id}/screenshots/{screenshot_id}/markers | Update a screenshot marker
*ScreenshotMarkersApi* | [**screenshotMarkersList**](docs/ScreenshotMarkersApi.md#screenshotMarkersList) | **GET** /projects/{project_id}/screenshots/{id}/markers | List screenshot markers
*ScreenshotsApi* | [**screenshotCreate**](docs/ScreenshotsApi.md#screenshotCreate) | **POST** /projects/{project_id}/screenshots | Create a screenshot
*ScreenshotsApi* | [**screenshotDelete**](docs/ScreenshotsApi.md#screenshotDelete) | **DELETE** /projects/{project_id}/screenshots/{id} | Delete a screenshot
*ScreenshotsApi* | [**screenshotShow**](docs/ScreenshotsApi.md#screenshotShow) | **GET** /projects/{project_id}/screenshots/{id} | Get a single screenshot
*ScreenshotsApi* | [**screenshotUpdate**](docs/ScreenshotsApi.md#screenshotUpdate) | **PATCH** /projects/{project_id}/screenshots/{id} | Update a screenshot
*ScreenshotsApi* | [**screenshotsList**](docs/ScreenshotsApi.md#screenshotsList) | **GET** /projects/{project_id}/screenshots | List screenshots
*SpacesApi* | [**spaceCreate**](docs/SpacesApi.md#spaceCreate) | **POST** /accounts/{account_id}/spaces | Create a Space
*SpacesApi* | [**spaceDelete**](docs/SpacesApi.md#spaceDelete) | **DELETE** /accounts/{account_id}/spaces/{id} | Delete Space
*SpacesApi* | [**spaceShow**](docs/SpacesApi.md#spaceShow) | **GET** /accounts/{account_id}/spaces/{id} | Get Space
*SpacesApi* | [**spaceUpdate**](docs/SpacesApi.md#spaceUpdate) | **PATCH** /accounts/{account_id}/spaces/{id} | Update Space
*SpacesApi* | [**spacesList**](docs/SpacesApi.md#spacesList) | **GET** /accounts/{account_id}/spaces | List Spaces
*SpacesApi* | [**spacesProjectsCreate**](docs/SpacesApi.md#spacesProjectsCreate) | **POST** /accounts/{account_id}/spaces/{space_id}/projects | Add Project
*SpacesApi* | [**spacesProjectsDelete**](docs/SpacesApi.md#spacesProjectsDelete) | **DELETE** /accounts/{account_id}/spaces/{space_id}/projects/{id} | Remove Project
*SpacesApi* | [**spacesProjectsList**](docs/SpacesApi.md#spacesProjectsList) | **GET** /accounts/{account_id}/spaces/{space_id}/projects | List Projects
*StyleGuidesApi* | [**styleguideCreate**](docs/StyleGuidesApi.md#styleguideCreate) | **POST** /projects/{project_id}/styleguides | Create a style guide
*StyleGuidesApi* | [**styleguideDelete**](docs/StyleGuidesApi.md#styleguideDelete) | **DELETE** /projects/{project_id}/styleguides/{id} | Delete a style guide
*StyleGuidesApi* | [**styleguideShow**](docs/StyleGuidesApi.md#styleguideShow) | **GET** /projects/{project_id}/styleguides/{id} | Get a single style guide
*StyleGuidesApi* | [**styleguideUpdate**](docs/StyleGuidesApi.md#styleguideUpdate) | **PATCH** /projects/{project_id}/styleguides/{id} | Update a style guide
*StyleGuidesApi* | [**styleguidesList**](docs/StyleGuidesApi.md#styleguidesList) | **GET** /projects/{project_id}/styleguides | List style guides
*TagsApi* | [**tagCreate**](docs/TagsApi.md#tagCreate) | **POST** /projects/{project_id}/tags | Create a tag
*TagsApi* | [**tagDelete**](docs/TagsApi.md#tagDelete) | **DELETE** /projects/{project_id}/tags/{name} | Delete a tag
*TagsApi* | [**tagShow**](docs/TagsApi.md#tagShow) | **GET** /projects/{project_id}/tags/{name} | Get a single tag
*TagsApi* | [**tagsList**](docs/TagsApi.md#tagsList) | **GET** /projects/{project_id}/tags | List tags
*TranslationsApi* | [**translationCreate**](docs/TranslationsApi.md#translationCreate) | **POST** /projects/{project_id}/translations | Create a translation
*TranslationsApi* | [**translationExclude**](docs/TranslationsApi.md#translationExclude) | **PATCH** /projects/{project_id}/translations/{id}/exclude | Exclude a translation from export
*TranslationsApi* | [**translationInclude**](docs/TranslationsApi.md#translationInclude) | **PATCH** /projects/{project_id}/translations/{id}/include | Revoke exclusion of a translation in export
*TranslationsApi* | [**translationReview**](docs/TranslationsApi.md#translationReview) | **PATCH** /projects/{project_id}/translations/{id}/review | Review a translation
*TranslationsApi* | [**translationShow**](docs/TranslationsApi.md#translationShow) | **GET** /projects/{project_id}/translations/{id} | Get a single translation
*TranslationsApi* | [**translationUnverify**](docs/TranslationsApi.md#translationUnverify) | **PATCH** /projects/{project_id}/translations/{id}/unverify | Mark a translation as unverified
*TranslationsApi* | [**translationUpdate**](docs/TranslationsApi.md#translationUpdate) | **PATCH** /projects/{project_id}/translations/{id} | Update a translation
*TranslationsApi* | [**translationVerify**](docs/TranslationsApi.md#translationVerify) | **PATCH** /projects/{project_id}/translations/{id}/verify | Verify a translation
*TranslationsApi* | [**translationsByKey**](docs/TranslationsApi.md#translationsByKey) | **GET** /projects/{project_id}/keys/{key_id}/translations | List translations by key
*TranslationsApi* | [**translationsByLocale**](docs/TranslationsApi.md#translationsByLocale) | **GET** /projects/{project_id}/locales/{locale_id}/translations | List translations by locale
*TranslationsApi* | [**translationsExclude**](docs/TranslationsApi.md#translationsExclude) | **PATCH** /projects/{project_id}/translations/exclude | Set exclude from export flag on translations selected by query
*TranslationsApi* | [**translationsInclude**](docs/TranslationsApi.md#translationsInclude) | **PATCH** /projects/{project_id}/translations/include | Remove exlude from import flag from translations selected by query
*TranslationsApi* | [**translationsList**](docs/TranslationsApi.md#translationsList) | **GET** /projects/{project_id}/translations | List all translations
*TranslationsApi* | [**translationsReview**](docs/TranslationsApi.md#translationsReview) | **PATCH** /projects/{project_id}/translations/review | Review translations selected by query
*TranslationsApi* | [**translationsSearch**](docs/TranslationsApi.md#translationsSearch) | **POST** /projects/{project_id}/translations/search | Search translations
*TranslationsApi* | [**translationsUnverify**](docs/TranslationsApi.md#translationsUnverify) | **PATCH** /projects/{project_id}/translations/unverify | Mark translations selected by query as unverified
*TranslationsApi* | [**translationsVerify**](docs/TranslationsApi.md#translationsVerify) | **PATCH** /projects/{project_id}/translations/verify | Verify translations selected by query
*UploadsApi* | [**uploadCreate**](docs/UploadsApi.md#uploadCreate) | **POST** /projects/{project_id}/uploads | Upload a new file
*UploadsApi* | [**uploadShow**](docs/UploadsApi.md#uploadShow) | **GET** /projects/{project_id}/uploads/{id} | View upload details
*UploadsApi* | [**uploadsList**](docs/UploadsApi.md#uploadsList) | **GET** /projects/{project_id}/uploads | List uploads
*UsersApi* | [**showUser**](docs/UsersApi.md#showUser) | **GET** /user | Show current User
*VersionsHistoryApi* | [**versionShow**](docs/VersionsHistoryApi.md#versionShow) | **GET** /projects/{project_id}/translations/{translation_id}/versions/{id} | Get a single version
*VersionsHistoryApi* | [**versionsList**](docs/VersionsHistoryApi.md#versionsList) | **GET** /projects/{project_id}/translations/{translation_id}/versions | List all versions
*WebhooksApi* | [**webhookCreate**](docs/WebhooksApi.md#webhookCreate) | **POST** /projects/{project_id}/webhooks | Create a webhook
*WebhooksApi* | [**webhookDelete**](docs/WebhooksApi.md#webhookDelete) | **DELETE** /projects/{project_id}/webhooks/{id} | Delete a webhook
*WebhooksApi* | [**webhookShow**](docs/WebhooksApi.md#webhookShow) | **GET** /projects/{project_id}/webhooks/{id} | Get a single webhook
*WebhooksApi* | [**webhookTest**](docs/WebhooksApi.md#webhookTest) | **POST** /projects/{project_id}/webhooks/{id}/test | Test a webhook
*WebhooksApi* | [**webhookUpdate**](docs/WebhooksApi.md#webhookUpdate) | **PATCH** /projects/{project_id}/webhooks/{id} | Update a webhook
*WebhooksApi* | [**webhooksList**](docs/WebhooksApi.md#webhooksList) | **GET** /projects/{project_id}/webhooks | List webhooks


## Documentation for Models

 - [Account](docs/Account.md)
 - [AccountDetails](docs/AccountDetails.md)
 - [AccountDetails1](docs/AccountDetails1.md)
 - [AffectedCount](docs/AffectedCount.md)
 - [AffectedResources](docs/AffectedResources.md)
 - [Authorization](docs/Authorization.md)
 - [AuthorizationCreateParameters](docs/AuthorizationCreateParameters.md)
 - [AuthorizationUpdateParameters](docs/AuthorizationUpdateParameters.md)
 - [AuthorizationWithToken](docs/AuthorizationWithToken.md)
 - [AuthorizationWithToken1](docs/AuthorizationWithToken1.md)
 - [BitbucketSync](docs/BitbucketSync.md)
 - [BitbucketSyncExportParameters](docs/BitbucketSyncExportParameters.md)
 - [BitbucketSyncExportResponse](docs/BitbucketSyncExportResponse.md)
 - [BitbucketSyncImportParameters](docs/BitbucketSyncImportParameters.md)
 - [BlacklistedKey](docs/BlacklistedKey.md)
 - [BlacklistedKeyCreateParameters](docs/BlacklistedKeyCreateParameters.md)
 - [BlacklistedKeyUpdateParameters](docs/BlacklistedKeyUpdateParameters.md)
 - [Branch](docs/Branch.md)
 - [BranchCreateParameters](docs/BranchCreateParameters.md)
 - [BranchMergeParameters](docs/BranchMergeParameters.md)
 - [BranchUpdateParameters](docs/BranchUpdateParameters.md)
 - [Comment](docs/Comment.md)
 - [CommentCreateParameters](docs/CommentCreateParameters.md)
 - [CommentMarkReadParameters](docs/CommentMarkReadParameters.md)
 - [CommentUpdateParameters](docs/CommentUpdateParameters.md)
 - [Distribution](docs/Distribution.md)
 - [DistributionCreateParameters](docs/DistributionCreateParameters.md)
 - [DistributionPreview](docs/DistributionPreview.md)
 - [DistributionUpdateParameters](docs/DistributionUpdateParameters.md)
 - [Format](docs/Format.md)
 - [GitlabSync](docs/GitlabSync.md)
 - [GitlabSyncExport](docs/GitlabSyncExport.md)
 - [GitlabSyncExportParameters](docs/GitlabSyncExportParameters.md)
 - [GitlabSyncHistory](docs/GitlabSyncHistory.md)
 - [GitlabSyncImportParameters](docs/GitlabSyncImportParameters.md)
 - [Glossary](docs/Glossary.md)
 - [GlossaryCreateParameters](docs/GlossaryCreateParameters.md)
 - [GlossaryTerm](docs/GlossaryTerm.md)
 - [GlossaryTermCreateParameters](docs/GlossaryTermCreateParameters.md)
 - [GlossaryTermTranslation](docs/GlossaryTermTranslation.md)
 - [GlossaryTermTranslationCreateParameters](docs/GlossaryTermTranslationCreateParameters.md)
 - [GlossaryTermTranslationUpdateParameters](docs/GlossaryTermTranslationUpdateParameters.md)
 - [GlossaryTermUpdateParameters](docs/GlossaryTermUpdateParameters.md)
 - [GlossaryUpdateParameters](docs/GlossaryUpdateParameters.md)
 - [Invitation](docs/Invitation.md)
 - [InvitationCreateParameters](docs/InvitationCreateParameters.md)
 - [InvitationUpdateParameters](docs/InvitationUpdateParameters.md)
 - [Job](docs/Job.md)
 - [JobCompleteParameters](docs/JobCompleteParameters.md)
 - [JobCreateParameters](docs/JobCreateParameters.md)
 - [JobDetails](docs/JobDetails.md)
 - [JobDetails1](docs/JobDetails1.md)
 - [JobKeysCreateParameters](docs/JobKeysCreateParameters.md)
 - [JobLocale](docs/JobLocale.md)
 - [JobLocaleCompleteParameters](docs/JobLocaleCompleteParameters.md)
 - [JobLocaleReopenParameters](docs/JobLocaleReopenParameters.md)
 - [JobLocaleUpdateParameters](docs/JobLocaleUpdateParameters.md)
 - [JobLocalesCreateParameters](docs/JobLocalesCreateParameters.md)
 - [JobPreview](docs/JobPreview.md)
 - [JobReopenParameters](docs/JobReopenParameters.md)
 - [JobStartParameters](docs/JobStartParameters.md)
 - [JobUpdateParameters](docs/JobUpdateParameters.md)
 - [KeyCreateParameters](docs/KeyCreateParameters.md)
 - [KeyPreview](docs/KeyPreview.md)
 - [KeyUpdateParameters](docs/KeyUpdateParameters.md)
 - [KeysSearchParameters](docs/KeysSearchParameters.md)
 - [KeysTagParameters](docs/KeysTagParameters.md)
 - [KeysUntagParameters](docs/KeysUntagParameters.md)
 - [Locale](docs/Locale.md)
 - [LocaleCreateParameters](docs/LocaleCreateParameters.md)
 - [LocaleDetails](docs/LocaleDetails.md)
 - [LocaleDetails1](docs/LocaleDetails1.md)
 - [LocalePreview](docs/LocalePreview.md)
 - [LocaleStatistics](docs/LocaleStatistics.md)
 - [LocaleUpdateParameters](docs/LocaleUpdateParameters.md)
 - [Member](docs/Member.md)
 - [MemberUpdateParameters](docs/MemberUpdateParameters.md)
 - [OrderConfirmParameters](docs/OrderConfirmParameters.md)
 - [OrderCreateParameters](docs/OrderCreateParameters.md)
 - [Project](docs/Project.md)
 - [ProjectCreateParameters](docs/ProjectCreateParameters.md)
 - [ProjectDetails](docs/ProjectDetails.md)
 - [ProjectDetails1](docs/ProjectDetails1.md)
 - [ProjectLocales](docs/ProjectLocales.md)
 - [ProjectLocales1](docs/ProjectLocales1.md)
 - [ProjectShort](docs/ProjectShort.md)
 - [ProjectUpdateParameters](docs/ProjectUpdateParameters.md)
 - [Release](docs/Release.md)
 - [ReleaseCreateParameters](docs/ReleaseCreateParameters.md)
 - [ReleasePreview](docs/ReleasePreview.md)
 - [ReleaseUpdateParameters](docs/ReleaseUpdateParameters.md)
 - [Screenshot](docs/Screenshot.md)
 - [ScreenshotCreateParameters](docs/ScreenshotCreateParameters.md)
 - [ScreenshotMarker](docs/ScreenshotMarker.md)
 - [ScreenshotMarkerCreateParameters](docs/ScreenshotMarkerCreateParameters.md)
 - [ScreenshotMarkerUpdateParameters](docs/ScreenshotMarkerUpdateParameters.md)
 - [ScreenshotUpdateParameters](docs/ScreenshotUpdateParameters.md)
 - [Space](docs/Space.md)
 - [SpaceCreateParameters](docs/SpaceCreateParameters.md)
 - [SpaceUpdateParameters](docs/SpaceUpdateParameters.md)
 - [SpacesProjectsCreateParameters](docs/SpacesProjectsCreateParameters.md)
 - [Styleguide](docs/Styleguide.md)
 - [StyleguideCreateParameters](docs/StyleguideCreateParameters.md)
 - [StyleguideDetails](docs/StyleguideDetails.md)
 - [StyleguideDetails1](docs/StyleguideDetails1.md)
 - [StyleguidePreview](docs/StyleguidePreview.md)
 - [StyleguideUpdateParameters](docs/StyleguideUpdateParameters.md)
 - [Tag](docs/Tag.md)
 - [TagCreateParameters](docs/TagCreateParameters.md)
 - [TagWithStats](docs/TagWithStats.md)
 - [TagWithStats1](docs/TagWithStats1.md)
 - [TagWithStats1Statistics](docs/TagWithStats1Statistics.md)
 - [TagWithStats1Statistics1](docs/TagWithStats1Statistics1.md)
 - [Translation](docs/Translation.md)
 - [TranslationCreateParameters](docs/TranslationCreateParameters.md)
 - [TranslationDetails](docs/TranslationDetails.md)
 - [TranslationDetails1](docs/TranslationDetails1.md)
 - [TranslationExcludeParameters](docs/TranslationExcludeParameters.md)
 - [TranslationIncludeParameters](docs/TranslationIncludeParameters.md)
 - [TranslationKey](docs/TranslationKey.md)
 - [TranslationKeyDetails](docs/TranslationKeyDetails.md)
 - [TranslationKeyDetails1](docs/TranslationKeyDetails1.md)
 - [TranslationOrder](docs/TranslationOrder.md)
 - [TranslationReviewParameters](docs/TranslationReviewParameters.md)
 - [TranslationUnverifyParameters](docs/TranslationUnverifyParameters.md)
 - [TranslationUpdateParameters](docs/TranslationUpdateParameters.md)
 - [TranslationVerifyParameters](docs/TranslationVerifyParameters.md)
 - [TranslationVersion](docs/TranslationVersion.md)
 - [TranslationVersionWithUser](docs/TranslationVersionWithUser.md)
 - [TranslationVersionWithUser1](docs/TranslationVersionWithUser1.md)
 - [TranslationsExcludeParameters](docs/TranslationsExcludeParameters.md)
 - [TranslationsIncludeParameters](docs/TranslationsIncludeParameters.md)
 - [TranslationsReviewParameters](docs/TranslationsReviewParameters.md)
 - [TranslationsSearchParameters](docs/TranslationsSearchParameters.md)
 - [TranslationsUnverifyParameters](docs/TranslationsUnverifyParameters.md)
 - [TranslationsVerifyParameters](docs/TranslationsVerifyParameters.md)
 - [Upload](docs/Upload.md)
 - [UploadCreateParameters](docs/UploadCreateParameters.md)
 - [UploadSummary](docs/UploadSummary.md)
 - [User](docs/User.md)
 - [UserPreview](docs/UserPreview.md)
 - [Webhook](docs/Webhook.md)
 - [WebhookCreateParameters](docs/WebhookCreateParameters.md)
 - [WebhookUpdateParameters](docs/WebhookUpdateParameters.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### Basic

- **Type**: HTTP basic authentication

### Token

- **Type**: API key
- **API key parameter name**: Authorization
- **Location**: HTTP header


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

support@phrase.com

