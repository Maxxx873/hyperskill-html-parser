package org.hyperskill.htmlparser.model;

/**
 * Tag class for html tags
 */
public class Tag {
    private final String tagName;
    private final String startTag;
    private final String endTag;
    private final int startTagLength;
    private final int endTagLength;

    public Tag(String tagName) {
        if (!tagName.equals(null) && !tagName.isEmpty()) {
            this.tagName = tagName;
            this.startTag = "<" + tagName + ">";
            this.endTag = "</" + tagName + ">";
            this.startTagLength = startTag.length();
            this.endTagLength = endTag.length();
        } else {
            throw new IllegalArgumentException("tagName must be not empty string");
        }
    }

    public String getTagName() {
        return tagName;
    }

    public String getStartTag() {
        return startTag;
    }

    public String getEndTag() {
        return endTag;
    }

    public int getStartTagLength() {
        return startTagLength;
    }

    public int getEndTagLength() {
        return endTagLength;
    }

}
