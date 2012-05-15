package foo;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TextMungerTest {

    private TextMunger munger = new TextMunger();

    @Test
    public void returnsWordWithLessThanFourCharactersUnchanged() {
        assertRemainsUnchanged("foo");
    }

    @Test
    public void reversesMiddleOfWordWithAtLeastFourCharacters() {
        assertThat(munger.munge("abcd"), is("acbd"));
    }

    @Test
    public void reversesEachWordInASentence() {
        assertThat(munger.munge("a abcd"), is("a acbd"));
    }

    @Test
    public void ignoresPunctuation() {
        String marks = ".,";
        for (char mark: marks.toCharArray()) {
            assertIgnoresPunctuationMark(String.valueOf(mark));
        }
    }

    private void assertIgnoresPunctuationMark(String mark) {
        assertRemainsUnchanged("abc" + mark);
    }

    private void assertRemainsUnchanged(String string) {
        assertThat(munger.munge(string), is(string));
    }
}
