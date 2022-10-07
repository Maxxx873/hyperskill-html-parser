package org.hyperskill.htmlparser.model;

import java.util.List;

/**
 * Source class for content with html tags
 */
public class Source {
    private String content;

    public Source(String source) {
        this.content = source;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return this.content;
    }

}
