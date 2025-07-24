package org.example1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringHelperTest {
    StringHelper helper=new StringHelper();
    @Test
     public void testtruncateAInFirst2Positions1()
    {
        String actual=helper.truncateAInFirst2Positions("AACDAA");
        String expected="CDAA";
        assertEquals(expected,actual);
    }

    @Test
    public void testtruncateAInFirst2Positions2()
    {
        String actual=helper.truncateAInFirst2Positions("AACD");
        String expected="CD";
        assertEquals(expected,actual);
    }
    @Test
    public void areFirstAndLastTwoCharactersTheSame_Negativescenerio()
    {
          assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
//        assertEquals(false, helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
    }

    @Test
    public void areFirstAndLastTwoCharactersTheSame_Positivescenerio()
    {
        assertTrue(helper.areFirstAndLastTwoCharactersTheSame("A"),"Failed");
    }
}