package Test;

import Sort.BubbleSort;
import Sort.Create;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortTest {

    Create createSort;
    BubbleSort bubblesort;

    @Before
    public void setUp(){
        createSort = new Create();
        createSort.bubblesort();
    }

    @Test //TEST KONSTRUKTORA
    public void shouldMyClassBeInitialized() {
        assertNotNull(createSort);
    }

    @Test //TEST KONSTRUKTORA
    public void shouldSortBeInitialized() {
        bubblesort = new BubbleSort(10000);
        assertNotNull(bubblesort);
    }

    @Test //TEST KONSTRUKTORA
    public void timeOptShouldBeLessThanTimeNeg() {
        bubblesort = new BubbleSort(10000);
        if( bubblesort.time(bubblesort.neg, 0, bubblesort.N - 1) <
                bubblesort.time(bubblesort.opt, 0, bubblesort.N - 1))
                Assert.fail();

    }


    @Test
    public void shouldReturnSortedArray(){
        bubblesort = new BubbleSort(10000);
        int[] correct = new int[10000];
        int[] toSort = new int[10000];
        for (int i =0; i<10000; i++) {
            correct[i] = i+1;
            toSort[i] = 10000 - i;
        }

        assertArrayEquals(correct, bubblesort.bubbleSort(toSort, 10000));

    }






}
