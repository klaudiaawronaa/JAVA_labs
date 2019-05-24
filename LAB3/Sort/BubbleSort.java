package Sort;
import java.util.Random;

public class BubbleSort {
    public int N;
    public int[] opt;
    public int[] neg;
    public int[] real;

    void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public BubbleSort(int N)
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


    static void bubbleSort(int arr[], int n)
    {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++)
        {
            swapped = false;
            for (j = 0; j < n - i - 1; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    // swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // IF no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }
    public void time(int[] arr, int l, int r)
    {
        /*System.out.println("BEFORE SORT");
        for (int i=0; i<r; i++)
            System.out.print(arr[i]+" ");
        */
        long tStart = System.currentTimeMillis();
        bubbleSort(arr,N);
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
