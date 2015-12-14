package com.nycjv321.rss.validator;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Created by Javier L. Velasquez on 12/10/15.
 */
public final class Errors {

    private int errorCount;
    private ErrorList errorList;

    @JacksonXmlProperty(namespace = "m", localName = "errorcount")
    public int getErrorCount() {
        return errorCount;
    }

    @JacksonXmlProperty(namespace = "m", localName = "errorlist")
    public ErrorList getErrorList() {
        return errorList;
    }


}
