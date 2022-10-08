package org.hyperskill.htmlparser.model;

import static org.hyperskill.htmlparser.constant.Constant.*;

/**
 * Tag class for html tags
 */
public class Tag {
    private final String startTag;
    private final String endTag;
    private final int startTagLength;
    private final int endTagLength;

    public Tag(String tagName) {
        if (!tagName.isEmpty()) {
            this.startTag = OPEN_START_TAG_SIGN + tagName + CLOSE_TAG_SIGN;
            this.endTag = OPEN_END_TAG_SIGN + tagName + CLOSE_TAG_SIGN;
            this.startTagLength = startTag.length();
            this.endTagLength = endTag.length();
        } else {
            throw new IllegalArgumentException("tagName must be not empty string");
        }
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
