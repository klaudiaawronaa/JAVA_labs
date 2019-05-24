package Test;

import MinValue.MinValue;
import MinValue.MyException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MinValueTest {

    MinValue minValue;
    MinValue withoutN;
    int N;

    @Before
    public void setUp() throws Exception {
        N = 100;
        minValue = new MinValue(N);
    }

    @Test //TEST KONSTRUKTORA SPARAMETRYZOWANEGO
    public void shouldMyClassBeInitializedwithN() {
        assertNotNull(minValue);
    }

    @Test
    public void shoudMyClassBeInitialized()
    {
        withoutN = new MinValue();
        assertNotNull(withoutN);
    }

    @Test(expected = MyException.class)
    public void shouldThrowExceptionWhenNegative() throws Exception {
        N = -100;
        minValue = new MinValue(N);
    }

    @Test(timeout=4000)
    public void shouldNotRunLongerThenFourSeconds() throws Exception {
        MinValue.veryLongComputation(); /*ustawiono 5 sekund w kodzie*/}


    @Test(expected = MyException.class)
    public void shouldThrowExceptionWhenNEguals1E5() throws Exception {

        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (i <= 1E5) {
            list.add(i);
            i++;
        }
        minValue.solution(list); }

    @Test
    public void resultShouldBeEqualFive() throws Exception{
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(6);
        list.add(4);
        list.add(1);
        list.add(2); //brakuje 5

        int result =minValue.solution(list);
        assertEquals(5, result);

    }



}

