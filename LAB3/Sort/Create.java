package Sort;

public class Create {


    public void mergesort() {
        //MERGE SORT - PRZEZ SCALENIE
        MergeSort mergesort = new MergeSort(10000);
        System.out.println("MERGESORT");
        System.out.println("neg: ");
        mergesort.time(mergesort.neg, 0, mergesort.N - 1);
        System.out.println("opt: ");
        mergesort.time(mergesort.opt, 0, mergesort.N - 1);
        System.out.println("real: ");
        mergesort.time(mergesort.real, 0, mergesort.N - 1);
    }

    public void bubblesort() {
        //BUBBLESORT - BĄBELKOWE
        System.out.println("**********************************");
        BubbleSort bubblesort = new BubbleSort(10000);
        System.out.println("BUBBLESORT");
        System.out.println("neg: ");
        bubblesort.time(bubblesort.neg, 0, bubblesort.N - 1);
        System.out.println("opt: ");
        bubblesort.time(bubblesort.opt, 0, bubblesort.N - 1);
        System.out.println("real: ");
        bubblesort.time(bubblesort.real, 0, bubblesort.N - 1);
    }

    public void heapsort() {
        //HEAPSORT - KOPCOWANIE
        System.out.println("**********************************");
        HeapSort heapsort = new HeapSort(10000);
        System.out.println("HEAPSORT");
        System.out.println("neg: ");
        heapsort.time(heapsort.neg, 0, heapsort.N - 1);
        System.out.println("opt: ");
        heapsort.time(heapsort.opt, 0, heapsort.N - 1);
        System.out.println("real: ");
        heapsort.time(heapsort.real, 0, heapsort.N - 1);
    }

    public void shellsort() {
        //SHELLSORT - SORTOWANIE SHELLA
        System.out.println("**********************************");
        ShellSort shellsort = new ShellSort(10000);
        System.out.println("SHELLSORT");
        System.out.println("neg: ");
        shellsort.time(shellsort.neg, 0, shellsort.N - 1);
        System.out.println("opt: ");
        shellsort.time(shellsort.opt, 0, shellsort.N - 1);
        System.out.println("real: ");
        shellsort.time(shellsort.real, 0, shellsort.N - 1);
    }

    public void combsort() {
        //COMBSORT - SORTOWANIE GRZEBIENIOWE
        System.out.println("**********************************");
        CombSort combsort = new CombSort(10000);
        System.out.println("COMBSORT");
        System.out.println("neg: ");
        combsort.time(combsort.neg, 0, combsort.N - 1);
        System.out.println("opt: ");
        combsort.time(combsort.opt, 0, combsort.N - 1);
        System.out.println("real: ");
        combsort.time(combsort.real, 0, combsort.N - 1);
    }
}
