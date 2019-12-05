/*
    Aufgabe 4) Rekursion mit Strings
*/
public class Aufgabe4 {

    private static String insertCharValue(String text) {
        char symbol = text.charAt(0);
        int ascii = (int) symbol;
        if (text.length()==1) return ("("+ascii+symbol+")");
        return ("("+ascii+symbol+")")+insertCharValue(text.substring(1,text.length()));
    }
    
    private static String removeCharsInString(String text) {
        char first = text.charAt(0);
        String saved = "";
        text=text.substring(1);
        if (text.length()==0) return "";
        if (text.length()==1) {
            if (first==text.charAt(0)) return "";
            return text;
        }
        if (first!=text.charAt(0)) {
            saved = text.substring(0,1);
        }
        text = first+text.substring(1);
        return saved+removeCharsInString(text);
    }

    private static String shiftMaxCharRight(String text) {
        if (text.length()<=1) return text;
        if (text.length()==2){
            if (text.charAt(1)>text.charAt(0)){
                return text;
            } else {
                return ""+text.charAt(1)+text.charAt(0);
            }
        }
        char current = text.charAt(0);

        text = shiftMaxCharRight(text.substring(1));

        if (current>text.charAt(text.length()-1)){
            return text+current;
        } else {
            return current+text;
        }
    }
    
    public static void main(String[] args) {
        /*
        System.out.println(insertCharValue("hallo"));
        System.out.println(insertCharValue("a!"));
        System.out.println(insertCharValue("Ein Test"));
        System.out.println();
        
        System.out.println(removeCharsInString("testtrompete"));
        System.out.println(removeCharsInString("test"));
        System.out.println(removeCharsInString("t"));
        System.out.println(removeCharsInString("angabe"));
        System.out.println();
        */
        System.out.println(shiftMaxCharRight("acmbwxdzfjdk"));
        System.out.println(shiftMaxCharRight(""));
        System.out.println(shiftMaxCharRight("za"));
        System.out.println(shiftMaxCharRight("a"));
        System.out.println(shiftMaxCharRight("habcdefg"));

        assert (insertCharValue("hallo").equals("(104h)(97a)(108l)(108l)(111o)"));
        assert (insertCharValue("a!").equals("(97a)(33!)"));
        assert (insertCharValue("Ein Test").equals("(69E)(105i)(110n)(32 )(84T)(101e)(115s)(116t)"));
        
        assert (removeCharsInString("testtrompete").equals("esrompee"));
        assert (removeCharsInString("test").equals("es"));
        assert (removeCharsInString("t").equals(""));
        assert (removeCharsInString("angabe").equals("ngbe"));
        
        assert (shiftMaxCharRight("acmbwxdzfjdk").equals("acmbwxdfjdkz"));
        assert (shiftMaxCharRight("").equals(""));
        assert (shiftMaxCharRight("za").equals("az"));
        assert (shiftMaxCharRight("a").equals("a"));
        assert (shiftMaxCharRight("habcdefg").equals("abcdefgh"));
        assert (shiftMaxCharRight("aybz").equals("aybz"));
    }
}
