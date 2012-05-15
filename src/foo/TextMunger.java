package foo;

import java.util.StringTokenizer;

public class TextMunger {
    public String munge(String text) {
        String wordSeparators = " ,.";
        StringTokenizer tokenizer = new StringTokenizer(text, wordSeparators, true);
        StringBuilder result = new StringBuilder();
        while (tokenizer.hasMoreTokens()) {
            result.append(mungeWord(tokenizer.nextToken()));
        }
        return result.toString();
    }

    private String mungeWord(String text) {
        if (text.length() > 3) {
            return text.substring(0, 1)
                    + reverse(middle(text))
                    + text.substring(text.length() - 1);
        }
        return text;
    }

    private String reverse(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    private String middle(String text) {
        return text.substring(1, text.length()-1);
    }
}
