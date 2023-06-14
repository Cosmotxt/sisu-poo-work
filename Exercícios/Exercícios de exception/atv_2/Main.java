import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            Comperison comperison = new Comperison();

            System.out.println("Digite uma palavra");
            String w1 = sc.nextLine();
            System.out.println("Digite outra palavra");
            String w2 = sc.nextLine();

            if(comperison.isEqual(w1, w2)) {
                System.out.println("a primeira palavra é maior que a segunda");
            }else {
                System.out.println("a segunda palavra é maior que a primeira");
            }
        }catch (NullPointerException e) {
            System.out.println("Erro: um dos textos é nulo");
        }

    }
}
