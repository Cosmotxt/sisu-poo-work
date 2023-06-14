public class LowcaseException extends Exception{

    public static boolean isUpper(String w) {
        int i = 0;
        boolean tf = true;

        while(i < w.length() || tf) {
            if(!Character.isUpperCase(w.charAt(i))) {
                tf = false;
            }
            i++;
        }
        
        return tf;

    }

}
