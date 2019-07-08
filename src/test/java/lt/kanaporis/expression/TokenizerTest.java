package lt.kanaporis.expression;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class TokenizerTest {
    @Test(expected = NullPointerException.class)
    public void ctor_null_exception() {
        new Tokenizer(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void nextTerm_empty_null() {
        var tokenizer = new Tokenizer("");
        tokenizer.next();
    }

    @Test
    public void nextTerm_single_single() {
        var tokenizer = new Tokenizer("(");
        assertEquals("(", tokenizer.next());
    }

    @Test
    public void nextTerm_negative_single() {
        var tokenizer = new Tokenizer("-9.00");
        assertEquals("-9.00", tokenizer.next());
    }

    @Test
    public void nextTerm_twoConsequtive_two() {
        var tokenizer = new Tokenizer("(?");
        assertEquals("(", tokenizer.next());
        assertEquals("?", tokenizer.next());
    }

    @Test
    public void nextTerm_twoWithWhitespace_two() {
        var tokenizer = new Tokenizer("? (");
        assertEquals("?", tokenizer.next());
        assertEquals("(", tokenizer.next());
    }

    @Test
    public void nextTerm_long_parse() {
        var tokenizer = new Tokenizer("(? (> (? (IsOk finalcurr) finalcurr 0) (? (IsOk paymentcurr) paymentcurr 0)) (/ sum 3.4528) sum)");
        assertEquals("(", tokenizer.next());
        assertEquals("?", tokenizer.next());
        assertEquals("(", tokenizer.next());
        assertEquals(">", tokenizer.next());
        assertEquals("(", tokenizer.next());
        assertEquals("?", tokenizer.next());
        assertEquals("(", tokenizer.next());
        assertEquals("IsOk", tokenizer.next());
        assertEquals("finalcurr", tokenizer.next());
        assertEquals(")", tokenizer.next());
        assertEquals("finalcurr", tokenizer.next());
        assertEquals("0", tokenizer.next());
        assertEquals(")", tokenizer.next());
        assertEquals("(", tokenizer.next());
        assertEquals("?", tokenizer.next());
        assertEquals("(", tokenizer.next());
        assertEquals("IsOk", tokenizer.next());
        assertEquals("paymentcurr", tokenizer.next());
        assertEquals(")", tokenizer.next());
        assertEquals("paymentcurr", tokenizer.next());
        assertEquals("0", tokenizer.next());
        assertEquals(")", tokenizer.next());
        assertEquals(")", tokenizer.next());
        assertEquals("(", tokenizer.next());
        assertEquals("/", tokenizer.next());
        assertEquals("sum", tokenizer.next());
        assertEquals("3.4528", tokenizer.next());
        assertEquals(")", tokenizer.next());
        assertEquals("sum", tokenizer.next());
        assertEquals(")", tokenizer.next());
    }
}