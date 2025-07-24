package org.example1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class StringHelperParameterTest {

    private final String input;
    private final String expectedoutput;

    public StringHelperParameterTest(String input, String expectedoutput) {
        this.input = input;
        this.expectedoutput = expectedoutput;
    }

    StringHelper helper = new StringHelper();

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][]{
                {"AACD", "CD"},
                {"ACD", "CD"}
        });
    }

    @Test
    public void testTruncateAInFirst2Positions() {
        assertEquals(expectedoutput, helper.truncateAInFirst2Positions(input));
    }
}
