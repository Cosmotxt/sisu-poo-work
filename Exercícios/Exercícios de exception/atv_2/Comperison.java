public class Comperison {
    public boolean isEqual(String w1, String w2) {

        if(w1.length() == 0 || w2.length() == 0) {
            throw new NullPointerException();
        }else if(w1.length() > w2.length()) {
            return true;
        }else {
            return false;
        }
    }

}
