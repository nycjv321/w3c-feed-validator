# W3C-Feed-Validator

  Java Client for the W3C Feed Validation service (see https://validator.w3.org/feed/) 

## Example Usage:

    W3CFeedValidationClient client = new W3CFeedValidationClient(
      new URL("http://www.feedforall.com/sample.xml")
    );
    // POJO of 
    // http://validator.w3.org/feed/check.cgi?output=soap12&url=http%3A%2F%2Fwww.feedforall.com%2Fsample.xml
    final FeedValidationResponse validate = client.validate();

## Installation

  In your pom.xml <dependencies> section add:
  
    <dependency>
      <groupId>com.nycjv321</groupId>
      <artifactId>w3c-feed-validator</artifactId>
      <version>${current_version}</version>
    </dependency>

### Dependencies

    $ mvn -P dependency-viewer dependency:tree | grep -v 'test'
    [INFO] Scanning for projects...
    [INFO]                                                                         
    [INFO] ------------------------------------------------------------------------
    [INFO] Building com.nycjv321:w3c-feed-validator 1.0
    [INFO] ------------------------------------------------------------------------
    [INFO] 
    [INFO] --- maven-dependency-plugin:2.10:tree (default-cli) @ w3c-feed-validator ---
    [INFO] com.nycjv321:w3c-feed-validator:jar:1.0
    [INFO] +- com.fasterxml.jackson.core:jackson-core:jar:2.6.3:compile
    [INFO] +- com.fasterxml.jackson.core:jackson-databind:jar:2.6.3:compile
    [INFO] |  \- com.fasterxml.jackson.core:jackson-annotations:jar:2.6.0:compile
    [INFO] +- com.fasterxml.jackson.dataformat:jackson-dataformat-xml:jar:2.6.3:compile
    [INFO] |  +- com.fasterxml.jackson.module:jackson-module-jaxb-annotations:jar:2.6.3:compile
    [INFO] |  \- org.codehaus.woodstox:stax2-api:jar:3.1.4:compile
    [INFO] +- org.apache.httpcomponents:httpclient:jar:4.3:compile
    [INFO] |  +- org.apache.httpcomponents:httpcore:jar:4.3:compile
    [INFO] |  +- commons-logging:commons-logging:jar:1.1.3:compile
    [INFO] |  \- commons-codec:commons-codec:jar:1.6:compile
    [INFO] +- org.jdom:jdom:jar:2.0.2:compile
    [INFO] +- org.apache.logging.log4j:log4j-api:jar:2.1:compile
    [INFO] +- org.apache.logging.log4j:log4j-core:jar:2.1:compile
    [INFO] +- commons-io:commons-io:jar:2.4:compile
    [INFO] +- com.nycjv321:simple-http-client:jar:1.2:compile
    [INFO] \- com.nycjv321:utilities:jar:1.4:compile
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time: 1.056 s
    [INFO] Finished at: 2015-12-13T19:16:33-05:00
    [INFO] Final Memory: 14M/187M
    [INFO] ------------------------------------------------------------------------
