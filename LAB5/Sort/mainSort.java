package Sort;

public class mainSort {
    public static void main(String[] args) {


        /*****************************************************************************************/
        /**___________________________________SORT ZAD 5 _____________________________________**/


        /*optymistyczna - dla zbiorów uporządkowanych (z niewielką liczbą elementów nie na swoich
        miejscach
        typowa - dla zbiorów o losowym rozkładzie elementów
        pesymistyczna - dla zbiorów posortowanych odwrotnie*/
        Create createSort = new Create();

        createSort.bubblesort();
        createSort.combsort();
        createSort.heapsort();
        createSort.mergesort();
        createSort.shellsort();
    }
}
