package com.nycjv321.rss.validator;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * Created by Javier L. Velasquez on 12/10/15.
 */
@JacksonXmlRootElement(namespace = "env", localName = "Envelope")
public final class Envelope {
    private Body body;

    @JacksonXmlProperty(namespace = "env", localName = "Body")
    public Body getBody() {
        return body;
    }

}
