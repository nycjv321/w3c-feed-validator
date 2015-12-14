package com.nycjv321.rss.validator;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

/**
 * Created by Javier L. Velasquez on 12/10/15.
 */
public final class WarningList {
    private List<Warning> warnings;

    @JacksonXmlProperty(localName = "warning")
    @JacksonXmlElementWrapper(useWrapping = false)
    public List<Warning> getWarnings() {
        return warnings;
    }
}
