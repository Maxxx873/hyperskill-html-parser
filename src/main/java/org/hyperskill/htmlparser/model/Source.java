package org.hyperskill.htmlparser.model;

/**
 * Source class for content with html tags
 */
public class Source {
    private final String content;

    public Source(String source) {
        if (!source.isEmpty()) {
            this.content = source;
        } else {
            throw new IllegalArgumentException("source must be not empty string");
        }
    }

    @Override
    public String toString() {
        return this.content;
    }

}
