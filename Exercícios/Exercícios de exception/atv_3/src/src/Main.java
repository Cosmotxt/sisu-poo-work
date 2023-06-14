import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            String w;
            Scanner sc = new Scanner(System.in);
            w = sc.nextLine();
        }catch (LowcaseException e) {
            throw new LowcaseException();
        }
    }

}