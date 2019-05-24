package Test;

import SubString.SubString;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SubStringTest {

    SubString sub;


    @Before
    public void setUp() {
        sub = new SubString();
    }

    @Test //TEST KONSTRUKTORA
    public void shouldMyClassBeInitialized() {
        assertNotNull(sub);
    }

    @Test
    public void resultShouldBeEqualMinusOne() throws Exception {

        int result = sub.SubstringFunction("abc", "ab");
        assertEquals(-1, result);

    }

    @Test
    public void resultShouldBeEqualThree() throws Exception {

        int result = sub.SubstringFunction("abcd", "cdabcdab");
        assertEquals(3, result);

    }


    @Test(timeout=4000)
    public void shouldNotRunLongerThenFourSeconds() throws Exception {
        sub.veryLongComputation(); //ustawiono 5 sekund w kodzie
    }








}
