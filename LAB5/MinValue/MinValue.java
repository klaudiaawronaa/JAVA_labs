package MinValue;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class MinValue {

    public List<Integer> list = new ArrayList<>();


    public MinValue(int N) throws Exception{
        if(N<0) {throw new MyException("Size can't be negative");}
        else {int i = 0;
            int element;
            while (i < N) {
                element = ThreadLocalRandom.current().nextInt(-1000000, 1000000 + 1);
                list.add(element);
                i++;
            }}

    }

    public MinValue() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(6);
        list.add(4);
        list.add(1);
        list.add(2);
    }

    public int solution(List<Integer> list) throws Exception {
        int number = 1;
        if (list.size() >= 1E5 || list.size() == 0) throw new MyException("N>1E5 OR EMPTY LIST");
        else {
            System.out.println(list);
            List<Integer> sortedlist = new ArrayList<>(list);

            for (Integer i : list) {
                if (i > 1000000 && i < -1000000) throw new MyException("MORE OR LESS THAN LIMITS");
                sortedlist.add(i);
            }
            //DODAJE TYLKO ELEMENTY Z PRZEDZIALU

            Collections.sort(sortedlist);


            for (int i = 0; i < sortedlist.size(); i++) {
                if (sortedlist.get(i) > 0) {
                    if (sortedlist.get(i) != 1) {
                        number = 1;
                        break;
                    } else {
                        while (sortedlist.get(i + 1) - sortedlist.get(i) < 2 && i < sortedlist.size() - 2) {
                            number = sortedlist.get(i) + 1;
                            i++;
                            if (i == sortedlist.size() - 2) number++;
                        }
                        break;
                    }
                }
            }
            return number;
        }


    }

    public static void veryLongComputation() throws InterruptedException {
        Thread.sleep(5000);
    }

}




