package Test;
import Solution.Solution;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SolutionTest {

    Solution solut;
    @Before
    public void setUp(){
        solut = new Solution();
    }

    @Test //TEST KONSTRUKTORA
    public void shouldMyClassBeInitialized() {
        assertNotNull(solut);
    }

    @Test
    public void resultShouldBeEqualZeroAndTwo() throws Exception {

        float[] arr = {2,11,7,15,0};
        int[] result = solut.solution(arr,9);
        assertEquals(0, result[0]);
        assertEquals(2, result[1]);
    }

    @Test
    public void resultShouldBe() throws Exception {

        float[] arr = {2,11,7,15,0};
        int[] result = solut.solution(arr,9);
        assertEquals(0, result[0]);
        assertEquals(2, result[1]);
    }

    @Test(timeout=4000)
    public void shouldNotRunLongerThenFourSeconds() throws Exception {
        solut.veryLongComputation(); //ustawiono 5 sekund w kodzie
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionWhenNEgualsMinusOne() throws Exception {
        float[] arr = {2,11,2,15,0};
        int[] result = solut.solution(arr,9);
    }






}
