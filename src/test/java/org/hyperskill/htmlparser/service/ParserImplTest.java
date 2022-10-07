package org.hyperskill.htmlparser.service;

import org.hyperskill.htmlparser.model.Source;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ParserImplTest {

    private final Parser parser = new ParserImpl();

    @Test
    void parseEasyTest() {
        //GIVEN
        var content = """
                <html>content</html>
                """;
        var expectedResult = """
                content
                """;
        var source = new Source(content);

        //WHEN
        var result = parser.parse(source);

        //THEN
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void parseMoreComplicatedTest() {
        //GIVEN
        var content = """
                <html>
                <h1>content1</h1>
                <h2>content2</h2>
                </html>
                """;
        var expectedResult = """
                content1
                content2
                <h1>content1</h1><h2>content2</h2>
                """;
        var source = new Source(content);

        //WHEN
        var result = parser.parse(source);

        //THEN
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void parseHardestTest() {
        //GIVEN
        var content = """
                <html>
                <h1>content1</h1>
                <div>
                <h2>content2</h2>
                </div>
                </html>
                """;
        var expectedResult = """
                content1
                content2
                <h2>content2</h2>
                <h1>content1</h1><div><h2>content2</h2></div>
                """;
        var source = new Source(content);

        //WHEN
        var result = parser.parse(source);

        //THEN
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void parseMoreHardestTest() {
        //GIVEN
        var content = """
                <html>
                <a>hello</a>
                <h1>
                <h4>nestedHello</h4>
                <h3>nestedWorld</h3>
                <h6>
                <br>top</br>
                </h6>
                </h1>
                <br>world</br>
                </html>
                """;
        var expectedResult = """
                hello
                nestedHello
                nestedWorld
                top
                <br>top</br>
                <h4>nestedHello</h4><h3>nestedWorld</h3><h6><br>top</br></h6>
                world
                <a>hello</a><h1><h4>nestedHello</h4><h3>nestedWorld</h3><h6><br>top</br></h6></h1><br>world</br>
                """;
        var source = new Source(content);

        //WHEN
        var result = parser.parse(source);

        //THEN
        assertThat(result).isEqualTo(expectedResult);
    }
}