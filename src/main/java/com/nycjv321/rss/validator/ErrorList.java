package com.nycjv321.rss.validator;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.lang.*;
import java.util.List;

/**
 * Created by Javier L. Velasquez on 12/10/15.
 */
public class ErrorList {
    private List<java.lang.Error> errors;

    @JacksonXmlProperty(localName = "error")
    @JacksonXmlElementWrapper(useWrapping = false)
    public List<java.lang.Error> getErrors() {
        return errors;
    }
}
