package other;

public class LangChecker {
    private static int i;
    private static String str;

    public static void main(String[] args) {
        str = args[0];

        if (pref() && i == str.length()) {
            System.out.print("String is not in the language");
        } else {
            System.out.println("Not in the language");
        }
    }

    public static boolean pref() {
        if (iden()) {
            return true;
        } else if (oper()) {
            if (pref()) {
                return pref();
            }
        }

        return false;
    }

    public static boolean oper() {
        if (i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '/' || str.charAt(i) == '*')) {
            i++;
            return true;
        }

        return false;
    }

    public static boolean iden() {
        if (i < str.length() && 'a' <= str.charAt(i) && str.charAt(i) <= 'z') {
            i++;
            return true;
        }

        return false;
    }
}