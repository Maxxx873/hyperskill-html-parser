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
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            if (!line.isEmpty()) {
                content.append(line);
            } else {
                break;
            }
        }
        var source = new Source(content.toString());
        System.out.println("---PROCESSING RESULT---");
        System.out.println(parser.parse(source));
    }
}
