import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        try {
            Calc numCalc = new Calc();
            Scanner sc = new Scanner(System.in);
            System.out.println("Informe um número");
            int firstNum = sc.nextInt();
            System.out.println("Informe outro número");
            int secondNum = sc.nextInt();


            numCalc.division(firstNum, secondNum);
        }catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }catch (InputMismatchException e) {
            System.out.println("Você pôs uma letra, ao invés de um número");
        }
    }
}