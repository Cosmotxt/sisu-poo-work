import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        String cpf;
        String senha;
        double saldo;
        int option;
        int option2;
        String pass;
        double qnt;
        String email;
        Scanner input = new Scanner(System.in);

        System.out.println("O que você deseja fazer?\n1 - acessar meu e-mail. 2 - fazer saques e depositos na minha conta bancária");
        option = input.nextInt();
        input.nextLine();

        if(option == 2) {
            System.out.println("Informe seu CPF");
            cpf = input.nextLine();

            System.out.println("Informe sua senha");
            senha = input.nextLine();

            System.out.println("Informe seu saldo");
            saldo = input.nextDouble();

            Conta conta = new Conta(cpf, senha, saldo);

            do {

                System.out.println("O que deseja fazer?\n1 - Sacar. 2 - Depositar. 0 - Sair");
                option2 = input.nextInt();
                if (option2 == 1) {
                    System.out.println("Quanto você quer sacar?");
                    qnt = input.nextDouble();

                    do {
                        System.out.println("Informe sua senha para sacar");
                        input.nextLine();
                        pass = input.next();
                        conta.verificarSenha(pass);
                        System.out.println(conta.saca(qnt, pass));
                    } while (!conta.verificarSenha(pass));

                } else if (option2 == 2) {
                    System.out.println("Quanto você quer depositar?");
                    qnt = input.nextDouble();

                    do {
                        System.out.println("Informe sua senha para depositar");
                        input.nextLine();
                        pass = input.next();
                        conta.verificarSenha(pass);
                        System.out.println(conta.deposita(qnt, pass));
                    } while (!conta.verificarSenha(pass));
                }

            } while (option2 != 0);

        } else if (option == 1) {
            System.out.printf("E-mail:\n");
            email = input.nextLine();

            System.out.printf("Senha:\n");
            pass = input.nextLine();

            Email contaEmail = new Email("Renison", email, "123r@");

            if (contaEmail.verificarSenha(pass)) {
                System.out.println(contaEmail.mensagemSucesso());
            }else {
                System.out.println(contaEmail.mensagemFracasso());
            }




        }
    }
}
