package com.nycjv321.rss.validator;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Created by Javier L. Velasquez on 12/10/15.
 */
public final class Warnings {

    private int warningCount;
    private WarningList warningList;

    @JacksonXmlProperty(namespace = "m", localName = "warningcount")
    public int getWarningCount() {
        return warningCount;
    }

    @JacksonXmlProperty(namespace = "m", localName = "warninglist")
    public WarningList getWarningList() {
        return warningList;
    }


}
