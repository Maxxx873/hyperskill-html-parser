package org.hyperskill.htmlparser;

import org.hyperskill.htmlparser.model.Source;
import org.hyperskill.htmlparser.service.Parser;
import org.hyperskill.htmlparser.service.ParserImpl;

import java.util.Scanner;

/**
 * Html Parser
 */
public class App {
    final static Scanner scanner = new Scanner(System.in);
    final static Parser parser = new ParserImpl();

    public static void main(String[] args) {
        StringBuilder content = new StringBuilder();
        String line;
        System.out.println("Please enter html string:\n");
        line = scanner.next();
        if (!line.isEmpty()) {
            content.append(line);
            var source = new Source(content.toString());
            System.out.println("\n---PROCESSING RESULT---\n");
            System.out.println(parser.parse(source));
        }
    }
}
