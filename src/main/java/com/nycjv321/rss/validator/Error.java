package com.nycjv321.rss.validator;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Created by Javier L. Velasquez on 12/10/15.
 */
public final class Error {

    private String level;
    private String type;
    private int line;
    private String exception;
    private int column;
    private String text;
    private int msgCount;
    private int backupColumn;
    private int backupLine;

    @JacksonXmlProperty
    public String getLevel() {
        return level;
    }

    @JacksonXmlProperty
    public String getType() {
        return type;
    }

    @JacksonXmlProperty
    public int getLine() {
        return line;
    }

    @JacksonXmlProperty
    public int getColumn() {
        return column;
    }

    @JacksonXmlProperty
    public String getText() {
        return text;
    }

    @JacksonXmlProperty(localName = "msgcount")
    public int getMsgCount() {
        return msgCount;
    }

    @JacksonXmlProperty(localName = "backupcolumn")
    public int getBackupColumn() {
        return backupColumn;
    }

    @JacksonXmlProperty(localName = "backupline")
    public int getBackupLine() {
        return backupLine;
    }

    @JacksonXmlProperty(localName = "exception")
    public String getException() {
        return exception;
    }
}
