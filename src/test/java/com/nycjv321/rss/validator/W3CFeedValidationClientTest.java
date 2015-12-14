package com.nycjv321.rss.validator;

import org.testng.annotations.Test;

import java.net.URL;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by Javier L. Velasquez on 12/10/15.
 */
public class W3CFeedValidationClientTest {

    // We don't really care about the request at a given point in time.
    // We override the response to test that we are able to properly deserialize an already known payload.
    private class TestW3CFeedValidationClient extends W3CFeedValidationClient {

        private TestW3CFeedValidationClient(URL url) {
            super(url);
        }

        @Override
        protected String getOutput() {
            return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<env:Envelope xmlns:env=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                    "    <env:Body>\n" +
                    "        <m:feedvalidationresponse env:encodingStyle=\"http://www.w3.org/2003/05/soap-encoding\" xmlns:m=\"http://www.w3.org/2005/10/feed-validator\">\n" +
                    "            <m:uri>http://www.feedforall.com/sample.xml</m:uri>\n" +
                    "            <m:checkedby>http://validator.w3.org/feed/check.cgi</m:checkedby>\n" +
                    "            <m:date>2015-12-13T23:46:35.978605</m:date>\n" +
                    "            <m:validity>true</m:validity>\n" +
                    "            <m:errors>\n" +
                    "                <m:errorcount>0</m:errorcount>\n" +
                    "                <m:errorlist></m:errorlist>\n" +
                    "            </m:errors>\n" +
                    "            <m:warnings>\n" +
                    "                <m:warningcount>4</m:warningcount>\n" +
                    "                <m:warninglist>\n" +
                    "                    <warning>\n" +
                    "                        <level>warning</level>\n" +
                    "                        <type>MissingRealName</type>\n" +
                    "                        <line>12</line>\n" +
                    "                        <column>44</column>\n" +
                    "                        <text>Email address is missing real name</text>\n" +
                    "                        <msgcount>1</msgcount>\n" +
                    "                        <backupcolumn>44</backupcolumn>\n" +
                    "                        <backupline>12</backupline>\n" +
                    "                        <element>managingEditor</element>\n" +
                    "                    </warning>\n" +
                    "                    <warning>\n" +
                    "                        <level>warning</level>\n" +
                    "                        <type>MissingRealName</type>\n" +
                    "                        <line>14</line>\n" +
                    "                        <column>39</column>\n" +
                    "                        <text>Email address is missing real name</text>\n" +
                    "                        <msgcount>1</msgcount>\n" +
                    "                        <backupcolumn>39</backupcolumn>\n" +
                    "                        <backupline>14</backupline>\n" +
                    "                        <element>webMaster</element>\n" +
                    "                    </warning>\n" +
                    "                    <warning>\n" +
                    "                        <level>warning</level>\n" +
                    "                        <type>MissingGuid</type>\n" +
                    "                        <line>36</line>\n" +
                    "                        <column>4</column>\n" +
                    "                        <text>item should contain a guid element</text>\n" +
                    "                        <msgcount>9</msgcount>\n" +
                    "                        <backupcolumn>4</backupcolumn>\n" +
                    "                        <backupline>36</backupline>\n" +
                    "                        <element>guid</element>\n" +
                    "                        <parent>item</parent>\n" +
                    "                    </warning>\n" +
                    "                    <warning>\n" +
                    "                        <level>warning</level>\n" +
                    "                        <type>MissingAtomSelfLink</type>\n" +
                    "                        <line>150</line>\n" +
                    "                        <column>2</column>\n" +
                    "                        <text>Missing atom:link with rel=&quot;self&quot;</text>\n" +
                    "                        <msgcount>1</msgcount>\n" +
                    "                        <backupcolumn>2</backupcolumn>\n" +
                    "                        <backupline>150</backupline>\n" +
                    "                        <element>channel</element>\n" +
                    "                    </warning>\n" +
                    "                </m:warninglist>\n" +
                    "            </m:warnings>\n" +
                    "            <m:informations>\n" +
                    "                <m:infocount>0</m:infocount>\n" +
                    "                <m:infolist></m:infolist>\n" +
                    "            </m:informations>\n" +
                    "        </m:feedvalidationresponse>\n" +
                    "    </env:Body>\n" +
                    "</env:Envelope>";
        }
    }

    @Test
    public void validate() throws Exception {
        W3CFeedValidationClient client = new TestW3CFeedValidationClient(new URL("http://www.feedforall.com/sample.xml"));
        final FeedValidationResponse validate = client.validate();
        assertTrue(validate.isValid()); // the test xml we are using fails validation.
    }
}