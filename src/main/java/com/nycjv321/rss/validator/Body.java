package com.nycjv321.rss.validator;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Created by Javier L. Velasquez on 12/10/15.
 */
public final class Body {
    private FeedValidationResponse feedValidationResponse;

    @JacksonXmlProperty(namespace = "m", localName = "feedvalidationresponse")
    public FeedValidationResponse getFeedValidationResponse() {
        return feedValidationResponse;
    }

}
