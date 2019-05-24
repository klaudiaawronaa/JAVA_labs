package Matrix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Typy generyczne są szablonami
//Macierz definiowana przez inny typ T
public class Matrix<T /*extends Integer, String*/> {
    public List<T> firstMatrix = new ArrayList<T>();
    public List<T> secondMatrix = new ArrayList<T>();
    public List<T> sumMatrix = new ArrayList<T>();

    public int row_1stMatrix;
    public int column_1stMatrix;
    public int row_2ndMatrix;
    public int column_2ndMatrix;


    public Matrix(List<T> firstMatrix1, List<T> secondMatrix2, int row1, int column1, int row2, int column2)
    throws Exception {
        row_1stMatrix = row1;
        column_1stMatrix = column1;
        row_2ndMatrix = row2;
        column_2ndMatrix = column2;
        if (row_1stMatrix == row_2ndMatrix && column_1stMatrix == column_2ndMatrix
                /*&& row_1stMatrix * column_1stMatrix == firstMatrix1.size() &&
                row_2ndMatrix * column_2ndMatrix == secondMatrix2.size()*/) {
            this.firstMatrix = firstMatrix1;
            this.secondMatrix = secondMatrix2;
        } else {
            throw new Exception("INCORRECT SIZE");
        }

    }


    public List<T> add(List<T> firstMatrix, List<T> secondMatrix) {
        if (firstMatrix.isEmpty() == false && secondMatrix.isEmpty() == false) {
            for (int i = 0; i < firstMatrix.size(); i++) {
                if (firstMatrix.get(i) instanceof Integer && secondMatrix.get(i) instanceof Integer) {
                    sumMatrix.add((T) (Integer) ((Integer) firstMatrix.get(i) + (Integer) secondMatrix.get(i)));
                } else {
                    sumMatrix.add((T) (String) ((String) firstMatrix.get(i) + (String) secondMatrix.get(i)));

                }
            }
        } else
            System.err.println(" FIRST MATRIX AND SECOND MATRIX SHOULD HAVE THE SAME NUMBER OF COLUMNS AND ROWS");

        return sumMatrix;
    }

    public void print(List<T> list, int listColumn) {
        System.out.println("");
        int j = 0;
        Iterator<T> itr = list.iterator();

        while (itr.hasNext()) {
            T element = itr.next();
            if (j == listColumn) {
                System.out.println();
                j = 0;
            }
            System.out.print(element + " ");
            j++;
        }
        System.out.println("");

    }

    public Matrix(){

    }

    public static void veryLongComputation() throws InterruptedException {
        Thread.sleep(3000);
    }

}





