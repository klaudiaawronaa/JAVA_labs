package Sort;

import java.util.Random;

public class CombSort {

    public int N;
    public int[] opt;
    public int[] neg;
    public int[] real;

    void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public CombSort(int N)
    {   this.N=N;
        Random rand = new Random();
        int[] optTmp = new int[N];
        int[] negTmp = new int[N];
        int[] realTmp = new int[N];

        for(int i=0; i<N; i++)
        {
            optTmp[i] = i;
            negTmp[i] = N-i;
            realTmp[i] = rand.nextInt(N+1);
        }
        int i=0;
        while(i+10<N)
        {
            swap(optTmp, i, i+10);
            i++;
        }

        opt = optTmp;
        neg = negTmp;
        real= realTmp;

    }




    // To find gap between elements
    int getNextGap(int gap) {
        // Shrink gap by Shrink factor
        gap = (gap * 10) / 13;
        if (gap < 1)
            return 1;
        return gap;
    }

    // Function to sort arr[] using Comb Sort
    void sort(int arr[]) {
        int n = arr.length;

        // initialize gap
        int gap = n;

        // Initialize swapped as true to make sure that
        // loop runs
        boolean swapped = true;

        // Keep running while gap is more than 1 and last
        // iteration caused a swap
        while (gap != 1 || swapped == true) {
            // Find next gap
            gap = getNextGap(gap);

            // Initialize swapped as false so that we can
            // check if swap happened or not
            swapped = false;

            // Compare all elements with current gap
            for (int i = 0; i < n - gap; i++) {
                if (arr[i] > arr[i + gap]) {
                    // Swap arr[i] and arr[i+gap]
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;

                    // Set swapped
                    swapped = true;
                }
            }
        }
    }

    public void time(int[] arr, int l, int r)
    {
        /*System.out.println("BEFORE SORT");
        for (int i=0; i<r; i++)
            System.out.print(arr[i]+" ");
        */
        long tStart = System.currentTimeMillis();
        sort(arr);
        long tEnd = System.currentTimeMillis();
        long tDelta = tEnd - tStart;
        double elapsedSeconds = tDelta / 1000.0;
        /*System.out.println("");
        System.out.println("AFTER SORT");
        for (int i=0; i<r; i++)
            System.out.print(arr[i]+" ");

        System.out.println("");*/
        System.out.println(elapsedSeconds);


    }
}
