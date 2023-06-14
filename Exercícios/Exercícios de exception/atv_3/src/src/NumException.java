public class NumException extends Exception{
    public static boolean isUpper(String w) {
        int i = 0;
        boolean tf = true;

        while(i < w.length() || tf) {
            if(!Character.isLetter(w.charAt(i))) {
                tf = false;
            }
            i++;
        }

        return tf;

    }
}
