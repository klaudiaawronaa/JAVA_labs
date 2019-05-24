package Test;

import Matrix.Create;
import Matrix.Matrix;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MatrixTest {
    Matrix matrix;
    Create list;

    @Before
    public void setUp(){
        matrix = new Matrix();
        list = new Create();
    }

    @Test //TEST KONSTRUKTORA
    public void shouldMatrixBeInitialized() {
        assertNotNull(matrix);
    }

    @Test //TEST KONSTRUKTORA
    public void shouldCreateInitialized() {
        assertNotNull(list);
    }

    @Test(timeout=4000)
    public void shouldNotRunLongerThenFourSeconds() throws Exception {
        matrix.veryLongComputation();
    }

    @Test (expected = Exception.class)
    public void shouldThrowExceptionWhenWrongSize() throws Exception{
        list = new Create();
        matrix  = new Matrix(list.firstMatrixInteger,
                list.secondMatrixInteger,
                3,1,2,3); }


    @Test
    public void shouldMakeStringMatrix(){
        list = new Create();
        list.create();

        int row = 3;
        int column =3;
        List<String> result = new ArrayList<String>();
        for (int i=0; i<row*column; i++)
            result.add("ab");

        assertEquals(result, list.sumMatrixString);

    }

    @Test
    public void shouldMakeIntegerMatrix(){
        list = new Create();
        list.create();

        int row = 3;
        int column =3;
        List<Integer> result = new ArrayList<Integer>();
        for (int i=0; i<row*column; i++)
            result.add(3*i);

        assertEquals(result, list.sumMatrixInteger);

    }







}
