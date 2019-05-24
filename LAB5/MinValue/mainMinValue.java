package MinValue;

public class mainMinValue {
    public static void main(String[] args) {
        /*****************************************************************************************/
        /**___________________________________MIN VALUE ZAD 2  _____________________________________**/



       // MinValue check1 = new MinValue(5);  // (int)1E5  ---> konstruktor sparametryzowany ktory losuje liczby
        // MinValue check2 = new MinValue(); // ----> konstruktor domyslny, pokazuje liste z polecenia, wynik: 5

        try {
            MinValue check1 = new MinValue(5);
            System.out.println(check1.solution(check1.list));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
