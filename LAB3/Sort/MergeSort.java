package Sort;
import java.util.Random;

public class MergeSort {
    public int N;
    public int[] opt;
    public int[] neg;
    public int[] real;

    void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public MergeSort(int N)
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

    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    public void sort(int arr[], int l, int r)
    {

        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }

    }

    public void time(int[] arr, int l, int r)
    {
        /*System.out.println("BEFORE SORT");
        for (int i=0; i<r; i++)
            System.out.print(arr[i]+" ");
        */
        long tStart = System.currentTimeMillis();
        sort(arr, l, r);
        long tEnd = System.currentTimeMillis();
        long tDelta = tEnd - tStart;
        double elapsedSeconds = tDelta / 1000.0;
        /*System.out.println("AFTER SORT");
        for (int i=0; i<r; i++)
            System.out.print(arr[i]+" ");
        */
        System.out.println(elapsedSeconds);


    }
}
