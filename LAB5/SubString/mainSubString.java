package SubString;

public class mainSubString {
    public static void main(String[] args) {

        /*****************************************************************************************/
        /**___________________________________SUBSTRING ZAD 3  _____________________________________**/

        SubString x = new SubString();
        try {
            System.out.println(x.SubstringFunction("abc", "ab"));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
