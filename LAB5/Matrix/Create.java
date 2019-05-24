package Matrix;

import java.util.ArrayList;
import java.util.List;

public class Create {

    public List<Integer> firstMatrixInteger;
    public List<Integer> secondMatrixInteger;

    public List<String> firstMatrixString;
    public List<String> secondMatrixString;
    public List<String> sumMatrixString;
    public List<Integer> sumMatrixInteger;
    public void create() {
        //testowanie na mojej liscie
        firstMatrixInteger = new ArrayList<Integer>();
        secondMatrixInteger = new ArrayList<Integer>();
        for (int i = 0; i < 9; i++) {
            firstMatrixInteger.add(i);
            secondMatrixInteger.add(2 * i);
        }

        try{
        Matrix matrixInteger = new Matrix(firstMatrixInteger, secondMatrixInteger,
                3, 3, 3, 3);
        matrixInteger.add(firstMatrixInteger, secondMatrixInteger);
        matrixInteger.print(firstMatrixInteger, matrixInteger.column_1stMatrix);
        System.out.println("  +   ");
        matrixInteger.print(secondMatrixInteger, matrixInteger.column_1stMatrix);
        System.out.println("  =   ");
        matrixInteger.print(matrixInteger.sumMatrix, matrixInteger.column_1stMatrix);
        System.out.println("");
            sumMatrixInteger = new ArrayList<Integer>();
            sumMatrixInteger = matrixInteger.sumMatrix;}
        catch (Exception e){}


         firstMatrixString = new ArrayList<String>();
         secondMatrixString = new ArrayList<String>();
        for (int i = 0; i < 9; i++) {
            firstMatrixString.add("a");
            secondMatrixString.add("b");
        }

        try {
            Matrix matrixString = new Matrix(firstMatrixInteger, secondMatrixInteger, 3, 3, 3, 3);
            matrixString.add(firstMatrixString, secondMatrixString);
            matrixString.print(firstMatrixString, matrixString.column_1stMatrix);
            System.out.println("  +  ");
            matrixString.print(secondMatrixString, matrixString.column_1stMatrix);
            System.out.println("  =  ");
            matrixString.print(matrixString.sumMatrix, matrixString.column_1stMatrix);
            System.out.println("");
            sumMatrixString = new ArrayList<String>();
            sumMatrixString = matrixString.sumMatrix;
        } catch (Exception e) {
        }
    }
}
