package com.nycjv321.rss.validator;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.lang.*;
import java.util.List;

/**
 * Created by Javier L. Velasquez on 12/10/15.
 */
public final class FeedValidationResponse {

    private String encodingStyle;
    private String uri;
    private String checkedBy;
    private String date;
    @JacksonXmlProperty(namespace = "m")
    private boolean validity;
    @JacksonXmlProperty(namespace = "m", localName = "errors")
    private Errors errors;
    @JacksonXmlProperty(namespace = "m", localName = "warnings")
    private Warnings warnings;

    @JacksonXmlProperty(namespace = "env", localName = "encodingStyle", isAttribute = true)
    public String getEncodingStyle() {
        return encodingStyle;
    }

    @JacksonXmlProperty(namespace = "m")
    public String getUri() {
        return uri;
    }

    @JacksonXmlProperty(namespace = "m", localName = "checkedby")
    public String getCheckedBy() {
        return checkedBy;
    }

    @JacksonXmlProperty(namespace = "m")
    public String getDate() {
        return date;
    }

    public boolean isValid() {
        return validity;
    }

    public List<java.lang.Error> getErrors() {
        return errors.getErrorList().getErrors();
    }

    public List<Warning> getWarnings() {
        return warnings.getWarningList().getWarnings();
    }

}
