package com.nycjv321.rss.validator;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.nycjv321.http.builder.MessageBodyClientBuilder;
import com.nycjv321.http.client.MessageBodyClient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Javier L. Velasquez on 12/10/15.
 */
public class W3CFeedValidationClient {

    private static final URL serviceEndPoint;

    static {
        try {
            serviceEndPoint = new URL("http://validator.w3.org/feed/check.cgi");
        } catch (MalformedURLException e) {
            throw new W3cFeedValidationException(e);
        }
    }

    private final URL url;
    private final ObjectMapper mapper;
    private final String encodedUrl;
    private final MessageBodyClient client;

    protected W3CFeedValidationClient(URL url) {
        this.url = url;
        encodedUrl = getEncodedUrl(url);
        client = MessageBodyClientBuilder.create().build();
        mapper = new XmlMapper();
        // Some of the responses include dynamic fields. We don't really care about those.
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    public static W3CFeedValidationClient create(URL feedUrl) {
        return new W3CFeedValidationClient(feedUrl);
    }

    private String getEncodedUrl(URL url) {
        try {
            return URLEncoder.encode(url.toString(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new W3cFeedValidationException(e);
        }

    }

    protected String getOutput() {
        final String output = client.get(getRequestUrl());
        // This gets around a bug with the service where it does not properly handle parameters in request urls
        return output.replace(url.toString(), encodedUrl);
    }

    public FeedValidationResponse validate() {
        Envelope envelope;
        try {
            envelope = mapper.readValue(getOutput(), Envelope.class);
            // The terms of using this service requires a 1 second wait between request
            Thread.sleep(1000);
        } catch (IOException|InterruptedException e) {
            throw new W3cFeedValidationException(e);
        }
        return envelope.getBody().getFeedValidationResponse();
    }

    private String getRequestUrl() {
        return String.format("%s?output=soap12&url=%s", serviceEndPoint, encodedUrl);
    }
    
    private static class W3cFeedValidationException extends RuntimeException {
        public W3cFeedValidationException(Throwable cause) {
            super(cause);
        }
    }
}
