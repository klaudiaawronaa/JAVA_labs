package Sort;

import java.util.Random;

public class ShellSort {
    public int N;
    public int[] opt;
    public int[] neg;
    public int[] real;

    void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public ShellSort(int N)
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




    int sort(int arr[])
    {
        int n = arr.length;

        // Start with a big gap, then reduce the gap
        for (int gap = n/2; gap > 0; gap /= 2)
        {
            for (int i = gap; i < n; i += 1)
            {

                int temp = arr[i];

                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];
                arr[j] = temp;
            }
        }
        return 0;
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
