package Sort;

import java.util.Random;

public class HeapSort {

    public int N;
    public int[] opt;
    public int[] neg;
    public int[] real;

    void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public HeapSort(int N)
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


    public void sort(int arr[])
    {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2*i + 1; // left = 2*i + 1
        int r = 2*i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
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
