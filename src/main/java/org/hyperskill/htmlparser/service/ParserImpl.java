package org.hyperskill.htmlparser.service;

import org.hyperskill.htmlparser.model.Source;
import org.hyperskill.htmlparser.model.Tag;

import java.util.*;

public class ParserImpl implements Parser {
    private final String OPEN_START_TAG_SIGN = "<";
    private final String OPEN_END_TAG_SIGN = "</";
    private final String CLOSE_TAG_SIGN = ">";

    @Override
    public String parse(Source source) {
        Deque<String> resultDeque = new ArrayDeque<>();
        var content = new StringBuilder(contentCleanUp(source.toString()));
        var result = new StringBuilder();
        while (content.indexOf(OPEN_START_TAG_SIGN) >= 0 && content.indexOf(CLOSE_TAG_SIGN) >= 0) {
            int startIndex = content.lastIndexOf(OPEN_END_TAG_SIGN) + OPEN_END_TAG_SIGN.length();
            int stopIndex = content.lastIndexOf(CLOSE_TAG_SIGN);
            var tag = new Tag(content.substring(startIndex, stopIndex));
            resultDeque.push(content.substring(content.lastIndexOf(tag.getStartTag()) + tag.getStartTagLength(), content.lastIndexOf(tag.getEndTag())) + "\n");
            content.delete(content.lastIndexOf(tag.getStartTag()), content.lastIndexOf(tag.getStartTag()) + tag.getStartTagLength());
            content.delete(content.lastIndexOf(tag.getEndTag()), content.lastIndexOf(tag.getEndTag()) + tag.getEndTagLength());
        }
        resultDeque.forEach(result::append);
        System.out.println(result);
        return result.toString();
    }

    private String contentCleanUp(String source) {
        var content = new StringBuilder(source);
        while (content.indexOf("\n") >= 0) {
            content.delete(content.indexOf("\n"), content.indexOf("\n") + 1);
        }
        return content.toString();
    }
}
