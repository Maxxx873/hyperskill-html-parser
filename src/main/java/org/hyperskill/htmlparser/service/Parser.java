package org.hyperskill.htmlparser.service;

import org.hyperskill.htmlparser.model.Source;

/**
 * Html parser for Source
 *
 */
public interface Parser {

    /**
     * Parser processing
     * @param source
     */
    String parse(Source source);
}
