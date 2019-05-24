package SubString;

import static java.lang.Math.abs;

public class SubString {

    public int SubstringFunction(String a, String b) throws Exception
    {
        System.out.println(a);
        System.out.println(b);

        int iterator=1;
        String stringIterated = a;
        if(a.isEmpty() || b.isEmpty() || b.contains(a)==false ||abs(a.length()-b.length())<iterator)
            return -1;
        else {
            while (stringIterated.contains(b) == false) {
                iterator = iterator + 1;
                 stringIterated=  stringIterated+ a;
            }
            return iterator;

        }

    }
}


