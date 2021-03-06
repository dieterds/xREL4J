xREL4J
======

Introduction
------------

Java implementation for the usage of the xREL API v2. Method and parameter names are based on the xREL API with "_" replaced by camel case. Order of methods and parameters are based on the xREL API documentation.

It is **STRONGLY** encouraged to read the xREL API documentation!
https://www.xrel.to/wiki/1681/API.html

Requirements
------------

In order to use xREL4J you need a couple of prerequisites:

- Minimum required Java version is Java 8.

- A JAX-RS (JSR-339) implementation, e.g. [Jersey](https://jersey.github.io). Any other JAX-RS implementation should theoretically work, although only Jersey has been tested.

- If you want to use JSON you have to add:

    - A JSON-P (JSR-374) implementation, e.g. [Eclipse JSON-P](https://projects.eclipse.org/projects/ee4j.jsonp). Any other JSON-P implementation should theoretically work, although only Eclipse JSON-P has been tested.

    - A JSON-B (JSR-367) implementation, e.g. [Eclipse Yasson](https://projects.eclipse.org/projects/ee4j.yasson). Any other JSON-B implementation should theoretically work, although only Eclipse Yasson has been tested.

- If you want to use XML you have to add:

    - A JAXB (JSR-222) implementation, e.g. [JAXB RI](https://javaee.github.io/jaxb-v2/). Any other JAXB implementation should theoretically work, although only JAXB RI has been tested.

Keep in mind that the oauth2/token endpoint always returns JSON. If you intend to use that, you have to add JSON-P and JSON-B, but you can still use JAXB for all other requests. If you don't plan on using this method, you can solely rely on JAXB.
There are also some internal Java methods used for making XML work without breaking JSON compatibility or having to maintain two completely different implementations. This means, that there might be breakage in later Java versions.

Setup
-----

- Get yourself a snapshot from this repository:

    git clone https://github.com/saftsau/xREL4J.git

- Get your favored JAX-RS + JSON-B + JSON-P implementation.

- Add xREL4J and your chosen implementation libraries to your project.

- That's it!

Usage
-----

Following are some examples for really basic usage of xREL4J. As a complete Javadoc is included and there is also extensive documentation of the xREL API, this should just be a starting point. It is **strongly** advised to also read the xREL API documentation.

Basic usage without any authentication:

```java
Xrel xrel = new Xrel();
Release release = xrel.getReleaseInfoId("f638d1cfec8d");
System.out.println(release.getDirname());
```

Authentication:

```java
Xrel xrel = new Xrel(CLIENT_ID, CLIENT_SECRET, Optional.of(REDIRECT_URI), Optional.empty(), new String[] { "viewnfo", "addproof" });
// Step 1: Redirect user to this URL somehow, depending on your use case
System.out.println(xrel.getOauth2Auth());
// Step 2:  Use code user got from step 1
Token token = xrel.postOauth2Token("authorization_code", CODE);
// Step 3:  Refresh token once its lifetime is over
token = xrel.postOauth2Token("refresh_token", token);
```

Basic usage with authentication and scopes:

```java
Xrel xrel = new Xrel(CLIENT_ID, CLIENT_SECRET, Optional.of(REDIRECT_URI), Optional.empty(), new String[] { "viewnfo", "addproof" });
Release release = xrel.getReleaseInfoId("f638d1cfec8d");
byte[] nfoImage = xrel.getNfoRelease(release, token);
```

Rate checking:

```java
System.out.println("X-RateLimit-Limit: " + xrel.getXRateLimitLimit());
System.out.println("X-RateLimit-Remaining: " + xrel.getXRateLimitRemaining());
System.out.println("X-RateLimit-Reset: " + xrel.getXRateLimitReset());
```

xREL API Errors (and connection problems) are returned as XrelException. You can get the information returned by the xREL API from these exceptions:

```java
catch (XrelException e) {
	if (e.getError().isPresent()) {
		System.out.println(e.getError().get().getError());
		System.out.println(e.getError().get().getErrorType());
		System.out.println(e.getError().get().getErrorDescription());
	}
	System.out.println(e.getResponseCode());
} 
```

The parsing of JSON Web Tokens is **not** included. If you want to have that feature in your application as well, you have to include a JWT library you want to use and decode the token for yourself:

```java
Xrel xrel = new Xrel(CLIENT_ID, CLIENT_SECRET, Optional.of(REDIRECT_URI), Optional.empty(), new String[] { "viewnfo", "addproof" });
Token token = xrel.postOauth2Token("authorization_code", code); // code = the code you got from the xREL OAuth
String accessToken = token.getAccessToken());
... // Decode the JWT
```

Reporting bugs
--------------

To report a bug:
- Use the "issues" system on GitHub
- Send me a message on xREL ("saftsau")
- Post in the xREL "Developer Forum" section (https://www.xrel.to/forum-topics.html?id=53)