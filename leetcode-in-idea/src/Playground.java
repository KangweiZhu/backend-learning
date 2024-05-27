public class Playground {

    public static void main(String[] args) {
        System.out.println(isNumeric("111"));
        System.out.println(isNumeric("bbb"));
        System.out.println(isNumeric("b1bb"));
    }

    public static boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
