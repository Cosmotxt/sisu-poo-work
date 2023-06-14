public class Calc {
    public int division(int x, int y) {
        if (y == 0) {
            throw new ArithmeticException("Amigão, por 0 não dá");
        }else {
            return x/y;
        }
    }
}
