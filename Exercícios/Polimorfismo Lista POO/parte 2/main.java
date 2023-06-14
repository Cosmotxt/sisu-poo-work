import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("Informa a quantidade de imóveis na imobiliária:");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Imobiliaria imobiliaria = new Imobiliaria();

        for(int i = 0; i <= imobiliaria.length; i++) {
            if (Math.random() >= 0.5) {
                imobiliaria.setConjuntoImoveis(new Casa());

            }else {
                imobiliaria[i] = new Apartamento();
            }
        }

    }
}
