package com.nycjv321.rss.validator;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Created by Javier L. Velasquez on 12/10/15.
 */
public final class Warning {

    private String level;
    private String type;
    private String text;

    @JacksonXmlProperty
    public String getLevel() {
        return level;
    }

    @JacksonXmlProperty
    public String getType() {
        return type;
    }

    @JacksonXmlProperty
    public String getText() {
        return text;
    }

}
