package Matrix;

import java.util.ArrayList;
import java.util.List;

public class Create {

    public void create(){
        //testowanie na mojej liscie
        List<Integer> firstMatrixInteger = new ArrayList<Integer>();
        List<Integer> secondMatrixInteger = new ArrayList<Integer>();
        for (int i = 0; i< 9; i++)
        {
            firstMatrixInteger.add(i);
            secondMatrixInteger.add(2*i);
        }

        Matrix matrixInteger = new Matrix(firstMatrixInteger, secondMatrixInteger,
                3, 3, 3, 3);
        matrixInteger.add(firstMatrixInteger, secondMatrixInteger);
        matrixInteger.print(firstMatrixInteger,matrixInteger.column_1stMatrix);
        System.out.println("  +   ");
        matrixInteger.print(secondMatrixInteger,matrixInteger.column_1stMatrix);
        System.out.println("  =   ");
        matrixInteger.print(matrixInteger.sumMatrix,matrixInteger.column_1stMatrix);
        System.out.println("");



        List<String> firstMatrixString = new ArrayList<String>();
        List<String> secondMatrixString = new ArrayList<String>();
        for (int i = 0; i< 9; i++)
        { firstMatrixString.add("a");
            secondMatrixString.add("b");
        }

        Matrix matrixString = new Matrix(firstMatrixInteger, secondMatrixInteger, 3, 3, 3, 3);
        matrixString.add(firstMatrixString, secondMatrixString);
        matrixString.print(firstMatrixString,matrixString.column_1stMatrix);
        System.out.println("  +  ");
        matrixString.print(secondMatrixString,matrixString.column_1stMatrix);
        System.out.println("  =  ");
        matrixString.print(matrixString.sumMatrix,matrixString.column_1stMatrix);
        System.out.println("");
    }
}
